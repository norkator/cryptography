package cryptography.hashes.blake2b;

import java.security.Security;
import org.spongycastle.util.encoders.Hex;

public class Blake2b {

	// Provider
	static {
		Security.insertProviderAt(new org.spongycastle.jce.provider.BouncyCastleProvider(), 1);
	}

	public static void main(String[] args) {
	}

	/**
	 * Source code:
	 * https://github.com/rtyley/spongycastle/blob/spongy-master/core/src/main/java/org/spongycastle/crypto/digests/Blake2bDigest.java
	 * 
	 * @param input string
	 * @return Hash string
	 */
	public static String blake2b160(final String input) {
		org.spongycastle.jcajce.provider.digest.Blake2b.Blake2b160 blake2b160 = new org.spongycastle.jcajce.provider.digest.Blake2b.Blake2b160();
		byte[] digest = blake2b160.digest(input.getBytes());
		return Hex.toHexString(digest);
	}

	/**
	 * Source code:
	 * https://github.com/rtyley/spongycastle/blob/spongy-master/core/src/main/java/org/spongycastle/crypto/digests/Blake2bDigest.java
	 * 
	 * @param input string
	 * @return Hash string
	 */
	public static String blake2b256(final String input) {
		org.spongycastle.jcajce.provider.digest.Blake2b.Blake2b256 blake2b256 = new org.spongycastle.jcajce.provider.digest.Blake2b.Blake2b256();
		byte[] digest = blake2b256.digest(input.getBytes());
		return Hex.toHexString(digest);
	}

	/**
	 * Source code:
	 * https://github.com/rtyley/spongycastle/blob/spongy-master/core/src/main/java/org/spongycastle/crypto/digests/Blake2bDigest.java
	 * 
	 * @param input string
	 * @return Hash string
	 */
	public static String blake2b384(final String input) {
		org.spongycastle.jcajce.provider.digest.Blake2b.Blake2b384 blake2b384 = new org.spongycastle.jcajce.provider.digest.Blake2b.Blake2b384();
		byte[] digest = blake2b384.digest(input.getBytes());
		return Hex.toHexString(digest);
	}

	/**
	 * Source code:
	 * https://github.com/rtyley/spongycastle/blob/spongy-master/core/src/main/java/org/spongycastle/crypto/digests/Blake2bDigest.java
	 * 
	 * @param input string
	 * @return Hash string
	 */
	public static String blake2b512(final String input) {
		org.spongycastle.jcajce.provider.digest.Blake2b.Blake2b512 blake2b512 = new org.spongycastle.jcajce.provider.digest.Blake2b.Blake2b512();
		byte[] digest = blake2b512.digest(input.getBytes());
		return Hex.toHexString(digest);
	}

}
