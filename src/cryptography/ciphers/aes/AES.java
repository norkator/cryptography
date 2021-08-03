package cryptography.ciphers.aes;

import org.spongycastle.util.encoders.Base64;
import org.spongycastle.util.encoders.Hex;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.PBEParametersGenerator;
import org.spongycastle.crypto.digests.SHA256Digest;
import org.spongycastle.crypto.engines.AESEngine;
import org.spongycastle.crypto.generators.PKCS5S2ParametersGenerator;
import org.spongycastle.crypto.modes.CBCBlockCipher;
import org.spongycastle.crypto.paddings.PaddedBufferedBlockCipher;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;

import java.security.Security;

/**
 * Origin: https://gist.github.com/flof/5380133
 * Source code:
 * https://github.com/bcgit/bc-java/blob/master/core/src/main/java/org/bouncycastle/crypto/engines/AESEngine.java
 * https://github.com/rtyley/spongycastle/blob/spongy-master/core/src/main/java/org/spongycastle/crypto/modes/CBCBlockCipher.java
 *
 */
public final class AES {

	public static void main(String[] args) {
	}

	// Provider
	static {
		Security.insertProviderAt(new org.spongycastle.jce.provider.BouncyCastleProvider(), 1);
	}


	/*
	try {
		String password = "123456";
		byte[] salt = Hex.decode("68656c6c6f776f72");
		int iterations = 1000;
		int keySizeInBits = 128;
		byte[] iv = Hex.decode("68656c6c6f776f726c6468656c6c6f77");
		byte[] encryptedData = Base64.decode("");
		byte[] key = createKey(password, salt, iterations, keySizeInBits).getKey();
		String decryptedData = new String(decrypt(encryptedData, key, iv), "UTF-8");
		return decryptedData;
	} catch (Exception e) {
		throw new RuntimeException(e);
	}
	*/



	private KeyParameter createKey(String password, byte[] salt, int iterations, int keySizeInBits) {
		PKCS5S2ParametersGenerator generator = new PKCS5S2ParametersGenerator(new SHA256Digest());
		generator.init(PBEParametersGenerator.PKCS5PasswordToUTF8Bytes(password.toCharArray()), salt, iterations);
		KeyParameter key = (KeyParameter) generator.generateDerivedMacParameters(keySizeInBits);
		return key;
	}

	private static byte[] decrypt(byte[] cipher, byte[] key, byte[] iv) throws Exception {
		PaddedBufferedBlockCipher aes = createCipher(key, iv, false);
		return cipherData(aes, cipher);
	}

	private static byte[] encrypt(byte[] plain, byte[] key, byte[] iv) throws Exception {
		PaddedBufferedBlockCipher aes = createCipher(key, iv, true);
		return cipherData(aes, plain);
	}

	private static byte[] cipherData(PaddedBufferedBlockCipher cipher, byte[] data) throws Exception {
		int minSize = cipher.getOutputSize(data.length);
		byte[] outBuf = new byte[minSize];
		int length1 = cipher.processBytes(data, 0, data.length, outBuf, 0);
		int length2 = cipher.doFinal(outBuf, length1);
		int actualLength = length1 + length2;
		byte[] result = new byte[actualLength];
		System.arraycopy(outBuf, 0, result, 0, result.length);
		return result;
	}

	private static PaddedBufferedBlockCipher createCipher(byte[] key, byte[] iv, boolean forEncryption) {
		PaddedBufferedBlockCipher aes = new PaddedBufferedBlockCipher(new CBCBlockCipher(new AESEngine()));
		CipherParameters ivAndKey = new ParametersWithIV(new KeyParameter(key), iv);
		aes.init(forEncryption, ivAndKey);
		return aes;
	}


}
