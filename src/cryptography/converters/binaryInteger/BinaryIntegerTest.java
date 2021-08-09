/*
 * This class is part of running automated tests
 */
package cryptography.converters.binaryInteger;

import cryptography.Mode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinaryIntegerTest {

	@Test
	public void runTest() {
		assertEquals("00000000000000000000000000110010", BinaryInteger.binaryInteger("50", Mode.ENCODE));
		assertEquals("50", BinaryInteger.binaryInteger("110010", Mode.DECODE));
		assertEquals("11111111111111111111111111001110", BinaryInteger.binaryInteger("-50", Mode.ENCODE));
		assertEquals("-50", BinaryInteger.binaryInteger("11111111111111111111111111001110", Mode.DECODE));
	}

}
