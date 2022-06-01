package cryptography.ciphers.navajo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class NavajoTest {

	@Test
	public void runTest() {
		String result = Navajo.encrypt("A");
		assertTrue(result.contains("WOL-LA-CHEE") ||
			result.contains("BE-LA-SANA") ||
			result.contains("TSE-NILL")
		);

		assertEquals("TSAH-AS-ZIH BESH-DO-TLIZ ", Navajo.encrypt("YZ"));

		assertEquals("AA", Navajo.decrypt("WOL-LA-CHEE TSE-NILL"));
	}

}
