package cryptography.ciphers.aes;

import java.security.Security;

public final class AES {

	public static void main(String[] args) {
	}

	// Provider
	static {
		Security.insertProviderAt(new org.spongycastle.jce.provider.BouncyCastleProvider(), 1);
	}

	

}
