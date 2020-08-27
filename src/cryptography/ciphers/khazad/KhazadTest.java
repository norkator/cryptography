package cryptography.ciphers.khazad;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import cryptography.Mode;

public class KhazadTest {

	@Test
	public void runTest() {

		final String plainText = "TESTING KHAZAD";
		final byte[] keyBytes = KhazadMethod.GetRandomKeyBytes();
		final String encrypted = KhazadMethod.Khazad(plainText, keyBytes, Mode.ENCRYPT);
		final String decrypted = KhazadMethod.Khazad(encrypted, keyBytes, Mode.DECRYPT);

		assertEquals(16, keyBytes.length);
		assertEquals(plainText, decrypted);

	}

}
