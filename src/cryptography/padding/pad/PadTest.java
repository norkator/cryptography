/*
 * This class is part of running automated tests
 */
package cryptography.padding.pad;

import org.junit.Test;
import org.junit.Assert;

public class PadTest {

	@Test
	public void runTest() {
		Assert.assertEquals("0010", Pad.to4("10"));
		Assert.assertEquals("1010", Pad.to4("1010"));
		Assert.assertEquals("Input exception. \nCannot pad. \nInput length > 4", Pad.to4("10101"));

		Assert.assertEquals("00101010", Pad.to8("101010"));
		Assert.assertEquals("10101010", Pad.to8("10101010"));
		Assert.assertEquals("Input exception. \nCannot pad. \nInput length > 8", Pad.to8("101010101"));


		Assert.assertEquals("0000001010101010", Pad.to16("1010101010"));
		Assert.assertEquals("1010101010101010", Pad.to16("1010101010101010"));
		Assert.assertEquals("Input exception. \nCannot pad. \nInput length > 16", Pad.to16("10101010101010101"));


		Assert.assertEquals("00000000000000101010101010101010", Pad.to32("101010101010101010"));
		Assert.assertEquals("10101010101010101010101010101010", Pad.to32("10101010101010101010101010101010"));
		Assert.assertEquals("Input exception. \nCannot pad. \nInput length > 32", Pad.to32("101010101010101010101010101010101"));


		Assert.assertEquals("000101", Pad.toCustomLength("101", 6));
		Assert.assertEquals("101010", Pad.toCustomLength("101010", 6));
		Assert.assertEquals("Input exception. \nCannot pad. \nInput length > 6", Pad.toCustomLength("1010101", 6));

	}

}
