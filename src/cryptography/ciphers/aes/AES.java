package cryptography.ciphers.aes;

import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.PBEParametersGenerator;
import org.spongycastle.crypto.digests.SHA256Digest;
import org.spongycastle.crypto.engines.AESEngine;
import org.spongycastle.crypto.generators.PKCS5S2ParametersGenerator;
import org.spongycastle.crypto.modes.CBCBlockCipher;
import org.spongycastle.crypto.paddings.PaddedBufferedBlockCipher;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.util.encoders.Base64;

import java.nio.charset.StandardCharsets;
import java.security.Security;

/**
 * Origin: https://gist.github.com/flof/5380133
 * Source code:
 * https://github.com/bcgit/bc-java/blob/master/core/src/main/java/org/bouncycastle/crypto/engines/AESEngine.java
 * https://github.com/rtyley/spongycastle/blob/spongy-master/core/src/main/java/org/spongycastle/crypto/modes/CBCBlockCipher.java
 */
public final class AES {

	// Key size options
	public final static int KEY_SIZE_128_BITS = 128;
	public final static int KEY_SIZE_192_BITS = 192;
	public final static int KEY_SIZE_256_BITS = 256;

	// Blank initialization vector for compatibility use
	public static final byte[] IV_BLANK = {0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00};

	// Some iterations
	public static final int KEY_GENERATION_ITERATIONS = 1000;

	public static void main(String[] args) {
	}

	// Provider
	static {
		Security.insertProviderAt(new org.spongycastle.jce.provider.BouncyCastleProvider(), 1);
	}


	public static KeyParameter createKey(String password, byte[] salt, int iterations, int keySizeInBits) {
		PKCS5S2ParametersGenerator generator = new PKCS5S2ParametersGenerator(new SHA256Digest());
		generator.init(PBEParametersGenerator.PKCS5PasswordToUTF8Bytes(password.toCharArray()), salt, iterations);
		return (KeyParameter) generator.generateDerivedMacParameters(keySizeInBits);
	}

	public static String decrypt(String cipher, byte[] key, byte[] iv) throws Exception {
		PaddedBufferedBlockCipher aes = createCipher(key, iv, false);
		return new String(cipherData(aes, Base64.decode(cipher)), StandardCharsets.UTF_8);
	}

	public static String encrypt(String plain, byte[] key, byte[] iv) throws Exception {
		PaddedBufferedBlockCipher aes = createCipher(key, iv, true);
		return Base64.toBase64String(cipherData(aes, plain.getBytes()));
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
