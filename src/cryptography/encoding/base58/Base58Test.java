package cryptography.encoding.base58;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Base58Test {

	@Test
	public void runTest() {
		assertEquals("99v1Y8E", Base58.encodeFromString("HELLO"));
		assertEquals("HELLO", Base58.decodeToString("99v1Y8E"));
	}

}
