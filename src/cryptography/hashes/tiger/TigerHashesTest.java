/**
 * This class is part of running automated tests
 */
package cryptography.hashes.tiger;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TigerHashesTest {

	@Test
	public void runTest() {
		assertEquals("1f5fa5df7393dbe3ce6f3e24272cd272245298d843a5311d", TigerHashes.tiger("testing"));
		assertEquals("a87b6f460ac838dbb0e7923ce62f76294f1f99ddef8192b6", TigerHashes.tiger2("testing"));
		assertEquals("1f5fa5df7393dbe3ce6f3e24272cd272", TigerHashes.tiger128("testing"));
		assertEquals("1f5fa5df7393dbe3ce6f3e24272cd272245298d8", TigerHashes.tiger160("testing"));
	}

}
