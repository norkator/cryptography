package cryptography.ciphers.autokey;

import cryptography.Mode;
import cryptography.ciphers.vigenere.Vigenere;

public class Autokey {

	public static void main(String[] args) {
	}

	public static String autokey(String input, String key, Mode mode) {
		StringBuilder output = new StringBuilder();

		if (mode == Mode.ENCRYPT) {
			output = new StringBuilder(Vigenere.vigenere(input, key + input, Mode.ENCRYPT));
		}

		if (mode == Mode.DECRYPT) {
			int[] shiftKey = new int[(input + key).length()];
			int index = key.length();
			for (int i = 0; i < index; i++) {
				shiftKey[i] = findIndex(key.charAt(i));
			}
			String cur;
			for (int i = 0; i < input.length(); i++) {
				cur = getChar(input.charAt(i), shiftKey[i], false);
				output.append(cur);
				shiftKey[index] = findIndex(cur.charAt(0));
				index++;
			}
		}

		return output.toString().toUpperCase();
	}

	// Find index from alphabet
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

	private static String charToString(char in) {
		return String.valueOf(in);
	}

	private static String getChar(char in, int shift, boolean encode) {
		char[] ALPHABET = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		int startingPosition = findIndex(in);
		if (startingPosition == -1) {
			return charToString(in);
		}
		return charToString(ALPHABET[getNewIndex(startingPosition, shift, encode)]);
	}

	private static int getNewIndex(int startIndex, int shift, boolean encode) {
		int endIndex;
		if (!encode)
			shift *= -1;
		endIndex = (startIndex + shift) % 26;
		if (endIndex < 0)
			endIndex += 26;
		return endIndex;
	}

}
