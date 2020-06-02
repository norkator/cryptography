package cryptography.ciphers.blowfish;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import cryptography.Mode;

public class BlowfishTest {

	@Test
	public void runTest() {
		assertEquals("Dl+Cr1z8wRY=", Blowfish.blowfish("TESTING", Mode.ENCRYPT, "EXAMPLEKEY"));
		assertEquals("TESTING", Blowfish.blowfish("Dl+Cr1z8wRY=", Mode.DECRYPT, "EXAMPLEKEY"));
	}

}
