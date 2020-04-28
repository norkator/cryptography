/**
 * This class is part of running automated tests
 */
package cryptography.encoding.base91;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import cryptography.Mode;

public class Base91Test {

	@Test
	public void runTest() {
		assertEquals("\"OdH0zJpE", Base91.base91("TESTING", Mode.ENCODE));
		assertEquals("TESTING", Base91.base91("\"OdH0zJpE", Mode.DECODE));
	}

}
