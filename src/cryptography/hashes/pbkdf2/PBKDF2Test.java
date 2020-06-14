/**
 * This class is part of running automated tests
 */
package cryptography.hashes.pbkdf2;

import static org.junit.Assert.assertEquals;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import org.junit.Test;

public class PBKDF2Test {

	@Test
	public void runTest() {
		try {
			assertEquals(
					"5a27c13513ac42482cce07a543293c56dbfe06deb56634c1f2c6bd1cdeaab1bd373e22861d1f6c6785a406f0d75a7f247f87666b02d08f142c9097e8d40e6f17",
					PBKDF2.createHash("test input", "testsalt", 2, 512));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
		}
	}

}
