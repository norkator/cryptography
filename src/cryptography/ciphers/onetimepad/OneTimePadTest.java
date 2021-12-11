package cryptography.ciphers.onetimepad;

import cryptography.Mode;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class OneTimePadTest {

	@Test
	public void runTest() {

		final String plainText = "one time pad sample string";
		final String key = "super secret";

		ArrayList<String> encrypted = OneTimePad.oneTimePad(Mode.ENCRYPT, plainText, key);
		ArrayList<String> decrypted = OneTimePad.oneTimePad(Mode.DECRYPT, encrypted.get(0), encrypted.get(1));

		assertEquals(plainText, decrypted.get(0));
	}

}
