package cryptography.hashes.sm3;

import java.security.Security;
import org.spongycastle.crypto.digests.SM3Digest;
import org.spongycastle.util.encoders.Hex;

public class SM3 {

	// Provider
	static {
		Security.insertProviderAt(new org.spongycastle.jce.provider.BouncyCastleProvider(), 1);
	}

	public static void main(String[] args) {
	}

	/**
	 * Source code:
	 * https://github.com/rtyley/spongycastle/blob/spongy-master/core/src/main/java/org/spongycastle/crypto/digests/SM3Digest.java
	 * 
	 * @param input string
	 * @return Hash string
	 */
	public static String sm3Hash(final String input) {
		SM3Digest sm3Digest = new SM3Digest();
		sm3Digest.update(input.getBytes(), 0, input.length());
		byte[] result = new byte[sm3Digest.getDigestSize()];
		sm3Digest.doFinal(result, 0);
		return Hex.toHexString(result);
	}

}
