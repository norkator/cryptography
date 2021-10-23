package cryptography.ciphers.adfgvx;

import java.awt.Point;

import cryptography.Mode;

public class Adfgvx {

	private static String[][] substitute = { { "y", "e", "n", "2", "9", "r" }, { "x", "8", "h", "t", "o", "s" },
			{ "k", "5", "4", "m", "0", "j" }, { "u", "f", "l", "z", "3", "a" }, { "d", "b", "v", "c", "6", "p" },
			{ "g", "i", "q", "w", "1", "7" } };
	private static String[] code = { "A", "D", "F", "G", "V", "X" };

	public void main(String[] args) {
	}

	public static String adfgvx(String inputText, String key ,final Mode mode) {
		try {
			inputText = inputText.toLowerCase();
			String output = null;

			polibiusSquare(key);

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
				System.out.println(output);
			}

			if (mode == Mode.DECRYPT) {
				StringBuilder res = new StringBuilder();
				Point p;
				for (int i = 0; i < inputText.length();) {
					if (inputText.charAt(i) == ' ') {
						res.append(inputText.charAt(i));
						i++;
					} else {
						String codeInt = "ADFGVX".toLowerCase();
						p = new Point(codeInt.indexOf(inputText.substring(i, i + 1)),
								codeInt.indexOf(inputText.substring(i + 1, i + 2)));
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
	
	private static void polibiusSquare(String key) {
		substitute = new String[6][6];
		String temp = key+"abcdefghijklmnopqrstuvwxyz0123456789";
		String result = "";
	    for (int i = 0; i < temp.length(); i++) {
	        if(!result.contains(String.valueOf(temp.charAt(i)))) {
	            result += String.valueOf(temp.charAt(i));
	        }
	    }
	    
	    for(int a=0;a<6;a++) {
	    	for(int b=0;b<6;b++) {
	    		substitute[a][b] = String.valueOf(result.charAt(a*6+b));
	    	}
	    }
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

}
