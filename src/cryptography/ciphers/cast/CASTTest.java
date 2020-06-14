package cryptography.ciphers.cast;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import cryptography.Mode;

public class CASTTest {

	@Test
	public void runTest() {
		
		// TODO: Implement when provider fixed
		assertEquals("", CAST.cast5(Mode.ENCRYPT, "TESTING", "EXAMPLEKEY"));
		assertEquals("TESTING", CAST.cast5(Mode.DECRYPT, "", "EXAMPLEKEY"));

		// TODO: Implement when provider fixed
		assertEquals("", CAST.cast6(Mode.ENCRYPT, "TESTING", "EXAMPLEKEY"));
		assertEquals("TESTING", CAST.cast6(Mode.DECRYPT, "", "EXAMPLEKEY"));
	}

}
