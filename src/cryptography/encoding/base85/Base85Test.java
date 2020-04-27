/**
 * This class is part of running automated tests
 */
package cryptography.encoding.base85;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import cryptography.Mode;

public class Base85Test {

	@Test
	public void runTest() {
		assertEquals("84?3G:B", Base85.base85("HELLO", Mode.ENCODE));
		assertEquals("HELLO", Base85.base85("84?3G:B", Mode.DECODE));
	}

}
