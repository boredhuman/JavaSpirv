package spirv.instructions;

public class StringData {
	private final String string;
	private final int wordCount;

	public StringData(String string, int wordCount) {
		this.string = string;
		this.wordCount = wordCount;
	}

	public String getString() {
		return this.string;
	}

	public int getWordCount() {
		return this.wordCount;
	}
}
