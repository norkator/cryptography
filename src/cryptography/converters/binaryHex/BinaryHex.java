package cryptography.converters.binaryHex;

import cryptography.Mode;

import java.math.BigInteger;

public class BinaryHex {

	public static void main(String[] args) {
	}

	public static String binaryHex(String input, Mode mode) {
		if (mode == Mode.ENCODE) {
			return new BigInteger(input, 16).toString(2);
		}
		if (mode == Mode.DECODE) {
			long hexDec = Long.parseLong(input, 2);
			return Long.toString(hexDec, 16).toUpperCase();
		}
		return null;
	}

}
