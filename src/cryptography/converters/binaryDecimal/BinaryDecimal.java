package cryptography.converters.binaryDecimal;

import java.math.BigInteger;

import cryptography.Mode;

public class BinaryDecimal {

	public static void main(String[] args) {
	}

	public static String binaryDecimal(String input, Mode mode) {
		if (mode == Mode.ENCODE) {
			return new BigInteger(input, 10).toString(2);
		}
		if (mode == Mode.DECODE) {
			return new BigInteger(input, 2).toString(10);
		}
		return null;
	}
}
