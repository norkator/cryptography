package cryptography.ciphers.vigenere;

import cryptography.Mode;

public class Vigenere {

	public static void main(String[] args) {
	}

	public static String vigenere(String input, String key, Mode mode) {
		String output = null;
		input = input.toUpperCase();

		if (mode == Mode.ENCRYPT) {
			StringBuilder res = new StringBuilder();
			for (int i = 0, j = 0; i < input.length(); i++) {
				char c = input.charAt(i);
				if (c < 'A' || c > 'Z')
					continue;
				res.append((char) ((c + key.charAt(j) - 2 * 'A') % 26 + 'A'));
				j = ++j % key.length();
			}
			output = res.toString();
		}

		if (mode == Mode.DECRYPT) {
			StringBuilder res = new StringBuilder();
			for (int i = 0, j = 0; i < input.length(); i++) {
				char c = input.charAt(i);
				if (c < 'A' || c > 'Z')
					continue;
				res.append((char) ((c - key.charAt(j) + 26) % 26 + 'A'));
				j = ++j % key.length();
			}
			output = res.toString();
		}

		return output;
	}

}
