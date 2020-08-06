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
			String[] rleSplit = input.split("(?<=\\G..)");

			int il = rleSplit.length;

			for (int i = 0; i < il; i++) {

		
				int count = Integer.parseInt(String.valueOf(rleSplit[i].charAt(1)));
				System.out.println(count);
				
				
				for (int c = 0; c < count; c++) {

					str.append(rleSplit[i].charAt(0));
				}

			}

		}

		return str.toString();
	}
}
