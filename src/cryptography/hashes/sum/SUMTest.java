/**
 * This class is part of running automated tests
 */
package cryptography.hashes.sum;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SUMTest {

	@Test
	public void runTest() {
		assertEquals("254", SUM.sum8("testing"));
		assertEquals("766", SUM.sum16("testing"));
		assertEquals("766", SUM.sum24("testing"));
		assertEquals("766", SUM.sum32("testing"));
	}

}
