/**
 * This class will stack cipher methods and just try them all
 */
package cryptography;

import cryptography.caesar.Caesar;
import cryptography.railfence.RailFence;
import cryptography.scytale.Scytale;

public class Ciphers {

	public static void main(String[] args) {
	
		
		// Scytale
		String scytaleCiphered = Scytale.scytale("HELLO", Mode.ENCRYPT, 3);
		System.out.println("Scytale encrypt: " + scytaleCiphered);
		System.out.println("Scytale decrypt: " + Scytale.scytale(scytaleCiphered, Mode.DECRYPT, 3));
		
		// Caesar
		String caesarCiphered = Caesar.caesar("HELLO", 3, Mode.ENCRYPT);
		System.out.println("Caesar encrypt: " + caesarCiphered);
		System.out.println("Caesar decrypt: " + Caesar.caesar(caesarCiphered, 3, Mode.DECRYPT));

		// Rail Fence
		String railFenceCiphered = RailFence.railFence("Hello world longer text", Mode.ENCRYPT, 6);
		System.out.println("Rail fence encrypt: " + railFenceCiphered);
		System.out.println("Rail fence decrypt: " + RailFence.railFence(railFenceCiphered, Mode.DECRYPT, 6));

		
	}

}
