/**
 * This class is part of running automated tests
 */
package cryptography.hashes.has;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class HASTest {

	@Test
	public void runTest() {
		assertEquals("066982e01a25afa4530536c4f5edc651b939c826", HAS.has160("testing"));
	}

}
