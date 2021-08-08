/**
 * This class is part of running automated tests
 */
package cryptography.converters.binaryDecimal;

import cryptography.Mode;
import cryptography.hashes.adler.Adler;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinaryDecimalTest {

	@Test
	public void runTest() {
		assertEquals("1111011", BinaryDecimal.binaryDecimal("123", Mode.ENCODE));
		assertEquals("123", BinaryDecimal.binaryDecimal("1111011", Mode.DECODE));
	}

}
