package cryptography.converters.binaryDecimal;

import cryptography.Mode;

public class BinaryDecimal {

	public static void main(String[] args) {
	}

	public static String binaryDecimal(String input, Mode mode) {
		if (mode == Mode.ENCODE) {
			return Long.toBinaryString(Long.parseLong(input.replace(" ", "")));
		}
		if (mode == Mode.DECODE) {
			double j = 0;
			for (int i = 0; i < input.length(); i++) {
				if (input.charAt(i) == '1') {
					j = j + Math.pow(2, input.length() - 1 - i);
				}
			}
			return String.valueOf((int) j);
		}
		return null;
	}

}
