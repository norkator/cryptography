/**
 * This class is part of running automated tests
 */
package cryptography.encoding.a1z26;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import cryptography.Mode;

public class A1z26Test {

	@Test
	public void runTest() {
		assertEquals("8-5-12-12-15", A1z26.a1z26("HELLO", Mode.ENCODE));
		assertEquals("HELLO", A1z26.a1z26("8-5-12-12-15", Mode.DECODE));
	}

}
