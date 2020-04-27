package cryptography.ciphers.railfence;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import cryptography.Mode;

public class RailFenceTest {

	@Test
	public void runTest() {
		assertEquals("hdeel txlrl tloorowne g", RailFence.railFence("Hello world longer text", Mode.ENCRYPT, 6));
		assertEquals("hello world longer text", RailFence.railFence("hdeel txlrl tloorowne g", Mode.DECRYPT, 6));
	}

}
