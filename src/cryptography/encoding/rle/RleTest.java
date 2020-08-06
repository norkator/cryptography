/**
 * This class is part of running automated tests
 */
package cryptography.encoding.rle;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import cryptography.Mode;

public class RleTest {

	@Test
	public void runTest() {
		assertEquals("A11B4C6", Rle.rle(Mode.ENCODE, "AAAAAAAAAAABBBBCCCCCC"));
		assertEquals("AAAAAAAAAABBBBCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC", Rle.rle(Mode.DECODE, "A10B4C30"));
	}

}
