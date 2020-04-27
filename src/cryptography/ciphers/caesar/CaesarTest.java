/**
 * This class is part of running automated tests
 */
package cryptography.ciphers.caesar;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import cryptography.Mode;

public class CaesarTest {

	@Test
	public void runTest() {
		assertEquals("KHOOR", Caesar.caesar("HELLO", 3, Mode.ENCRYPT));
		assertEquals("HELLO", Caesar.caesar("KHOOR", 3, Mode.DECRYPT));
	}

}
