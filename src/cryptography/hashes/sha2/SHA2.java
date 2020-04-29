package cryptography.hashes.sha2;

import java.security.Security;
import org.spongycastle.jcajce.provider.digest.SHA224;
import org.spongycastle.util.encoders.Hex;

public class SHA2 {

	// Provider
	static {
		Security.insertProviderAt(new org.spongycastle.jce.provider.BouncyCastleProvider(), 1);
	}

	public static void main(String[] args) {
	}

	public static String sha2_224(final String input) {
		SHA224.Digest sha224 = new SHA224.Digest();
		byte[] digest = sha224.digest(input.getBytes());
		return Hex.toHexString(digest);
	}

}
