/**
 * This class is part of running automated tests
 */
package cryptography.hashes.crc;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CRCTest {

	@Test
	public void runTest() {
		assertEquals("185", CRC.crc8("test"));
		assertEquals("63534", CRC.crc16("test"));
		assertEquals("16281296", CRC.crc24("test"));
		assertEquals("3632233996", CRC.crc32("test"));
		assertEquals("5e427677838d37c0", CRC.crc64("testing"));
	}

}
