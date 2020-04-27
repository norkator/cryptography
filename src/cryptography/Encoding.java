package cryptography;

import cryptography.encoding.base32.Base32;
import cryptography.encoding.base64.Base64;
import cryptography.encoding.base85.Base85;

public class Encoding {

	public static void main(String[] args) {

		// Base32
		System.out.println("Base32 encode: " + Base32.base32("HELLO", Mode.ENCODE));
		System.out.println("Base32 decode: " + Base32.base32("JBCUYTCP", Mode.DECODE));
		
		// Base64
		System.out.println("Base64 encode: " + Base64.base64("HELLO", Mode.ENCODE));
		System.out.println("Base64 decode: " + Base64.base64("SEVMTE8=", Mode.DECODE));

		// Base85
		System.out.println("Base64 encode: " + Base85.base85("HELLO", Mode.ENCODE));
		System.out.println("Base64 decode: " + Base85.base85("84?3G:B", Mode.DECODE));

	}

}
