package cryptography.ciphers.beaufort;

public class Beaufort {

	public static void main(String[] args) {
	}

	public static String beaufort(String input, String key) {

		input = input.toLowerCase();
		StringBuilder output = new StringBuilder();
		char[] plain = input.toCharArray();
		char[] keyw = key.toCharArray();
		int keyLength = keyw.length;
		int index = 0;

		for (char c : plain) {
			if (findIndex(c) != -1) {
				output.append(getCharBeaufort(c, keyw[index]));
				index = (index + 1) % keyLength;
			}
		}

		return output.toString().toUpperCase();
	}

	private static int findIndex(char in) {
		char[] ALPHABET = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		in = lowerChar(in);
		for (int i = 0; i < 26; i++) {
			if (ALPHABET[i] == in)
				return i;
		}
		return -1;
	}

	private static char lowerChar(char in) {
		return Character.toLowerCase(in);
	}

	private static char getCharBeaufort(char plain, char key) {
		char[] ALPHABET = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		int plainIndex = findIndex(plain);
		int keyIndex = findIndex(key);
		return ALPHABET[(keyIndex - plainIndex + 26) % 26];
	}

}
