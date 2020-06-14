package cryptography.hashes.skein;

import java.security.Security;
import org.spongycastle.util.encoders.Hex;

public class Skein {

	public static void main(String[] args) {
	}

	// Provider
	static {
		Security.insertProviderAt(new org.spongycastle.jce.provider.BouncyCastleProvider(), 1);
	}

	/**
	 * Source code:
	 * https://github.com/rtyley/spongycastle/blob/spongy-master/core/src/main/java/org/spongycastle/crypto/digests/SkeinDigest.java
	 * 
	 * @param input string
	 * @return Hash string
	 */
	public static String skein_256(final String input) {
		org.spongycastle.jcajce.provider.digest.Skein.Digest_256_256 digest256 = new org.spongycastle.jcajce.provider.digest.Skein.Digest_256_256();
		byte[] digest = digest256.digest(input.getBytes());
		return Hex.toHexString(digest);
	}

	/**
	 * Source code:
	 * https://github.com/rtyley/spongycastle/blob/spongy-master/core/src/main/java/org/spongycastle/crypto/digests/SkeinDigest.java
	 * 
	 * @param input string
	 * @return Hash string
	 */
	public static String skein_512(final String input) {
		org.spongycastle.jcajce.provider.digest.Skein.Digest_512_512 digest512 = new org.spongycastle.jcajce.provider.digest.Skein.Digest_512_512();
		byte[] digest = digest512.digest(input.getBytes());
		return Hex.toHexString(digest);
	}

	/**
	 * Source code:
	 * https://github.com/rtyley/spongycastle/blob/spongy-master/core/src/main/java/org/spongycastle/crypto/digests/SkeinDigest.java
	 * 
	 * @param input string
	 * @return Hash string
	 */
	public static String skein_1024(final String input) {
		org.spongycastle.jcajce.provider.digest.Skein.Digest_1024_1024 digest1024 = new org.spongycastle.jcajce.provider.digest.Skein.Digest_1024_1024();
		byte[] digest = digest1024.digest(input.getBytes());
		return Hex.toHexString(digest);
	}
}
