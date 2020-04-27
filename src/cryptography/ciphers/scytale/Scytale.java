package cryptography.ciphers.scytale;

import cryptography.Mode;

public class Scytale {

	public static void main(String[] args) {
	}

	/**
	 * Scytale cipher
	 * 
	 * @see <a href="https://en.wikipedia.org/wiki/Scytale</a>
	 * @param input    Text to cipher / decipher
	 * @param mode     encrypt or decrypt mode
	 * @param diameter Baton/cylinder diameter
	 * @return String based on selected mode
	 */
	public static String scytale(String input, Mode mode, int diameter) {
		String output = "";
		final char NULLCHAR = '\u0000';
		char[][] rod;
		int width = diameter;
		int height = input.length() % width == 0 ? input.length() / width : input.length() / width + 1;

		if (mode == Mode.ENCRYPT) {
			rod = new char[height][width];
			int index = 0;
			char[] text = input.toCharArray();
			for (int i = 0; i < height; i++) {
				for (int j = 0; j < width; j++) {
					rod[i][j] = index < text.length ? text[index] : NULLCHAR;
					index++;
				}
			}
			for (int j = 0; j < width; j++) {
				for (int i = 0; i < height; i++) {
					output += rod[i][j];
				}
			}
		}

		if (mode == Mode.DECRYPT) {
			rod = new char[height][width];
			int index = 0;
			char[] text = input.toCharArray();
			for (int j = 0; j < width; j++) {
				for (int i = 0; i < height; i++) {
					rod[i][j] = index < input.length() ? text[index] : NULLCHAR;
					index++;
				}
			}
			for (int i = 0; i < height; i++) {
				for (int j = 0; j < width; j++) {
					output += rod[i][j];
				}
			}
		}

		return output.replace("\u0000", "");
	}

}
