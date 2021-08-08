package cryptography.converters.binaryInteger;

import cryptography.Mode;

import java.math.BigInteger;

public class BinaryInteger {

	public static void main(String[] args) {
	}

	public static String binaryInteger(String input, Mode mode) {
		if (mode == Mode.ENCODE) {
			return Integer.toBinaryString(Integer.parseInt(input));
		}
		if (mode == Mode.DECODE) {
			return String.valueOf(Integer.parseInt(input, 2));
		}
		return null;
	}

}
