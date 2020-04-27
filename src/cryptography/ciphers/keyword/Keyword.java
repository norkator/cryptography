package cryptography.ciphers.keyword;

import java.util.HashMap;

import cryptography.Mode;

public class Keyword {

	public static void main(String[] args) {
	}

	public static String keyword(String input, String key, Mode mode) {

		input = input.toLowerCase();
		char[] table = createTable(removeDuplicates(key.toLowerCase()));
		StringBuilder output = new StringBuilder();

		if (mode == Mode.ENCRYPT) {
			for (int i = 0; i < input.length(); i++) {
				output.append(getChar(input.charAt(i), table, true, true));
			}
		}

		if (mode == Mode.DECRYPT) {
			for (int i = 0; i < input.length(); i++) {
				output.append(getChar(input.charAt(i), table, true, false));
			}
		}

		return output.toString().toUpperCase();
	}

	private static char[] createTable(String key) {
		final char NULLCHAR = '\u0000';
		char[] ALPHABET = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		char[] table = new char[26];
		char[] alpha = ALPHABET.clone();
		char[] keyArr = key.toCharArray();
		for (int i = 0; i < keyArr.length; i++) {
			table[i] = keyArr[i];
			for (int j = 0; j < 26; j++) {
				if (alpha[j] == table[i]) {
					alpha[j] = NULLCHAR;
					break;
				}
			}
		}
		int index = keyArr.length;
		for (int i = 0; i < 26; i++) {
			if (alpha[i] != NULLCHAR) {
				table[index] = alpha[i];
				index++;
			}
		}
		return table;
	}

	private static String removeDuplicates(String in) {
		HashMap<Character, Boolean> used = new HashMap<Character, Boolean>();
		char[] letters = in.toCharArray();
		String out = "";
		for (char letter : letters) {
			if (!used.containsKey(letter)) {
				out += letter;
				used.put(letter, true);
			}
		}
		return out;
	}

	private static String getChar(char in, char[] table, boolean keepCharacters, boolean encode) {
		char[] ALPHABET = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		char loweredIn = lowerChar(in);
		int index = getIndex(loweredIn, encode, table);
		if (index == -1) {
			if (keepCharacters)
				return charToString(in);
			else
				return "";
		} else if (encode) {
			return charToString(table[index]);
		} else {
			return charToString(ALPHABET[index]);
		}
	}

	private static char lowerChar(char in) {
		return Character.toLowerCase(in);
	}

	private static String charToString(char in) {
		return String.valueOf(in);
	}

	private static int getIndex(char in, boolean encode, char[] table) {
		char[] ALPHABET = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		if (encode) {
			for (int i = 0; i < 26; i++) {
				if (ALPHABET[i] == in)
					return i;
			}
			return -1;
		} else {
			for (int i = 0; i < 26; i++) {
				if (table[i] == in)
					return i;
			}
			return -1;
		}
	}

}
