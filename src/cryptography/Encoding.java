package cryptography;

import cryptography.encoding.a1z26.A1z26;
import cryptography.encoding.base32.Base32;
import cryptography.encoding.base64.Base64;
import cryptography.encoding.base85.Base85;
import cryptography.encoding.base91.Base91;

public class Encoding {

	public static void main(String[] args) {

		// Base32
		System.out.println("Base32 encode: " + Base32.base32("HELLO", Mode.ENCODE));
		System.out.println("Base32 decode: " + Base32.base32("JBCUYTCP", Mode.DECODE));
		
		// Base64
		System.out.println("Base64 encode: " + Base64.base64("HELLO", Mode.ENCODE));
		System.out.println("Base64 decode: " + Base64.base64("SEVMTE8=", Mode.DECODE));

		// Base85
		System.out.println("Base85 encode: " + Base85.base85("HELLO", Mode.ENCODE));
		System.out.println("Base85 decode: " + Base85.base85("84?3G:B", Mode.DECODE));

		// Base91
		System.out.println("Base91 encode: " + Base91.base91("TESTING", Mode.ENCODE));
		System.out.println("Base91 decode: " + Base91.base91("\"OdH0zJpE", Mode.DECODE));
		
		// A1z26
		System.out.println("A1z26 encrypt: " + A1z26.a1z26("HELLO", Mode.ENCODE));
		System.out.println("A1z26 decrypt: " + A1z26.a1z26("8-5-12-12-15", Mode.DECODE));
		
	}

}
