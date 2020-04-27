/**
 * This class is part of running automated tests
 */
package cryptography.encoding.base32;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import cryptography.Mode;

public class Base32Test {

	@Test
	public void runTest() {
		assertEquals("JBCUYTCP", Base32.base32("HELLO", Mode.ENCODE));
		assertEquals("HELLO", Base32.base32("JBCUYTCP", Mode.DECODE));
	}

}
