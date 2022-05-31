/*
 * This class will stack cipher methods and just try them all
 */
package cryptography;

import cryptography.ciphers.aes.AES;
import cryptography.ciphers.aria.ARIA;
import cryptography.ciphers.atbash.Atbash;
import cryptography.ciphers.caesar.Caesar;
import cryptography.ciphers.cast.CAST;
import cryptography.ciphers.idea.IDEA;
import cryptography.ciphers.navajo.Navajo;
import cryptography.ciphers.railfence.RailFence;
import cryptography.ciphers.rc.RC;
import cryptography.ciphers.scytale.Scytale;
import cryptography.ciphers.autokey.Autokey;
import cryptography.ciphers.beaufort.Beaufort;
import cryptography.ciphers.blowfish.Blowfish;
import cryptography.ciphers.keyword.Keyword;
import cryptography.ciphers.khazad.KhazadMethod;
import cryptography.ciphers.vigenere.Vigenere;
import cryptography.ciphers.bacon.Bacon;
import cryptography.ciphers.chaocipher.Chaocipher;
import cryptography.ciphers.elgamal.Elgamal;
import cryptography.ciphers.ellipticCurve.EC_Util;
import cryptography.ciphers.ellipticCurve.EllipticCurve;
import cryptography.ciphers.gronsfeld.Gronsfeld;
import cryptography.ciphers.vic.VIC;
import cryptography.ciphers.adfgvx.Adfgvx;
import cryptography.ciphers.anubis.AnubisMethod;
import cryptography.ciphers.playfair.Playfair;
import cryptography.ciphers.porta.Porta;
import cryptography.random.secureRandom.SecureRandom;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.Security;
import java.util.Random;

public class Ciphers {

	public static void main(String[] args) {

		// Allows use of tougher crypto
		Security.setProperty("crypto.policy", "unlimited");

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
		System.out.println("Adfgvx encrypt: " + Adfgvx.adfgvx("ATTACK AT 1200AM", "cargo", "privacy", Mode.ENCRYPT));
		System.out.println("Adfgvx decrypt: " + Adfgvx.adfgvx("GAVDDAVFGAVFADGFDADVDFGAADVF", "cargo", "privacy", Mode.DECRYPT));

		// Playfair
		System.out.println("Playfair encrypt: " + Playfair.playfair("HELLOWORLDTEST", "ISFAIR", true, Mode.ENCRYPT));
		System.out.println("Playfair decrypt: " + Playfair.playfair("MBQFHQVPFNEQCAQY", "ISFAIR", true, Mode.DECRYPT));

		// Porta
		System.out.println("Porta encrypt: " + Porta.porta("PORTAEXAMPLE", "TEST"));
		System.out.println("Porta decrypt: " + Porta.porta("GMIKWTBWVAUN", "TEST"));

		// Blowfish
		System.out.println("Blowfish encrypt: " + Blowfish.blowfish("TESTING", Mode.ENCRYPT, "EXAMPLEKEY"));
		System.out.println("Blowfish decrypt: " + Blowfish.blowfish("Dl+Cr1z8wRY=", Mode.DECRYPT, "EXAMPLEKEY"));

		// RC2
		System.out.println("RC2 encrypt: " + RC.rc2(Mode.ENCRYPT, "TESTING", "EXAMPLEKEY"));
		System.out.println("RC2 decrypt: " + RC.rc2(Mode.DECRYPT, "G2DXHTkgYEY=", "EXAMPLEKEY"));

		// RC4
		System.out.println("RC4 encrypt: " + RC.rc4(Mode.ENCRYPT, "TESTING", "EXAMPLEKEY"));
		System.out.println("RC4 decrypt: " + RC.rc4(Mode.DECRYPT, "HUUcc9q/5Q==", "EXAMPLEKEY"));

		// RC6
		System.out.println("RC6 encrypt: " + RC.rc6(Mode.ENCRYPT, "TESTING", "EXAMPLEKEY"));
		System.out.println("RC6 decrypt: " + RC.rc6(Mode.DECRYPT, "UEsASt9knf1TT0izJpmlkQ==", "EXAMPLEKEY"));

		// CAST5
		System.out.println("CAST5 encrypt: " + CAST.cast5(Mode.ENCRYPT, "TESTING", "EXAMPLEKEY"));
		System.out.println("CAST5 decrypt: " + CAST.cast5(Mode.DECRYPT, "KfqJ96FlihQ=", "EXAMPLEKEY"));

		// CAST6
		System.out.println("CAST6 encrypt: " + CAST.cast6(Mode.ENCRYPT, "TESTING", "EXAMPLEKEY"));
		System.out.println("CAST6 decrypt: " + CAST.cast6(Mode.DECRYPT, "YuWPzdF2f6QknZIQRYWpPw==", "EXAMPLEKEY"));

		// ELGAMAL
		Elgamal elgamal = new Elgamal(Logging.DISABLED);
		final String elgamalCipherText = elgamal.elgamal(Mode.ENCRYPT, "TESTING");
		System.out.println("ELGAMAL public key: " + elgamal.getPublicKeyStr());
		System.out.println("ELGAMAL private key: " + elgamal.getPrivateKeyStr());
		System.out.println("ELGAMAL encrypt: " + elgamalCipherText);
		System.out.println("ELGAMAL decrypt: " + elgamal.elgamal(Mode.DECRYPT, elgamalCipherText));

		// Anubis
		final byte[] anubisKeyBytes = AnubisMethod.GetRandomKeyBytes();
		final String anubiusEncrypted = AnubisMethod.Anubis("TESTING ANUBIS", anubisKeyBytes, Mode.ENCRYPT);
		System.out.println("Anubis key    : " + AnubisMethod.KeyBytesToBase64String(anubisKeyBytes));
		System.out.println("Anubis encrypt: " + anubiusEncrypted);
		System.out.println("Anubis decrypt: " + AnubisMethod.Anubis(anubiusEncrypted, anubisKeyBytes, Mode.DECRYPT));

		// Khazad
		final byte[] khazadKeyBytes = KhazadMethod.GetRandomKeyBytes();
		final String khazadEncrypted = KhazadMethod.Khazad("TEST KHAZAD", khazadKeyBytes, Mode.ENCRYPT);
		System.out.println("Khazad key    : " + KhazadMethod.KeyBytesToBase64String(khazadKeyBytes));
		System.out.println("Khazad encrypt: " + khazadEncrypted);
		System.out.println("Khazad decrypt: " + KhazadMethod.Khazad(khazadEncrypted, khazadKeyBytes, Mode.DECRYPT));

		// ARIA
		final String ariaKey = "ARIA key";
		final String ariaPlainText = "ARIA test input";
		final String ariaEncrypted = ARIA.encrypt(ariaPlainText, ariaKey);
		System.out.println("ARIA encrypt: " + ariaEncrypted);
		final String ariaDecrypted = ARIA.decrypt(ariaEncrypted, ariaKey);
		System.out.println("ARIA decrypt: " + ariaDecrypted);

		// IDEA
		final String ideaKey = "IDEA key";
		final String ideaPlainText = "IDEA test input";
		final String ideaEncrypted = IDEA.encrypt(ideaPlainText, ideaKey);
		System.out.println("IDEA encrypt: " + ideaEncrypted);
		final String ideaDecrypted = IDEA.decrypt(ideaEncrypted, ideaKey);
		System.out.println("IDEA decrypt: " + ideaDecrypted);

		// AES (see AESTest.class for more)
		try {
			final String aesKey = "some key";
			final String aesPlainText = "some test input";
			byte[] salt = SecureRandom.secureRandomStrongBytes(16);
			byte[] iv = AES.IV_BLANK;
			byte[] key = AES.createKey(aesKey, salt, AES.KEY_GENERATION_ITERATIONS, AES.KEY_SIZE_256_BITS).getKey();
			final String encrypted = AES.encrypt(aesPlainText, key, iv);
			System.out.println("AES 256 blank iv encrypt: " + encrypted);
			System.out.println("AES 256 blank iv decrypt: " + AES.decrypt(encrypted, key, iv));

			byte[] strongIV = SecureRandom.secureRandomStrongBytes(16);
			String encrypted2 = AES.encrypt(aesPlainText, key, strongIV);
			System.out.println("AES 256 strong iv encrypt: " + encrypted2);
			System.out.println("AES 256 strong iv decrypt: " + AES.decrypt(encrypted2, key, strongIV));
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		// EllipticCurve (see EllipticCurveTest.class for more)
		try {
			// Create Elliptic Eqn
			Random rand = new Random();
			EllipticCurve E = new EllipticCurve(new BigDecimal("-1"), new BigDecimal("1"), new BigDecimal("5"));

			// Generate Secret Key
			BigInteger privateKeyA = new BigInteger(3, rand);
			BigInteger privateKeyB = new BigInteger(3, rand);
			BigInteger[] G = E.calcG();
			BigInteger[] secretKey = EC_Util.genSecretKey_DeffieHellman(privateKeyA, privateKeyB, G, E);
			BigInteger[] publicKeyB = EC_Util.multiply_EC_PointByKey(privateKeyB, G, E);

			// encryption
			String[] ciphered = E.encrypt("Some test input", G, secretKey[0], publicKeyB[0], 2000);
			String deciphered = E.decrypt(ciphered, privateKeyB, 2000);

			System.out.println("ECC encryption: " + ciphered[0] + " " + ciphered[1]);
			System.out.println("ECC decryption: " + deciphered);
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		// VIC
		try {
			String plainText = "We are pleased to hear of your success in establishing your false identity You will be sent some money to cover expenses within a month";
			int date = 741776;
			int keyGroup = 77651;
			int personalNo = 8;
			String cipherText = VIC.encrypt(plainText,
				"AT ONE SIR",
				"I dream of Jeannie with t",
				date, personalNo, keyGroup);
			String decipherText = VIC.decrypt(cipherText,
				"AT ONE SIR",
				"I dream of Jeannie with t",
				date, personalNo, keyGroup);
			System.out.println("VIC Cipher: " + cipherText);
			System.out.println("VIC Decipher: " + decipherText);
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		// Navajo
		System.out.println("Navajo encrypt: " + Navajo.encrypt("CRYPTOGRAPHY"));
		System.out.println("Navajo decrypt: " + Navajo.decrypt("MOASI GAH TSAH-AS-ZIH CLA-GI-AIH THAN-ZIE NE-AHS-JAH AH-TAD DAH-NES-TSA BE-LA-SANA CLA-GI-AIH CHA TSAH-AS-ZIH"));

	}

}
