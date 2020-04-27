/**
 * This class is part of running automated tests
 */
package cryptography.ciphers.playfair;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import cryptography.Mode;

public class PlayfairTest {

	@Test
	public void runTest() {
		assertEquals("MBQFHQVPFNEQCAQY", Playfair.playfair("HELLOWORLDTEST", "ISFAIR", true, Mode.ENCRYPT));
		assertEquals("HELXLOWORLDTESTX", Playfair.playfair("MBQFHQVPFNEQCAQY", "ISFAIR", true, Mode.DECRYPT));
	}

}
