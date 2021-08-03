package cryptography.ciphers.idea;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.GeneralSecurityException;
import java.security.Security;

/**
 * Source code:
 * https://github.com/bcgit/bc-java/blob/master/prov/src/main/java/org/bouncycastle/jcajce/provider/symmetric/IDEA.java
 * https://github.com/bcgit/bc-java/blob/master/core/src/main/java/org/bouncycastle/crypto/engines/IDEAEngine.java
 */
public class IDEA {

	public static void main(String[] args) {
	}

	// Provider
	static {
		Security.insertProviderAt(new org.bouncycastle.jce.provider.BouncyCastleProvider(), 1);
	}

	public static String encrypt(String input, String key) {
		org.apache.commons.codec.binary.Base64 base64 = new org.apache.commons.codec.binary.Base64();
		String output = "";
		try {
			SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "IDEA");
			Cipher cipher = Cipher.getInstance("IDEA");
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
			output = base64.encodeToString(cipher.doFinal(input.getBytes()));
		} catch (GeneralSecurityException e) {
			e.printStackTrace();
			return e.toString();
		}
		return output;
	}


	public static String decrypt(String input, String key) {
		org.apache.commons.codec.binary.Base64 base64 = new org.apache.commons.codec.binary.Base64();
		String output = "";
		try {
			SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "IDEA");
			Cipher cipher = Cipher.getInstance("IDEA");
			cipher.init(Cipher.DECRYPT_MODE, secretKey);
			output = new String(cipher.doFinal(base64.decode(input.getBytes())));
		} catch (GeneralSecurityException e) {
			e.printStackTrace();
			return e.toString();
		}
		return output;
	}

}
