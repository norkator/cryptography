/**
 * This class is part of running automated tests
 */
package cryptography.hashes.sha2;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SHA2Test {

	@Test
	public void runTest() {
		assertEquals("9e8965af89bd98c015512f1eb17ae07f48494da2d9a06a8f9659f749", SHA2.sha2_224("testing"));
		assertEquals("cf80cd8aed482d5d1527d7dc72fceff84e6326592848447d2dc0b0e87dfc9a90", SHA2.sha2_256("testing"));
		assertEquals("cf4811d74fd40504674fc3273f824fa42f755b9660a2e902b57f1df74873db1a91a037bcee65f1a88ecd1ef57ff254c9", SHA2.sha2_384("testing"));
		assertEquals("521b9ccefbcd14d179e7a1bb877752870a6d620938b28a66a107eac6e6805b9d0989f45b5730508041aa5e710847d439ea74cd312c9355f1f2dae08d40e41d50", SHA2.sha2_512("testing"));
	}

}
