/**
 * This class is part of running automated tests
 */
package cryptography.hashes.fcs;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class FCSTest {

	@Test
	public void runTest() {
		assertEquals("12357", FCS.fcs16("testing"));
	}

}
