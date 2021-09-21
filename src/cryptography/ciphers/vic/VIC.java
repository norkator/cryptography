package cryptography.ciphers.vic;

import cryptography.encoding.VICsequencing.VICsequencing;

public class VIC {
	public static String keyGen(String input, int date, int personalNo, int key) {
		input = input.toUpperCase().replaceAll(" ", "");

		String lineA = String.valueOf(key);
		String lineB = String.valueOf(date);
		String lineC = modSub(lineA, lineB);
		String lineD = input.substring(0, 20);
		String lineE = VICsequencing.encode(lineD.substring(0, 10)) + VICsequencing.encode(lineD.substring(10));
		String lineF = chainAddition(lineC, 5) + "1234567890";
		String lineG = modAdd(lineE.substring(0, 10), lineF.substring(0, 10));
		String lineH = encodeByReplacing(lineG, lineE.substring(10), lineF.substring(10));
		String lineJ = VICsequencing.encode(lineH);
		String chainAdd50Res = chainAddition(lineH, 50);
		String lineK = chainAdd50Res.substring(10, 20);
		String lineL = chainAdd50Res.substring(20, 30);
		String lineM = chainAdd50Res.substring(30, 40);
		String lineN = chainAdd50Res.substring(40, 50);
		String lineP = chainAdd50Res.substring(50, 60);
		String block = columnarTranspose(chainAdd50Res.substring(10), lineJ);
		String lineQ = block.substring(0, Character.getNumericValue(lineP.charAt(8)) + personalNo);
		String lineR = block.substring(Character.getNumericValue(lineP.charAt(8)) + personalNo, Character.getNumericValue(lineP.charAt(8)) + personalNo + Character.getNumericValue(lineP.charAt(9)) + personalNo);
		String lineS = VICsequencing.encode(lineP);

		// System.out.println(lineA);
		// System.out.println(lineB);
		// System.out.println(lineC);
		// System.out.println(lineD);
		// System.out.println(lineE);
		// System.out.println(lineF);
		// System.out.println(lineG);
		// System.out.println(lineH);
		// System.out.println(lineJ);
		// System.out.println(lineK);
		// System.out.println(lineL);
		// System.out.println(lineM);
		// System.out.println(lineN);
		// System.out.println(lineP);
		// System.out.println(lineQ);
		// System.out.println(lineR);
		// System.out.println(lineS);
		return lineS;
	}

	public static String encrypt(String input, String phrase, String inputForKey, int date, int personalNo, int keyGroup) {
		input = input.toUpperCase().replaceAll(" ", "");
		phrase = phrase.toUpperCase();

		String output = "";
		char[] key = keyGen(inputForKey, date, personalNo, keyGroup).toCharArray();
		char[] row = new char[]{' ', '0', (char) ((personalNo) + '0')};
		char[][] table = genTable(phrase);


		// for(int a=0;a<table.length;a++) {
		// 	for(int b=0;b<table[a].length;b++) {
		// 		System.out.print(table[a][b]+" ");
		// 	}
		// 	System.out.println();
		// }

		int[] pos;
		for (int a = 0; a < input.length(); a++) {
			if (input.charAt(a) != ' ') {
				pos = findLetterInTable(table, input.charAt(a));
				output += String.valueOf(row[pos[0]]) + String.valueOf(key[pos[1]]);
			}

		}
		output = output.replaceAll("\\s", "");
		return output;
	}

	public static String decrypt(String input, String phrase, String inputForKey, int date, int personalNo, int keyGroup) {
		input = input.toUpperCase().replaceAll(" ", "");
		;
		phrase = phrase.toUpperCase();

		int gap1 = phrase.indexOf(" ");
		int gap2 = phrase.indexOf(" ", gap1 + 1);

		String output = "";
		char[] key = keyGen(inputForKey, date, personalNo, keyGroup).toCharArray();
		char[] row = new char[]{' ', key[gap1], key[gap2]};
		char[][] table = genTable(phrase);


		int a = 0;
		while (a < input.length()) {
			int selRow = 0, selCol = 0;

			if (input.charAt(a) == row[1]) {
				selRow = 1;
			} else if (input.charAt(a) == row[2]) {
				selRow = 2;
			} else {
				selRow = 0;
			}

			if (selRow != 0) {
				a++;
			}

			for (int b = 0; b < key.length; b++) {
				if (input.charAt(a) == key[b]) {
					selCol = b;
					break;
				}
			}

			output += table[selRow][selCol];
			a++;
		}

		return output;
	}

	public static char[][] genTable(String phrase) {
		char[][] table = new char[3][10];
		table[0] = phrase.toCharArray();

		int index = 0;
		for (char a = 'A'; a <= 'Z'; a++) {
			if (index >= 10) {
				if (!phrase.contains(String.valueOf(a))) {
					table[2][index % 10] = a;
					index++;
				}
			} else {
				if (!phrase.contains(String.valueOf(a))) {
					table[1][index % 10] = a;
					index++;
				}
			}
		}

		table[2][8] = '.';
		table[2][9] = ',';

		return table;
	}

	public static int[] findLetterInTable(char[][] table, char val) {
		for (int a = 0; a < table.length; a++) {
			for (int b = 0; b < table[a].length; b++) {
				if (val == table[a][b]) {
					return new int[]{a, b};
				}
			}
		}
		return null;
	}


	public static String modSub(String str1, String str2) {
		String res = "";
		for (int a = 0; a < str1.length(); a++) {
			int num1 = Character.getNumericValue(str1.charAt(a));
			int num2 = Character.getNumericValue(str2.charAt(a));

			int val = (num1 >= num2) ? num1 - num2 : num1 - num2 + 10;
			res = res + String.valueOf(val);
		}
		return res;
	}

	public static String modAdd(String str1, String str2) {
		String res = "";
		for (int a = 0; a < str1.length(); a++) {
			int num1 = Character.getNumericValue(str1.charAt(a));
			int num2 = Character.getNumericValue(str2.charAt(a));

			int val = (num1 + num2) % 10;
			res = res + String.valueOf(val);
		}
		return res;
	}

	public static String encodeByReplacing(String str, String key, String aid) {
		String res = str;
		for (int a = 0; a < aid.length(); a++) {
			for (int b = 0; b < str.length(); b++) {
				if (str.charAt(b) == aid.charAt(a)) {
					res = res.substring(0, b) + key.charAt(a) + res.substring(b + 1);
				}
			}
		}
		return res;
	}

	public static String chainAddition(String num, int length) {
		String res = num;

		for (int a = 0; a < length; a++) {
			res = res + ((Character.getNumericValue(res.charAt(a)) + Character.getNumericValue(res.charAt(a + 1))) % 10);
		}

		return res;
	}

	public static String columnarTranspose(String str, String key) {
		String[] temp = new String[10];
		for (int a = 0; a < key.length(); a++) {
			int index = Character.getNumericValue(key.charAt(a));
			if (index == 0) {
				index = 10;
			}
			temp[index - 1] = (new StringBuilder()).append(str.charAt(a)).append(str.charAt(10 + a)).append(str.charAt(20 + a)).append(str.charAt(30 + a)).append(str.charAt(40 + a)).toString();
		}

		String res = "";
		for (int a = 0; a < 10; a++) {
			res += temp[a];
		}
		return res;
	}
}
