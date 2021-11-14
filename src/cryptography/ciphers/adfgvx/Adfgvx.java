package cryptography.ciphers.adfgvx;

import java.awt.Point;

import cryptography.Mode;
import cryptography.encoding.vicSequencing.VICSequencing;

public class Adfgvx {

	private static String[][] substitute;
	private static String[] code = {"A", "D", "F", "G", "V", "X"};

	public static void main(String[] args) {
	}


	//	KEY size must be < 10
//	public static String adfgvx(String inputText, String key, final Mode mode) {
	public static String adfgvx(String inputText, String key1, String key2, final Mode mode) {
		if (key1.length() >= 10 || key2.length() >= 10) {
			return "Key size larger than 10, choose smaller key";
		}
		try {
			inputText = inputText.toLowerCase();
			String output = null;

			String substitute[][] = polibiusSquare(key1);

			if (mode == Mode.ENCRYPT) {
				Point p;
				StringBuilder res = new StringBuilder();
				inputText = inputText.toLowerCase().replace("/[^a-z0-9]/g", "");
				for (int i = 0; i < inputText.length(); i++) {
					if (inputText.charAt(i) == ' ') {
						res.append(inputText.charAt(i));
					} else {
						p = findPos(inputText.charAt(i));
						res.append(code[p.x]).append(code[p.y]);
					}
				}
				output = res.toString();

				return columnarTransposition(output, key2);

			}
			if (mode == Mode.DECRYPT) {
				StringBuilder res = new StringBuilder();
				Point p;

				String input = reverseColTranspose(inputText, key2);
				for (int i = 0; i < input.length(); ) {
					if (input.charAt(i) == ' ') {
						res.append(input.charAt(i));
						i++;
					} else {
						String codeInt = "ADFGVX".toLowerCase();
						p = new Point(codeInt.indexOf(input.substring(i, i + 1)),
							codeInt.indexOf(input.substring(i + 1, i + 2)));
						res.append(substitute[p.x][p.y]);
						i = i + 2;
					}
				}
				output = res.toString().toUpperCase();
			}

			return output;
		} catch (Exception e) {
			return e.toString();
		}
	}

	private static String[][] polibiusSquare(String key) {
		substitute = new String[6][6];
		String temp = key + "abcdefghijklmnopqrstuvwxyz0123456789";
		String result = "";
		for (int i = 0; i < temp.length(); i++) {
			if (!result.contains(String.valueOf(temp.charAt(i)))) {
				result += String.valueOf(temp.charAt(i));
			}
		}

		for (int a = 0; a < 6; a++) {
			for (int b = 0; b < 6; b++) {
				substitute[a][b] = String.valueOf(result.charAt(a * 6 + b));
			}
		}


		return substitute;
	}

	private static Point findPos(char c) {
		boolean found = false;
		int i = 0;
		int j = 0;
		while (!found && i < substitute.length) {
			j = 0;
			while (!found && j < substitute[i].length) {
				if (substitute[i][j].indexOf(c) == 0)
					found = true;
				else
					j++;
			}
			if (!found)
				i++;
		}
		return new Point(i, j);
	}

	private static String columnarTransposition(String text, String key) {
		String transposeKey = VICSequencing.encode(key.toUpperCase());
		final int row = (int) Math.ceil((float) text.length() / (float) key.length());
		String curr;

		String[] temp = new String[key.length()];
		for (int a = 0; a < transposeKey.length(); a++) {
			int index = Character.getNumericValue(transposeKey.charAt(a));

			curr = "";
			for (int b = 0; b < row; b++) {
				if (b * key.length() + a < text.length()) {
					curr += text.charAt(b * key.length() + a);
				}
			}

			temp[index - 1] = curr;

		}
		String res = "";

		for (int a = 0; a < key.length(); a++) {
			res += temp[a];
		}


		return res;
	}

	private static String reverseColTranspose(String text, String key) {
		final int row = (int) Math.ceil((float) text.length() / (float) key.length());
		final int col = key.length();
		int toPad = row * col - text.length();

		String transposeKey = VICSequencing.encode(key.toUpperCase());

		String[] temp = new String[col];

		int textPointer = 0;
		for (int a = 1; a <= col; a++) {
			for (int b = 0; b < col; b++) {
				int index = Character.getNumericValue(transposeKey.charAt(b));
				if (a == index) {
					String curr = "";
					if (b >= col - toPad) {
						curr = text.substring(textPointer, textPointer + row - 1) + " ";
						textPointer += row - 1;
					} else {
						curr = text.substring(textPointer, textPointer + row);
						textPointer += row;
					}
					temp[b] = curr;
				}
			}
		}

		String res = "";

		for (int a = 0; a < row; a++) {
			for (int b = 0; b < col; b++) {
				if (temp[b].charAt(a) != ' ') {
					res += temp[b].charAt(a);
				}
			}
		}

		return res;
	}
}
