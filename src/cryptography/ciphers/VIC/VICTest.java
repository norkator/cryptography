package cryptography.ciphers.VIC;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class VICTest {

	@Test
	public void runTest() {

		int date = (int)(Math.random() * (89999) + 10000);
		int key = (int)(Math.random() * (89999) + 10000);
		int personalNo = (int)(Math.random() * 10);
		assertEquals("abc",VIC.encrypt("Twas the night before christmas", 13919, 6, 72401));
	}
}
