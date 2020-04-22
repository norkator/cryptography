package Cryptography.caesar;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import Cryptography.Mode;

public class CaesarJUnit {

	@Test
	@DisplayName("Testing Caesar encrypt and decrypt methods")
	void runTest() {
		assertEquals("KHOOR", Caesar.caesar("HELLO", 3, Mode.ENCRYPT));
		assertEquals("HELLO", Caesar.caesar("KHOOR", 3, Mode.DECRYPT));	
	}

}
