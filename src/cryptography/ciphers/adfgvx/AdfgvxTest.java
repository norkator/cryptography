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
		assertEquals("DDFADXFGAFFVFXDGDXVX", Adfgvx.adfgvx("HELLOWORLD", "abcdef", Mode.ENCRYPT));
		assertEquals("HELLOWORLD", Adfgvx.adfgvx("DDFADXFGAFFVFXDGDXVX", "abcdef", Mode.DECRYPT));
		assertEquals("SAURAVKUMARISTHEKING",Adfgvx.adfgvx(Adfgvx.adfgvx("SAURAVKUMARISTHEKING", "yeahboii", Mode.ENCRYPT), "yeahboii", Mode.DECRYPT));
		assertEquals("Key size larger than 10, choose smaller key", Adfgvx.adfgvx("HELLOWORLD", "abcdeabcde", Mode.ENCRYPT));
	}
}
