package cryptography.hashes.pbkdf2;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class PBKDF2 {

	public static void main(String[] args) {
	}

	public static String createHash(String password, String salt, int iterations, int dkLen)
			throws NoSuchAlgorithmException, InvalidKeySpecException {
		byte[] saltBytes = salt.getBytes(StandardCharsets.UTF_8);
		byte[] hash = pbkdf2(password.toCharArray(), saltBytes, iterations, dkLen);
		return toHex(hash);
	}

	private static byte[] pbkdf2(char[] password, byte[] salt, int iterations, int bits)
			throws NoSuchAlgorithmException, InvalidKeySpecException {
		PBEKeySpec spec = new PBEKeySpec(password, salt, iterations, bits);
		SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
		return skf.generateSecret(spec).getEncoded();
	}

	private static String toHex(byte[] array) {
		BigInteger bi = new BigInteger(1, array);
		String hex = bi.toString(16);
		int paddingLength = (array.length * 2) - hex.length();
		if (paddingLength > 0)
			return String.format("%0" + paddingLength + "d", 0) + hex;
		else
			return hex;
	}

}
