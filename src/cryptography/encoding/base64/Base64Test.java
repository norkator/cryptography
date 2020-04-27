/**
 * This class is part of running automated tests
 */
package cryptography.encoding.base64;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import cryptography.Mode;

public class Base64Test {

	@Test
	public void runTest() {
		assertEquals("SEVMTE8=", Base64.base64("HELLO", Mode.ENCODE));
		assertEquals("HELLO", Base64.base64("SEVMTE8=", Mode.DECODE));
	}

}
