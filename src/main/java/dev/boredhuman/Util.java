package dev.boredhuman;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public class Util {
	public static byte[] asByteArray(InputStream stream) {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();

		byte[] buf = new byte[4096];

		try {
			int read;
			while ((read = stream.read(buf)) != -1) {
				bos.write(buf, 0, read);
			}
		} catch (Throwable err) {
			throw new RuntimeException("Failed to read input stream", err);
		}

		return bos.toByteArray();
	}
}
