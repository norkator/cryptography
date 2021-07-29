package cryptography.ciphers.anubis;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import cryptography.Mode;

public class AnubisTest {
	
	@Test
	public void runTest() {
		final String plainText = "TESTING ANUBIS";
		final byte[] keyBytes = AnubisMethod.GetRandomKeyBytes();
		final String encrypted = AnubisMethod.Anubis(plainText, keyBytes, Mode.ENCRYPT);
		final String decrypted = AnubisMethod.Anubis(encrypted, keyBytes, Mode.DECRYPT);
		
		assertEquals(40, keyBytes.length);
		assertEquals(plainText, decrypted);
		
	}

}
