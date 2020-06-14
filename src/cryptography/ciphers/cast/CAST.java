package cryptography.ciphers.cast;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import org.spongycastle.crypto.engines.CAST5Engine;
import org.spongycastle.crypto.engines.CAST6Engine;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import cryptography.Mode;

public class CAST {

	public static void main(String[] args) {
	}

	// Provider
	static {
		Security.insertProviderAt(new org.spongycastle.jce.provider.BouncyCastleProvider(), 1);
	}

	/**
	 * Source code:
	 * https://github.com/rtyley/spongycastle/blob/spongy-master/core/src/main/java/org/spongycastle/crypto/engines/CAST5Engine.java
	 * 
	 * @param mode  cipher mode
	 * @param input string
	 * @param key   cipher key
	 * @return Hash string
	 */
	public static String cast5(Mode mode, String input, String key) {
		org.apache.commons.codec.binary.Base64 base64 = new org.apache.commons.codec.binary.Base64();
		try {
			if (mode == Mode.ENCRYPT) {
				try {
					SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), new CAST5Engine().getAlgorithmName());
					Cipher cipher = Cipher.getInstance(new CAST5Engine().getAlgorithmName());
					cipher.init(Cipher.ENCRYPT_MODE, secretKey);
					return base64.encodeToString(cipher.doFinal(input.getBytes("UTF-8")));
				} catch (NoSuchAlgorithmException | NoSuchPaddingException | UnsupportedEncodingException
						| BadPaddingException | IllegalBlockSizeException | InvalidKeyException e) {
					e.printStackTrace();
				}
			}
			if (mode == Mode.DECRYPT) {
				SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), new CAST5Engine().getAlgorithmName());
				Cipher cipher = Cipher.getInstance(new CAST5Engine().getAlgorithmName());
				cipher.init(Cipher.DECRYPT_MODE, secretKey);
				return new String(cipher.doFinal(base64.decode(input.getBytes())));
			}
		} catch (NoSuchAlgorithmException | BadPaddingException | NoSuchPaddingException | IllegalBlockSizeException
				| InvalidKeyException e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}

	/**
	 * Source code:
	 * https://github.com/rtyley/spongycastle/blob/spongy-master/core/src/main/java/org/spongycastle/crypto/engines/CAST6Engine.java
	 * 
	 * @param mode  cipher mode
	 * @param input string
	 * @param key   cipher key
	 * @return Hash string
	 */
	public static String cast6(Mode mode, String input, String key) {
		org.apache.commons.codec.binary.Base64 base64 = new org.apache.commons.codec.binary.Base64();
		try {
			if (mode == Mode.ENCRYPT) {
				try {
					SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), new CAST6Engine().getAlgorithmName());
					Cipher cipher = Cipher.getInstance(new CAST6Engine().getAlgorithmName());
					cipher.init(Cipher.ENCRYPT_MODE, secretKey);
					return base64.encodeToString(cipher.doFinal(input.getBytes("UTF-8")));
				} catch (NoSuchAlgorithmException | NoSuchPaddingException | UnsupportedEncodingException
						| BadPaddingException | IllegalBlockSizeException | InvalidKeyException e) {
					e.printStackTrace();
				}
			}
			if (mode == Mode.DECRYPT) {
				SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), new CAST6Engine().getAlgorithmName());
				Cipher cipher = Cipher.getInstance(new CAST6Engine().getAlgorithmName());
				cipher.init(Cipher.DECRYPT_MODE, secretKey);
				return new String(cipher.doFinal(base64.decode(input.getBytes())));
			}
		} catch (NoSuchAlgorithmException | BadPaddingException | NoSuchPaddingException | IllegalBlockSizeException
				| InvalidKeyException e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}

}
