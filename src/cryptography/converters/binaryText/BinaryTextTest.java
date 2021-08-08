/**
 * This class is part of running automated tests
 */
package cryptography.converters.binaryText;

import cryptography.Mode;
import cryptography.converters.binaryInteger.BinaryInteger;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinaryTextTest {

	@Test
	public void runTest() {
		assertEquals("01001000 01100101 01101100 01101100 01101111 ", BinaryText.binaryText("Hello", Mode.ENCODE));
		assertEquals("Hello", BinaryText.binaryText("01001000 01100101 01101100 01101100 01101111 ", Mode.DECODE));
	}

}
