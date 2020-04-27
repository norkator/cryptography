/**
 * This class is part of running automated tests
 */
package cryptography.ciphers.adfgvx;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import cryptography.Mode;

public class AdfgvxTest {

	@Test
	public void runTest() {
		assertEquals("DDAVDXDXFFGVFFFXDXAG", Adfgvx.adfgvx("HELLOWORLD", Mode.ENCRYPT));
		assertEquals("HELLOWORLD", Adfgvx.adfgvx("DDAVDXDXFFGVFFFXDXAG", Mode.DECRYPT));
	}

}
