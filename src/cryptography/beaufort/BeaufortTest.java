/**
 * This class is part of running automated tests
 */
package cryptography.beaufort;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class BeaufortTest {

	@Test
	public void runTest() {
		assertEquals("AAAALRMAMWA", Beaufort.beaufort("TESTINGTHIS", "TEST"));
		assertEquals("TESTINGTHIS", Beaufort.beaufort("AAAALRMAMWA", "TEST"));
	}

}
