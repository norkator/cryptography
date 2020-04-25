/**
 * This class will stack cipher methods and just try them all
 */
package cryptography;

import cryptography.atbash.Atbash;
import cryptography.caesar.Caesar;
import cryptography.railfence.RailFence;
import cryptography.scytale.Scytale;

public class Ciphers {

	public static void main(String[] args) {
	
		
		// Scytale
		System.out.println("Scytale encrypt: " + Scytale.scytale("HELLO", Mode.ENCRYPT, 3));
		System.out.println("Scytale decrypt: " + Scytale.scytale("HLEOL", Mode.DECRYPT, 3));
		
		// Caesar
		System.out.println("Caesar encrypt: " + Caesar.caesar("HELLO", 3, Mode.ENCRYPT));
		System.out.println("Caesar decrypt: " + Caesar.caesar("KHOOR", 3, Mode.DECRYPT));

		// Rail Fence
		System.out.println("Rail fence encrypt: " + RailFence.railFence("Hello world longer text", Mode.ENCRYPT, 6));
		System.out.println("Rail fence decrypt: " + RailFence.railFence("hdeel txlrl tloorowne g", Mode.DECRYPT, 6));

		// Atbash
		System.out.println("Atbash encrypt: " + Atbash.atbash("Helloworld", Mode.ENCRYPT));
		System.out.println("Atbash decrypt: " + Atbash.atbash("svooldliow", Mode.DECRYPT));
		
		
	}

}
