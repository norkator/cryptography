/**
 * This class is part of running automated tests
 */
package cryptography.hashes.pbkdf2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import org.junit.Test;

public class PBKDF2Test {

	@Test
	public void runTest() {
		try {
			assertEquals(
				"5a27c13513ac42482cce07a543293c56dbfe06deb56634c1f2c6bd1cdeaab1bd373e22861d1f6c6785a406f0d75a7f247f87666b02d08f142c9097e8d40e6f17",
				PBKDF2.createHash(PBKDF2HmacOption.HmacSHA1, "test input", "testsalt", 2, 512));
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			fail(e.getMessage());
		}

		try {
			assertEquals(
				"bca6328db87bb9ff841a4cbe28e113d875682014462d5548f07f6135f775a146461be79e7c38ff8dbcd9f055142201394cda77a627c7c07d829c7fe77e63a4c1",
				PBKDF2.createHash(PBKDF2HmacOption.HmacSHA256, "test input", "testsalt", 2, 512));
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			fail(e.getMessage());
		}

		try {
			assertEquals(
				"7b70b26da3cb5e1303baab07b1710585bb9fa2cf6505cee5fe6f4035d399dabbd68e6b06f4aed94f0d33e24ddebf38cca6b0966560f394a715bac78c0348e817",
				PBKDF2.createHash(PBKDF2HmacOption.HmacSHA384, "test input", "testsalt", 2, 512));
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			fail(e.getMessage());
		}

		try {
			assertEquals(
				"653c30fa30b2fac766e885bc5ed8af4d993dfdc8d5b68f4133987ef300b1ede9cfc50d40798ecac23e424eb5bebca2a7d77ff4df6e26dddfe5ab854023030bc8",
				PBKDF2.createHash(PBKDF2HmacOption.HmacSHA512, "test input", "testsalt", 2, 512));
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			fail(e.getMessage());
		}
	}

}
