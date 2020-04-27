/**
 * This class is part of running automated tests
 */
package cryptography.ciphers.autokey;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import cryptography.Mode;

public class AutokeyTest {

	@Test
	public void runTest() {
		assertEquals("MIKMBRYMPVY", Autokey.autokey("TESTINGTHIS", "TEST", Mode.ENCRYPT));
		assertEquals("TESTINGTHIS", Autokey.autokey("MIKMBRYMPVY", "TEST", Mode.DECRYPT));
	}

}
