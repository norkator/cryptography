/*
 * This class is part of running automated tests
 */
package cryptography.converters.binaryDecimal;

import cryptography.Mode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinaryDecimalTest {

	@Test
	public void runTest() {
		assertEquals("1", BinaryDecimal.binaryDecimal("1", Mode.ENCODE));
		assertEquals("1100", BinaryDecimal.binaryDecimal("12", Mode.ENCODE));
		assertEquals("1111011", BinaryDecimal.binaryDecimal("123", Mode.ENCODE));
		assertEquals("1111011", BinaryDecimal.binaryDecimal("0123", Mode.ENCODE));
		assertEquals("123", BinaryDecimal.binaryDecimal("1111011", Mode.DECODE));
		assertEquals("12", BinaryDecimal.binaryDecimal("1100", Mode.DECODE));
		assertEquals("1", BinaryDecimal.binaryDecimal("1", Mode.DECODE));
	}

}
