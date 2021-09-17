package cryptography.ciphers.VIC;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class VICTest {

	@Test
	public void runTest() {

		int date = 13919;
		int keyGroup = 72401;
		int personalNo = 6;
		
		assertEquals("5961328470",VIC.keyGen("Twas the night before christmas", date, personalNo, keyGroup));
		assertEquals("5995696459665833",VIC.encrypt("Attack at dawn", "AT ONE SIR", "Twas the night before christmas", date, personalNo, keyGroup));
	}
}
