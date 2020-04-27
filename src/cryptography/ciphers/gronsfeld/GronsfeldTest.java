/**
 * This class is part of running automated tests
 */
package cryptography.ciphers.gronsfeld;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import cryptography.Mode;

public class GronsfeldTest {

	@Test
	public void runTest() {
		assertEquals("IJNPR", Gronsfeld.gronsfeld("HELLO", "15243", Mode.ENCRYPT));
		assertEquals("HELLO", Gronsfeld.gronsfeld("IJNPR", "15243", Mode.DECRYPT));
	}

}
