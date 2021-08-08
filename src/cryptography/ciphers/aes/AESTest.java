package cryptography.ciphers.aes;

import cryptography.random.secureRandom.SecureRandom;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

@SuppressWarnings("DuplicatedCode")
public class AESTest {

	private final static String plainText = "Simple testing string for AES cipher encryption and decryption testing";
	private final static String password = "test password for AES testing";

	@Test
	public void runTest() {
		try {
			assertEquals(plainText, aesWithBlankIV());
			assertEquals(plainText, aes128WithStrongIV());
			assertEquals(plainText, aes192WithStrongIV());
			assertEquals(plainText, aes256WithStrongIV());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static String aesWithBlankIV() throws Exception {
		byte[] salt = SecureRandom.secureRandomStrongBytes(16);
		byte[] iv = AES.IV_BLANK;
		byte[] key = AES.createKey(password, salt, AES.KEY_GENERATION_ITERATIONS, AES.KEY_SIZE_256_BITS).getKey();
		String encrypted = AES.encrypt(plainText, key, iv);
		return AES.decrypt(encrypted, key, iv);
	}

	private static String aes128WithStrongIV() throws Exception {
		byte[] salt = SecureRandom.secureRandomStrongBytes(16);
		byte[] iv = SecureRandom.secureRandomStrongBytes(16);
		byte[] key = AES.createKey(password, salt, AES.KEY_GENERATION_ITERATIONS, AES.KEY_SIZE_128_BITS).getKey();
		String encrypted = AES.encrypt(plainText, key, iv);
		return AES.decrypt(encrypted, key, iv);
	}

	private static String aes192WithStrongIV() throws Exception {
		byte[] salt = SecureRandom.secureRandomStrongBytes(16);
		byte[] iv = SecureRandom.secureRandomStrongBytes(16);
		byte[] key = AES.createKey(password, salt, AES.KEY_GENERATION_ITERATIONS, AES.KEY_SIZE_192_BITS).getKey();
		String encrypted = AES.encrypt(plainText, key, iv);
		return AES.decrypt(encrypted, key, iv);
	}

	private static String aes256WithStrongIV() throws Exception {
		byte[] salt = SecureRandom.secureRandomStrongBytes(16);
		byte[] iv = SecureRandom.secureRandomStrongBytes(16);
		byte[] key = AES.createKey(password, salt, AES.KEY_GENERATION_ITERATIONS, AES.KEY_SIZE_256_BITS).getKey();
		String encrypted = AES.encrypt(plainText, key, iv);
		return AES.decrypt(encrypted, key, iv);
	}

}
