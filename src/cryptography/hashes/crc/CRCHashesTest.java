/**
 * This class is part of running automated tests
 */
package cryptography.hashes.crc;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CRCHashesTest {

	@Test
	public void runTest() {
		assertEquals("185", CRCHashes.crc8("test"));
		assertEquals("63534", CRCHashes.crc16("test"));
		assertEquals("16281296", CRCHashes.crc24("test"));
		assertEquals("3632233996", CRCHashes.crc32("test"));
		assertEquals("5e427677838d37c0", CRCHashes.crc64("testing"));
	}

}
