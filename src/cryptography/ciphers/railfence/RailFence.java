package cryptography.ciphers.railfence;

import cryptography.Mode;

public class RailFence {

	public static void main(String[] args) {
	}

	/**
	 * Rail Fence cipher
	 * 
	 * @param input inputText Text to cipher / decipher
	 * @param mode  encrypt or decrypt mode
	 * @param key   Number value
	 * @return String based on selected mode
	 */
	public static String railFence(String input, Mode mode, int key) {

		input = input.toLowerCase();

		String output = "";
		final char NULLCHAR = '\u0000';
		int rails = key;
		char[][] fence;

		if (mode == Mode.ENCRYPT) {
			fence = new char[rails][input.length()];
			char[] m = input.toCharArray();
			int row = 0;
			boolean down = true;
			for (int col = 0; col < input.length(); col++) {
				fence[row][col] = m[col];
				if (down) {
					if (row < rails - 1) {
						row++;
					} else {
						down = false;
						row--;
					}
				} else {
					if (row > 0) {
						row--;
					} else {
						down = true;
						row++;
					}
				}
			}
			for (int i = 0; i < rails; i++) {
				for (int j = 0; j < fence[i].length; j++) {
					if (fence[i][j] != NULLCHAR)
						output += fence[i][j];
				}
			}
		}

		if (mode == Mode.DECRYPT) {
			String placeholder = "";
			char phChar = 'X';
			for (int i = 0; i < input.length(); i++) {
				placeholder += phChar;
			}
			fence = new char[rails][input.length()];
			char[] m = placeholder.toCharArray();
			int row = 0;
			boolean down = true;
			for (int col = 0; col < input.length(); col++) {
				fence[row][col] = m[col];
				if (down) {
					if (row < rails - 1) {
						row++;
					} else {
						down = false;
						row--;
					}
				} else {
					if (row > 0) {
						row--;
					} else {
						down = true;
						row++;
					}
				}
			}
			char[] n = input.toCharArray();
			int index = 0;
			for (int i = 0; i < rails; i++) {
				for (int j = 0; j < input.length(); j++) {
					if (fence[i][j] == phChar) {
						fence[i][j] = n[index];
						index++;
					}
				}
			}
			for (int j = 0; j < fence[0].length; j++) {
				for (int i = 0; i < rails; i++) {
					if (fence[i][j] != NULLCHAR)
						output += fence[i][j];
				}
			}
		}

		return output.replace("\u0000", "");
	}

}
