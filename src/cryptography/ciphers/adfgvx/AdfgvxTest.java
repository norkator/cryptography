/*
 * This class is part of running automated tests
 */
package cryptography.ciphers.adfgvx;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import cryptography.Mode;

public class AdfgvxTest {

	@Test
	public void runTest() {
		assertEquals("SAURAVKUMARISTHEKING", Adfgvx.adfgvx(Adfgvx.adfgvx("SAURAVKUMARISTHEKING", "cargo", "privacy", Mode.ENCRYPT), "cargo", "privacy", Mode.DECRYPT));
		assertEquals("Key size larger than 10, choose smaller key", Adfgvx.adfgvx("HELLOWORLD", "abcdeabcde", "cargo", Mode.ENCRYPT));
	}
}
