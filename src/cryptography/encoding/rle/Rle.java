package cryptography.encoding.rle;

import cryptography.Mode;

public class Rle {

	/**
	 * Run-Length Encoding https://en.wikipedia.org/wiki/Run-length_encoding
	 * 
	 * @param mode  Encode or decode
	 * @param input string input
	 * @return string
	 */
	public static String rle(Mode mode, String input) {
		StringBuilder str = new StringBuilder();

		if (mode == Mode.ENCODE) {
			int il = input.length();
			for (int i = 0; i < il; i++) {
				int count = 1;
				while (i < il - 1 && input.charAt(i) == input.charAt(i + 1)) {
					count++;
					i++;
				}
				str.append(input.charAt(i)).append(count);
			}

			return str.toString();
		}

		if (mode == Mode.DECODE) {
			char[] stArr = input.toCharArray();
			char lastChar = 0;

			for (int p = 0; p < stArr.length; p++) {
				char s = stArr[p];

				if (!Character.isDigit(s)) {
					lastChar = s;
					str.append(s);
				} else {

					int e = digitCount(stArr, p);

					int n = Integer.parseInt(String.valueOf(input.substring(p, (p + e))));

					for (int i = 0; i < n - 1; i++) {
						str.append(lastChar);
					}

				}
			}

		}

		return str.toString();
	}

	public static int digitCount(char[] stArr, int currentPos) {
		int count = 0;

		for (int p = currentPos; p < stArr.length; p++) {
			if (Character.isDigit(stArr[p])) {
				count++;
			} else {
				break;
			}
		}

		return count;
	}

}
