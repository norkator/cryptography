/**
 * This class will stack cipher methods and just try them all
 */
package cryptography;

import cryptography.ciphers.atbash.Atbash;
import cryptography.ciphers.caesar.Caesar;
import cryptography.ciphers.railfence.RailFence;
import cryptography.ciphers.scytale.Scytale;
import cryptography.ciphers.autokey.Autokey;
import cryptography.ciphers.beaufort.Beaufort;
import cryptography.ciphers.keyword.Keyword;
import cryptography.ciphers.vigenere.Vigenere;
import cryptography.ciphers.bacon.Bacon;
import cryptography.ciphers.chaocipher.Chaocipher;
import cryptography.ciphers.gronsfeld.Gronsfeld;
import cryptography.ciphers.adfgvx.Adfgvx;
import cryptography.ciphers.playfair.Playfair;

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

		// Autokey
		System.out.println("Autokey encrypt: " + Autokey.autokey("TESTINGTHIS", "TEST", Mode.ENCRYPT));
		System.out.println("Autokey decrypt: " + Autokey.autokey("MIKMBRYMPVY", "TEST", Mode.DECRYPT));

		// Beaufort
		System.out.println("Beaufort encrypt: " + Beaufort.beaufort("TESTINGTHIS", "TEST"));
		System.out.println("Beaufort decrypt: " + Beaufort.beaufort("AAAALRMAMWA", "TEST"));

		// Keyword
		System.out.println("Keyword encrypt: " + Keyword.keyword("TESTINGTHIS", "TEST", Mode.ENCRYPT));
		System.out.println("Keyword decrypt: " + Keyword.keyword("RBQRGLDRFGQ", "TEST", Mode.DECRYPT));

		// Vigenere
		System.out.println("Vigenere encrypt: " + Vigenere.vigenere("TESTINGTHIS", "TEST", Mode.ENCRYPT));
		System.out.println("Vigenere decrypt: " + Vigenere.vigenere("MIKMBRYMAMK", "TEST", Mode.DECRYPT));

		// Bacon
		System.out.println("Bacon encrypt: " + Bacon.bacon("HELLO", Mode.ENCRYPT));
		System.out.println("Bacon decrypt: " + Bacon.bacon("AABBB AABAA ABABB ABABB ABBBA", Mode.DECRYPT));

		// Chaocipher
		System.out.println("Chaocipher encrypt: " + Chaocipher.chaocipher("HELLO", Mode.ENCRYPT,
				"ABCDEFGHIJKLMNOPQRSTUVWXYZ", "ZYXWVUTSRQPONMLKJIHGFEDCBA"));
		System.out.println("Chaocipher decrypt: " + Chaocipher.chaocipher("STMLH", Mode.DECRYPT,
				"ABCDEFGHIJKLMNOPQRSTUVWXYZ", "ZYXWVUTSRQPONMLKJIHGFEDCBA"));

		// Gronsfeld
		System.out.println("Gronsfeld encrypt: " + Gronsfeld.gronsfeld("HELLO", "15243", Mode.ENCRYPT));
		System.out.println("Gronsfeld decrypt: " + Gronsfeld.gronsfeld("IJNPR", "15243", Mode.DECRYPT));

		// Adfgvx
		System.out.println("Adfgvx encrypt: " + Adfgvx.adfgvx("HELLOWORLD", Mode.ENCRYPT));
		System.out.println("Adfgvx decrypt: " + Adfgvx.adfgvx("DDAVDXDXFFGVFFFXDXAG", Mode.DECRYPT));

		// Playfair
		System.out.println("Playfair encrypt: " + Playfair.playfair("HELLOWORLDTEST", "ISFAIR", true, Mode.ENCRYPT));
		System.out.println("Playfair decrypt: " + Playfair.playfair("MBQFHQVPFNEQCAQY", "ISFAIR", true, Mode.DECRYPT));

	}

}
