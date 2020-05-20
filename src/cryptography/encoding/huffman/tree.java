package cryptography.encoding.huffman;

public class tree implements Comparable<tree> {

	String ch;
	int freq;
	int left;
	int right;
	String code;

	public int compareTo(tree other) {
		return String.valueOf(freq).compareTo(String.valueOf(other.freq));
	}

}
