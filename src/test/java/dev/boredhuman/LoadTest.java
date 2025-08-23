package dev.boredhuman;

import spirv.instructions.InstructionRegistry;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class LoadTest {
	public static void main(String[] args) throws Throwable {
		String validatorPath;
		if (args.length > 0) {
			validatorPath = args[0];
			System.out.printf("Using validator located at %s\n", validatorPath);
		} else {
			validatorPath = null;
			System.out.println("Validator path not passed.");
		}

		File file = new File("spirv-repository.zip");
		if (!file.exists()) {
			LoadTest.loadRepository();
		}

		// preload classes to not affect perf timing
		long supportedInstructionCount = Arrays.stream(InstructionRegistry.INSTRUCTION_REGISTRY).filter(Objects::nonNull).count();

		System.out.printf("Supported instruction count %d\n", supportedInstructionCount);

		ZipFile zipFile = new ZipFile(file);

		List<? extends ZipEntry> zipEntries = Collections.list(zipFile.entries());

		zipEntries.removeIf(e -> !e.getName().endsWith(".spv"));

		List<byte[]> spirvBinaries = zipEntries.stream()
			// .parallel()
			.map(e -> {
				try {
 					return zipFile.getInputStream(e);
				} catch (Throwable err) {
					throw new RuntimeException(err);
				}
			})
			.map(Util::asByteArray)
			.collect(Collectors.toList());

		zipFile.close();

		System.out.println("loaded binaries");

		System.out.println("parsing binaries");

		List<SpirvBinary> loadedBinaries = spirvBinaries.stream().parallel().map(SpirvBinaryLoader::loadBinary).collect(Collectors.toList());

		System.out.println("Testing conversion to module");

		List<SpirvModule> modules = loadedBinaries.stream().parallel().map(SpirvModule::new).collect(Collectors.toList());

		if (validatorPath == null) {
			return;
		}

		Queue<BinaryCheck> mismatchedBinaries = new ConcurrentLinkedQueue<>();

		IntStream.range(0, loadedBinaries.size()).parallel().forEach(index -> {
			byte[] original = spirvBinaries.get(index);

			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			SpirvBinary spirvBinary = loadedBinaries.get(index);
			SpirvBinaryWriter.write(bos, spirvBinary);
			byte[] data = bos.toByteArray();

			if (!Arrays.equals(data, original)) {
				mismatchedBinaries.add(new BinaryCheck(original, data, index));
			}
		});

		System.out.printf("mismatch binaries count %d matching binaries count %d\n", mismatchedBinaries.size(), loadedBinaries.size() - mismatchedBinaries.size());

		System.out.println("Validating mismatches");

		mismatchedBinaries.stream().parallel().forEach(binaryCheck -> {
			try {
				{
					Process process = new ProcessBuilder()
						.command(validatorPath, "-")
						.redirectOutput(ProcessBuilder.Redirect.INHERIT)
						.start();

					OutputStream out = process.getOutputStream();
					out.write(binaryCheck.source);
					out.close();

					process.waitFor();
					// original failed validation
					if (process.exitValue() != 0) {
						System.out.printf("source for %s was invalid\n", zipEntries.get(binaryCheck.index).getName());

						return;
					}
				}

				{
					Process process = new ProcessBuilder()
						.command(validatorPath, "-")
						.redirectOutput(ProcessBuilder.Redirect.INHERIT)
						.start();

					OutputStream out = process.getOutputStream();
					out.write(binaryCheck.reparsed);
					out.close();

					process.waitFor();
					// original failed validation
					if (process.exitValue() != 0) {
						throw new RuntimeException(String.format("Reparsed binary failed validate %s", zipEntries.get(binaryCheck.index).getName()));
					}
				}
			} catch (Throwable err) {
				throw new RuntimeException("Failed to validate", err);
			}
		});

		System.out.println("reparsed binaries were all valid");
	}

	private static void loadRepository() {
		try {
			System.out.println("Downloading spirv binary repositry this may take a minute");

			URL repoLink = new URL("https://github.com/LunarG/SPIRV-Database/archive/refs/heads/main.zip");
			try (InputStream repoStream = repoLink.openStream()) {

				try (FileOutputStream fos = new FileOutputStream("spirv-repository.zip")) {
					byte[] buf = new byte[4096];
					int read;
					while ((read = repoStream.read(buf)) != -1) {
						fos.write(buf, 0, read);
					}
				}
			}

			System.out.println("finished pulling repository");
		} catch (Throwable err) {
			throw new RuntimeException("Failed to load repostiry", err);
		}
	}

	public static class BinaryCheck {
		public byte[] source;
		public byte[] reparsed;
		public int index;

		public BinaryCheck(byte[] source, byte[] reparsed, int index) {
			this.source = source;
			this.reparsed = reparsed;
			this.index = index;
		}
	}
}
