package cryptography.ciphers.anubis;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import cryptography.Mode;

public class AnubisTest {

	@Test
	public void basicTest() {

		final String plainText = "TESTING ANUBIS  ";
		final byte[] keyBytes = AnubisMethod.GetRandomKeyBytes();
		final String encrypted = AnubisMethod.Anubis(plainText, keyBytes, Mode.ENCRYPT);
		final String decrypted = AnubisMethod.Anubis(encrypted, keyBytes, Mode.DECRYPT);

		assertEquals(40, keyBytes.length);
		assertEquals(plainText, decrypted);
	}

	@Test
	public void shortTest() {

		final String plainText = "SHORT           ";
		final byte[] keyBytes = AnubisMethod.GetRandomKeyBytes();
		final String encrypted = AnubisMethod.Anubis(plainText, keyBytes, Mode.ENCRYPT);
		final String decrypted = AnubisMethod.Anubis(encrypted, keyBytes, Mode.DECRYPT);

		assertEquals(plainText, decrypted);
	}

	@Test
	public void longTest() {

		final String plainText = "VERY LONG STRING FOR TESTING ANUBIS IMPLEMENTATION 1234567890";
		final byte[] keyBytes = AnubisMethod.GetRandomKeyBytes();
		final String encrypted = AnubisMethod.Anubis(plainText, keyBytes, Mode.ENCRYPT);
		final String decrypted = AnubisMethod.Anubis(encrypted, keyBytes, Mode.DECRYPT);

		assertEquals(plainText, decrypted);
	}

	
}
