package cryptography.hashes.kupyna;

import org.spongycastle.jcajce.provider.digest.DSTU7564;
import org.spongycastle.util.encoders.Hex;

import java.security.Security;

public class Kupyna {


	public static void main(String[] args) {
	}

	// Provider
	static {
		Security.insertProviderAt(new org.spongycastle.jce.provider.BouncyCastleProvider(), 1);
	}

	public static String kupyna256(final String input) {
		DSTU7564.Digest256 digest256 = new DSTU7564.Digest256();
		byte[] digest = digest256.digest(input.getBytes());
		return Hex.toHexString(digest);
	}


	public static String kupyna384(final String input) {
		DSTU7564.Digest384 digest384 = new DSTU7564.Digest384();
		byte[] digest = digest384.digest(input.getBytes());
		return Hex.toHexString(digest);
	}


	public static String kupyna512(final String input) {
		DSTU7564.Digest512 digest512 = new DSTU7564.Digest512();
		byte[] digest = digest512.digest(input.getBytes());
		return Hex.toHexString(digest);
	}

}
