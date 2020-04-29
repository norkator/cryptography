/**
 * This class is part of running automated tests
 */
package cryptography.hashes.sha2;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SHA2Test {

	@Test
	public void runTest() {
		assertEquals("9e8965af89bd98c015512f1eb17ae07f48494da2d9a06a8f9659f749", SHA2.sha2_224("testing"));
	}

}
