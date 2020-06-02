package cryptography.ciphers.porta;

public class Porta {

	public static void main(String[] args) {
	}

	public static String porta(String input, String key) {

		StringBuilder stringBuilder = new StringBuilder();
		char[] pTable1 = { 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E',
				'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M' };
		char[] pTable2 = { 'Z', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'B', 'C', 'D', 'E', 'F',
				'G', 'H', 'I', 'J', 'K', 'L', 'M', 'A' };
		char[] pTable3 = { 'Y', 'Z', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'C', 'D', 'E', 'F', 'G',
				'H', 'I', 'J', 'K', 'L', 'M', 'A', 'B' };
		char[] pTable4 = { 'X', 'Y', 'Z', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'D', 'E', 'F', 'G', 'H',
				'I', 'J', 'K', 'L', 'M', 'A', 'B', 'C' };
		char[] pTable5 = { 'W', 'X', 'Y', 'Z', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'E', 'F', 'G', 'H', 'I',
				'J', 'K', 'L', 'M', 'A', 'B', 'C', 'D' };
		char[] pTable6 = { 'V', 'W', 'X', 'Y', 'Z', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'F', 'G', 'H', 'I', 'J',
				'K', 'L', 'M', 'A', 'B', 'C', 'D', 'E' };
		char[] pTable7 = { 'U', 'V', 'W', 'X', 'Y', 'Z', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'G', 'H', 'I', 'J', 'K',
				'L', 'M', 'A', 'B', 'C', 'D', 'E', 'F' };
		char[] pTable8 = { 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'N', 'O', 'P', 'Q', 'R', 'S', 'H', 'I', 'J', 'K', 'L',
				'M', 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
		char[] pTable9 = { 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'N', 'O', 'P', 'Q', 'R', 'I', 'J', 'K', 'L', 'M',
				'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H' };
		char[] pTable10 = { 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'N', 'O', 'P', 'Q', 'J', 'K', 'L', 'M', 'A',
				'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I' };
		char[] pTable11 = { 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'N', 'O', 'P', 'K', 'L', 'M', 'A', 'B',
				'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J' };
		char[] pTable12 = { 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'N', 'O', 'L', 'M', 'A', 'B', 'C',
				'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K' };
		char[] pTable13 = { 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'N', 'M', 'A', 'B', 'C', 'D',
				'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L' };

		for (int i = 0; i < input.length(); i++) {
			int j = i % key.length();
			if ((key.charAt(j) == 'A') || (key.charAt(j) == 'B')) {
				stringBuilder.append(pTable1[Character.codePointAt(input, i) - 65]);
			}
			if ((key.charAt(j) == 'Y') || (key.charAt(j) == 'Z')) {
				stringBuilder.append(pTable2[Character.codePointAt(input, i) - 65]);
			}
			if ((key.charAt(j) == 'W') || (key.charAt(j) == 'X')) {
				stringBuilder.append(pTable3[Character.codePointAt(input, i) - 65]);
			}
			if ((key.charAt(j) == 'U') || (key.charAt(j) == 'V')) {
				stringBuilder.append(pTable4[Character.codePointAt(input, i) - 65]);
			}
			if ((key.charAt(j) == 'S') || (key.charAt(j) == 'T')) {
				stringBuilder.append(pTable5[Character.codePointAt(input, i) - 65]);
			}
			if ((key.charAt(j) == 'Q') || (key.charAt(j) == 'R')) {
				stringBuilder.append(pTable6[Character.codePointAt(input, i) - 65]);
			}
			if ((key.charAt(j) == 'O') || (key.charAt(j) == 'P')) {
				stringBuilder.append(pTable7[Character.codePointAt(input, i) - 65]);
			}
			if ((key.charAt(j) == 'M') || (key.charAt(j) == 'N')) {
				stringBuilder.append(pTable8[Character.codePointAt(input, i) - 65]);
			}
			if ((key.charAt(j) == 'K') || (key.charAt(j) == 'L')) {
				stringBuilder.append(pTable9[Character.codePointAt(input, i) - 65]);
			}
			if ((key.charAt(j) == 'I') || (key.charAt(j) == 'J')) {
				stringBuilder.append(pTable10[Character.codePointAt(input, i) - 65]);
			}
			if ((key.charAt(j) == 'G') || (key.charAt(j) == 'H')) {
				stringBuilder.append(pTable11[Character.codePointAt(input, i) - 65]);
			}
			if ((key.charAt(j) == 'E') || (key.charAt(j) == 'F')) {
				stringBuilder.append(pTable12[Character.codePointAt(input, i) - 65]);
			}
			if ((key.charAt(j) == 'C') || (key.charAt(j) == 'D')) {
				stringBuilder.append(pTable13[Character.codePointAt(input, i) - 65]);
			}
		}

		return stringBuilder.toString();
	}

}
