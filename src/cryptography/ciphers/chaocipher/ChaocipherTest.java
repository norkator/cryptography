/**
 * This class is part of running automated tests
 */
package cryptography.ciphers.chaocipher;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import cryptography.Mode;

public class ChaocipherTest {

	@Test
	public void runTest() {
		assertEquals("STMLH", Chaocipher.chaocipher("HELLO", Mode.ENCRYPT, "ABCDEFGHIJKLMNOPQRSTUVWXYZ",
				"ZYXWVUTSRQPONMLKJIHGFEDCBA"));
		assertEquals("HELLO", Chaocipher.chaocipher("STMLH", Mode.DECRYPT, "ABCDEFGHIJKLMNOPQRSTUVWXYZ",
				"ZYXWVUTSRQPONMLKJIHGFEDCBA"));
	}

}
