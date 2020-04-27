/**
 * This class is part of running automated tests
 */
package cryptography.ciphers.scytale;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import cryptography.Mode;

public class ScytaleTest {

	@Test
	public void runTest() {
		assertEquals("HLEOL", Scytale.scytale("HELLO", Mode.ENCRYPT, 3));
		assertEquals("HELLO", Scytale.scytale("HLEOL", Mode.DECRYPT, 3));
	}

}
