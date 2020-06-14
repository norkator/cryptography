package cryptography.ciphers.cast;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import cryptography.Mode;

public class CASTTest {

	@Test
	public void runTest() {

		assertEquals("KfqJ96FlihQ=", CAST.cast5(Mode.ENCRYPT, "TESTING", "EXAMPLEKEY"));
		assertEquals("TESTING", CAST.cast5(Mode.DECRYPT, "KfqJ96FlihQ=", "EXAMPLEKEY"));

		assertEquals("YuWPzdF2f6QknZIQRYWpPw==", CAST.cast6(Mode.ENCRYPT, "TESTING", "EXAMPLEKEY"));
		assertEquals("TESTING", CAST.cast6(Mode.DECRYPT, "YuWPzdF2f6QknZIQRYWpPw==", "EXAMPLEKEY"));
	}

}
