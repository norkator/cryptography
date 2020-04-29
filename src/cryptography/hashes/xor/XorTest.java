/**
 * This class is part of running automated tests
 */
package cryptography.hashes.xor;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class XorTest {

	@Test
	public void runTest() {
		assertEquals("118", Xor.xor8("testing"));
	}

}
