/**
 * This class is part of running automated tests
 */
package cryptography.ciphers.bacon;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import cryptography.Mode;

public class BaconTest {

	@Test
	public void runTest() {
		assertEquals("AABBB AABAA ABABB ABABB ABBBA ", Bacon.bacon("HELLO", Mode.ENCRYPT));
		assertEquals("HELLO", Bacon.bacon("AABBB AABAA ABABB ABABB ABBBA", Mode.DECRYPT));
	}

}
