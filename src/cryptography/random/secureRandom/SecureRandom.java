package cryptography.random.secureRandom;

import java.security.NoSuchAlgorithmException;

public class SecureRandom {

	// Available secure random instance algorithms
	public final static String INSTANCE_ALGORITHM_SHA1PRNG = "SHA1PRNG";

	public static void main(String[] args) {
	}


	/**
	 * Generate secure random bytes
	 * https://docs.oracle.com/javase/8/docs/api/java/security/SecureRandom.html#getInstance-java.lang.String-
	 *
	 * @param count,     how many bytes to create
	 * @param algorithm, chose algorithm (up on this class)
	 * @return array of bytes
	 * @throws NoSuchAlgorithmException ...
	 */
	public static byte[] secureRandomBytes(int count, String algorithm) throws NoSuchAlgorithmException {
		byte[] b = new byte[count];
		java.security.SecureRandom.getInstance(algorithm).nextBytes(b);
		return b;
	}

	/**
	 * Strong secure random bytes
	 * https://docs.oracle.com/javase/8/docs/api/java/security/SecureRandom.html#getInstanceStrong--
	 *
	 * @param count, how many bytes to create
	 * @return array of bytes
	 * @throws NoSuchAlgorithmException ...
	 */
	public static byte[] secureRandomStrongBytes(int count) throws NoSuchAlgorithmException {
		byte[] b = new byte[count];
		java.security.SecureRandom.getInstanceStrong().nextBytes(b);
		return b;
	}


}
