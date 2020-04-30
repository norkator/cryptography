/**
 * This class is part of running automated tests
 */
package cryptography.hashes.blake2b;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class Blake2bTest {

	@Test
	public void runTest() {
		assertEquals("29dd08796a3b9decb7295ddda81276a482622a2d", Blake2b.blake2b160("testing"));
		assertEquals("99397ff32ae348b8b6536d5c213f343d7e9fdeaa10e8a23a9f90ab21a1658565", Blake2b.blake2b256("testing"));
		assertEquals("65a6119247ca481f3f52ae8a55d81d54c342268bfce908639e74768c4b56f9337e76ae04958cbefb4b9fe0da86c8a32b",
				Blake2b.blake2b384("testing"));
		assertEquals(
				"ebe9280817d5223a6f8ac5934680784aac5c48533779e9d9a01819da920a7937bc1c3c5ba9e6099567c4e74a3abc57e07d2c77797dbb78fed1dbcfb8cd503c29",
				Blake2b.blake2b512("testing"));
	}

}
