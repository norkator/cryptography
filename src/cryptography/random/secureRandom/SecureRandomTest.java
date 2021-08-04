/*
 * This class is part of running automated tests
 */
package cryptography.random.secureRandom;

import cryptography.random.dummy.Dummy;
import org.junit.Test;

import java.security.NoSuchAlgorithmException;

import static org.junit.Assert.assertEquals;

public class SecureRandomTest {

	@Test
	public void runTest() {
		try {
			byte[] bytes1 = SecureRandom.secureRandomBytes(16, SecureRandom.INSTANCE_ALGORITHM_SHA1PRNG);
			byte[] bytes2 = SecureRandom.secureRandomStrongBytes(16);

			assertEquals(16, bytes1.length);
			assertEquals(16, bytes2.length);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}

}
