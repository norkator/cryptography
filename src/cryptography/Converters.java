/*
 * This class will stack converter methods and just try them all
 */
package cryptography;

import cryptography.converters.binaryDecimal.BinaryDecimal;
import cryptography.converters.binaryHex.BinaryHex;
import cryptography.converters.binaryInteger.BinaryInteger;
import cryptography.converters.binaryText.BinaryText;
import cryptography.converters.compliment.Compliment;

public class Converters {

	public static void main(String[] args) {

		System.out.println("Binary decimal encode: " + BinaryDecimal.binaryDecimal("123", Mode.ENCODE));
		System.out.println("Binary decimal decode: " + BinaryDecimal.binaryDecimal("1111011", Mode.DECODE));

		System.out.println("Binary hex encode: " + BinaryHex.binaryHex("1F6D", Mode.ENCODE));
		System.out.println("Binary hex decode: " + BinaryHex.binaryHex("1111101101101", Mode.DECODE));

		System.out.println("Binary integer encode: " + BinaryInteger.binaryInteger("50", Mode.ENCODE));
		System.out.println("Binary integer decode: " + BinaryInteger.binaryInteger("110010", Mode.DECODE));

		System.out.println("Binary text encode: " + BinaryText.binaryText("Hello", Mode.ENCODE));
		System.out.println("Binary text decode: " + BinaryText.binaryText("01001000 01100101 01101100 01101100 01101111", Mode.DECODE));

		System.out.println("One's compliment: " + Compliment.oneCompliment("1011010"));
		System.out.println("Two's compliment: " + Compliment.twoCompliment("1011010"));
	}

}
