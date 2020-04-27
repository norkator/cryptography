/**
 * This class is part of running automated tests
 */
package cryptography.ciphers.keyword;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import cryptography.Mode;

public class KeywordTest {

	@Test
	public void runTest() {
		assertEquals("RBQRGLDRFGQ", Keyword.keyword("TESTINGTHIS", "TEST", Mode.ENCRYPT));
		assertEquals("TESTINGTHIS", Keyword.keyword("RBQRGLDRFGQ", "TEST", Mode.DECRYPT));
	}

}
