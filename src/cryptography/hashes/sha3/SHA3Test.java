/**
 * This class is part of running automated tests
 */
package cryptography.hashes.sha3;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SHA3Test {

	@Test
	public void runTest() {
		assertEquals("04eaf0c175aa45299155aca3f97e41c2d684eb0978c9af6cd88c5a51", SHA3.sha3_224("testing"));
		assertEquals("7f5979fb78f082e8b1c676635db8795c4ac6faba03525fb708cb5fd68fd40c5e", SHA3.sha3_256("testing"));
		assertEquals("e15a44d4e12ac138db4b8d77e954d78d94de4391ec2d1d8b2b8ace1a2f4b3d2fb9efd0546d6fcafacbe5b1640639b005", SHA3.sha3_384("testing"));
		assertEquals("881c7d6ba98678bcd96e253086c4048c3ea15306d0d13ff48341c6285ee71102a47b6f16e20e4d65c0c3d677be689dfda6d326695609cbadfafa1800e9eb7fc1", SHA3.sha3_512("testing"));
	}

}
