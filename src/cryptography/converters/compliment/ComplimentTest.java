/*
 * This class is part of running automated tests
 */
package cryptography.converters.compliment;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ComplimentTest {

	@Test
	public void runTest() {
		assertEquals("11001100", Compliment.oneCompliment("00110011"));
		assertEquals("11111111", Compliment.oneCompliment("00000000"));
		assertEquals("00000000", Compliment.oneCompliment("11111111"));

		assertEquals("11001101", Compliment.twoCompliment("00110011"));
		assertEquals("00000000", Compliment.twoCompliment("00000000"));
		assertEquals("00000001", Compliment.twoCompliment("11111111"));
		assertEquals("11111111", Compliment.twoCompliment("00000001"));
	}

}
