/**
 * This class is part of running automated tests
 */
package cryptography.hashes.sum;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SUMHashesTest {

	@Test
	public void runTest() {
		assertEquals("254", SUMHashes.sum8("testing"));
		assertEquals("766", SUMHashes.sum16("testing"));
		assertEquals("766", SUMHashes.sum24("testing"));
		assertEquals("766", SUMHashes.sum32("testing"));
	}

}
