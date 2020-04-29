/**
 * This class is part of running automated tests
 */
package cryptography.hashes.adler;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class AdlerTest {

	@Test
	public void runTest() {
		assertEquals("203293439", Adler.adler32("testing"));
	}

}
