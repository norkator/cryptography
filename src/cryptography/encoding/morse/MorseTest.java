/**
 * This class is part of running automated tests
 */
package cryptography.encoding.morse;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import cryptography.Mode;

public class MorseTest {

	@Test
	public void runTest() {
		assertEquals("- . ... - .. -. --. -- --- .-. ... . ", Morse.morse("TESTING MORSE", Mode.ENCODE));
		assertEquals("TESTINGMORSE", Morse.morse("- . ... - .. -. --. -- --- .-. ... .", Mode.DECODE));

		assertEquals(
				".- -... -.-. -.. . ..-. --. .... .. .--- -.- .-.. -- -. --- .--. --.- .-. ... - ..- ...- .-- -..- -.-- --.. ",
				Morse.morse("ABCDEFGHIJKLMNOPQRSTUVWXYZ", Mode.ENCODE));
		assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZ", Morse.morse(
				".- -... -.-. -.. . ..-. --. .... .. .--- -.- .-.. -- -. --- .--. --.- .-. ... - ..- ...- .-- -..- -.-- --..",
				Mode.DECODE));
	}

}
