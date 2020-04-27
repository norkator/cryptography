package cryptography.ciphers.chaocipher;

import java.util.LinkedList;

import cryptography.Mode;

public class Chaocipher {

	public static void main(String[] args) {
	}

	public static String chaocipher(String input, Mode mode, String alpha1, String alpha2) {
		String output = "";
		input = input.replaceAll(" ", "");
		LinkedList<Character> cipher, plain;

		cipher = new LinkedList<>();
		plain = new LinkedList<>();
		for (int i = 0; i < alpha1.length(); i++) {
			cipher.addLast(alpha1.charAt(i));
			plain.addLast(alpha2.charAt(i));
		}

		if (mode == Mode.ENCRYPT) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < input.length(); i++) {
				char plainChar = input.charAt(i);
				int a = plain.indexOf(plainChar);
				char cipherChar = cipher.get(a);
				sb.append(cipherChar);
				int ind = cipher.indexOf(cipherChar);
				for (int e = 0; e < ind; e++) {
					char ch = cipher.remove(0);
					cipher.addLast(ch);
				}
				char ch = cipher.remove(1);
				cipher.add(13, ch);

				ind = plain.indexOf(plainChar);
				for (int e = 0; e < ind; e++) {
					ch = plain.remove(0);
					plain.addLast(ch);
				}
				ch = plain.remove(0);
				plain.addLast(ch);
				ch = plain.remove(2);
				plain.add(13, ch);
			}
			output = sb.toString();
		}

		if (mode == Mode.DECRYPT) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < input.length(); i++) {
				char cipherChar = input.charAt(i);
				int a = cipher.indexOf(cipherChar);
				char plainChar = plain.get(a);
				sb.append(plainChar);
				int ind = cipher.indexOf(cipherChar);
				for (int d = 0; d < ind; d++) {
					char ch = cipher.remove(0);
					cipher.addLast(ch);
				}
				char ch = cipher.remove(1);
				cipher.add(13, ch);

				ind = plain.indexOf(plainChar);
				for (int d = 0; d < ind; d++) {
					ch = plain.remove(0);
					plain.addLast(ch);
				}
				ch = plain.remove(0);
				plain.addLast(ch);
				ch = plain.remove(2);
				plain.add(13, ch);
			}
			output = sb.toString();
		}

		return output;
	}

}
