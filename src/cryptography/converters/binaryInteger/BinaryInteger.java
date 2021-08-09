package cryptography.converters.binaryInteger;

import cryptography.Mode;
import cryptography.padding.pad.Pad;
import cryptography.converters.compliment.*;

import java.math.BigInteger;

public class BinaryInteger {

	public static void main(String[] args) {
	}

	/*integer to 32 bit binary 2's compliment*/
	public static String binaryInteger(String input, Mode mode) {
		if (mode == Mode.ENCODE) {
			return Pad.to32(Integer.toBinaryString(Integer.parseInt(input)));
		}
		if (mode == Mode.DECODE) {
			input = (input.length() < 32) ? Pad.to32(input) : input;

			if (input.charAt(0) == '0') {
				return new BigInteger(input, 2).toString(10);
			} else {
				input = Compliment.twoCompliment(input);
				return "-" + new BigInteger(input, 2).toString(10);
			}
		}
		return null;
	}

}
