/**
 * This class is part of running automated tests
 */
package cryptography.hashes.keccak;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class KeccakTest {

	@Test
	public void runTest() {
		assertEquals("5f16f4c7f149ac4f9510d9cf8cf384038ad348b3bcdc01915f95de12df9d1b02", Keccak.keccak_256("testing"));
		assertEquals("1020b1c91956efe79b89c387b54de4f7a9c187c3970552f9f48c0da176f6326b7aa694795d2c9adcf2bdd20aec605588",
				Keccak.keccak_384("testing"));
		assertEquals(
				"9558a7ba9ac74b33b347703ffe33f8d561d86d9fcad1cfd63225fb55dfea50a0953a0efafd6072377f4c396e806d5bda0294cba28762740d8446fee45a276e4a",
				Keccak.keccak_512("testing"));
	}

}
