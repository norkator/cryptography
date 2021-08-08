/**
 * This class is part of running automated tests
 */
package cryptography.converters.binaryHex;

import cryptography.Mode;
import cryptography.converters.binaryDecimal.BinaryDecimal;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinaryHexTest {

	@Test
	public void runTest() {
		assertEquals("1111101101101", BinaryHex.binaryHex("1F6D", Mode.ENCODE));
		assertEquals("1F6D", BinaryHex.binaryHex("1111101101101", Mode.DECODE));
	}

}
