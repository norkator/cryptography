package cryptography.ciphers.rc;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import cryptography.Mode;

public class RCTest {

	@Test
	public void runTest() {
		assertEquals("G2DXHTkgYEY=", RC.rc2(Mode.ENCRYPT, "TESTING", "EXAMPLEKEY"));
		assertEquals("TESTING", RC.rc2(Mode.DECRYPT, "G2DXHTkgYEY=", "EXAMPLEKEY"));

		assertEquals("HUUcc9q/5Q==", RC.rc4(Mode.ENCRYPT, "TESTING", "EXAMPLEKEY"));
		assertEquals("TESTING", RC.rc4(Mode.DECRYPT, "HUUcc9q/5Q==", "EXAMPLEKEY"));

		assertEquals("UEsASt9knf1TT0izJpmlkQ==", RC.rc6(Mode.ENCRYPT, "TESTING", "EXAMPLEKEY"));
		assertEquals("TESTING", RC.rc6(Mode.DECRYPT, "UEsASt9knf1TT0izJpmlkQ==", "EXAMPLEKEY"));
	}

}
