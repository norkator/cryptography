package cryptography.hashes.keccak;

import java.security.Security;
import org.spongycastle.util.encoders.Hex;

public class Keccak {

	public static void main(String[] args) {
	}

	// Provider
	static {
		Security.insertProviderAt(new org.spongycastle.jce.provider.BouncyCastleProvider(), 1);
	}

	/**
	 * Source code:
	 * https://github.com/rtyley/spongycastle/blob/spongy-master/core/src/main/java/org/spongycastle/crypto/digests/KeccakDigest.java
	 * 
	 * @param input string
	 * @return Hash string
	 */
	public static String keccak_256(final String input) {
		org.spongycastle.jcajce.provider.digest.Keccak.Digest256 digest256 = new org.spongycastle.jcajce.provider.digest.Keccak.Digest256();
		byte[] digest = digest256.digest(input.getBytes());
		return Hex.toHexString(digest);
	}

	/**
	 * Source code:
	 * https://github.com/rtyley/spongycastle/blob/spongy-master/core/src/main/java/org/spongycastle/crypto/digests/KeccakDigest.java
	 * 
	 * @param input string
	 * @return Hash string
	 */
	public static String keccak_384(final String input) {
		org.spongycastle.jcajce.provider.digest.Keccak.Digest384 digest384 = new org.spongycastle.jcajce.provider.digest.Keccak.Digest384();
		byte[] digest = digest384.digest(input.getBytes());
		return Hex.toHexString(digest);
	}

	/**
	 * Source code:
	 * https://github.com/rtyley/spongycastle/blob/spongy-master/core/src/main/java/org/spongycastle/crypto/digests/KeccakDigest.java
	 * 
	 * @param input string
	 * @return Hash string
	 */
	public static String keccak_512(final String input) {
		org.spongycastle.jcajce.provider.digest.Keccak.Digest512 digest512 = new org.spongycastle.jcajce.provider.digest.Keccak.Digest512();
		byte[] digest = digest512.digest(input.getBytes());
		return Hex.toHexString(digest);
	}
}
