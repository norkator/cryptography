package cryptography.converters.binaryText;

import cryptography.Mode;

public class BinaryText {

	public static void main(String[] args) {
	}

	public static String binaryText(String input, Mode mode) {
		if (mode == Mode.ENCODE) {
			byte[] bytes = input.getBytes();
			StringBuilder binary = new StringBuilder();
			for (byte b : bytes) {
				int val = b;
				for (int i = 0; i < 8; i++) {
					binary.append((val & 128) == 0 ? 0 : 1);
					val <<= 1;
				}
				binary.append(" ");
			}
			return binary.toString();
		}
		if (mode == Mode.DECODE) {
			String[] binary = input.split(" ");
			StringBuilder sb = new StringBuilder();
			for (String s : binary) {
				sb.append((char) Integer.parseInt(s, 2));
			}
			return sb.toString();
		}
		return null;
	}

}
