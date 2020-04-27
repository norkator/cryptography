/**
 * This class is part of running automated tests
 */
package cryptography.ciphers.vigenere;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import cryptography.Mode;

public class VigenereTest {

	@Test
	public void runTest() {
		assertEquals("MIKMBRYMAMK", Vigenere.vigenere("TESTINGTHIS", "TEST", Mode.ENCRYPT));
		assertEquals("TESTINGTHIS", Vigenere.vigenere("MIKMBRYMAMK", "TEST", Mode.DECRYPT));
	}

}
