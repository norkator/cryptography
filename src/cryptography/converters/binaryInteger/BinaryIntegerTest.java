/**
 * This class is part of running automated tests
 */
package cryptography.converters.binaryInteger;

import cryptography.Mode;
import cryptography.converters.binaryHex.BinaryHex;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinaryIntegerTest {

	@Test
	public void runTest() {
		assertEquals("110010", BinaryInteger.binaryInteger("50", Mode.ENCODE));
		assertEquals("50", BinaryInteger.binaryInteger("110010", Mode.DECODE));
	}

}
