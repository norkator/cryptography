package cryptography.hashes.sha3;

import java.security.Security;
import org.spongycastle.util.encoders.Hex;

public class SHA3 {

	// Provider
	static {
		Security.insertProviderAt(new org.spongycastle.jce.provider.BouncyCastleProvider(), 1);
	}

	public static void main(String[] args) {
	}

	/**
	 * Source code:
	 * https://github.com/rtyley/spongycastle/blob/spongy-master/core/src/main/java/org/spongycastle/crypto/digests/SHA3Digest.java
	 * 
	 * @param input string
	 * @return Hash string
	 */
	public static String sha3_224(final String input) {
		org.spongycastle.jcajce.provider.digest.SHA3.DigestSHA3 sha3 = new org.spongycastle.jcajce.provider.digest.SHA3.Digest224();
		byte[] digest = sha3.digest(input.getBytes());
		return Hex.toHexString(digest);
	}

	/**
	 * Source code:
	 * https://github.com/rtyley/spongycastle/blob/spongy-master/core/src/main/java/org/spongycastle/crypto/digests/SHA3Digest.java
	 * 
	 * @param input string
	 * @return Hash string
	 */
	public static String sha3_256(final String input) {
		org.spongycastle.jcajce.provider.digest.SHA3.DigestSHA3 sha3 = new org.spongycastle.jcajce.provider.digest.SHA3.Digest256();
		byte[] digest = sha3.digest(input.getBytes());
		return Hex.toHexString(digest);
	}

	/**
	 * Source code:
	 * https://github.com/rtyley/spongycastle/blob/spongy-master/core/src/main/java/org/spongycastle/crypto/digests/SHA3Digest.java
	 * 
	 * @param input string
	 * @return Hash string
	 */
	public static String sha3_384(final String input) {
		org.spongycastle.jcajce.provider.digest.SHA3.DigestSHA3 sha3 = new org.spongycastle.jcajce.provider.digest.SHA3.Digest384();
		byte[] digest = sha3.digest(input.getBytes());
		return Hex.toHexString(digest);
	}

	/**
	 * Source code:
	 * https://github.com/rtyley/spongycastle/blob/spongy-master/core/src/main/java/org/spongycastle/crypto/digests/SHA3Digest.java
	 * 
	 * @param input string
	 * @return Hash string
	 */
	public static String sha3_512(final String input) {
		org.spongycastle.jcajce.provider.digest.SHA3.DigestSHA3 sha3 = new org.spongycastle.jcajce.provider.digest.SHA3.Digest512();
		byte[] digest = sha3.digest(input.getBytes());
		return Hex.toHexString(digest);
	}

}
