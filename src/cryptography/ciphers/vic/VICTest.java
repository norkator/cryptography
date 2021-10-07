package cryptography.ciphers.vic;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class VICTest {

	@Test
	public void runTest() {
		int date = 741776;
		int keyGroup = 77651;
		int personalNo = 8;

		assertEquals("1205348679", VIC.keyGen("I dream of Jeannie with t", date, personalNo, keyGroup));

		String plainText = "We are pleased to hear of your success in establishing your false identity You will be sent some money to cover expenses within a month";

		try {
			String cipherText = VIC.encrypt(plainText,
				"AT ONE SIR",
				"I dream of Jeannie with t",
				date, personalNo, keyGroup);


			String decipherText = VIC.decrypt(cipherText,
				"AT ONE SIR",
				"I dream of Jeannie with t",
				date, personalNo, keyGroup);

			assertEquals(plainText.toUpperCase().replaceAll(" ", ""), decipherText);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

}
