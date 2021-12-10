package cryptography.ciphers.ec;


import org.bouncycastle.jce.ECNamedCurveTable;
import org.bouncycastle.jce.spec.ECParameterSpec;

import java.security.*;

/**
 * Elliptic curve using Bouncy Castle provider
 */
public class EC {

	// Provider
	static {
		Security.insertProviderAt(new org.spongycastle.jce.provider.BouncyCastleProvider(), 1);
	}

	/**
	 * Generates prime256v1 curve ECDSA key pair
	 * openssl ecparam -genkey -name prime256v1 -noout -out ec_private.pem
	 *
	 * @return key pair
	 */
	public static KeyPair generateECDSAPrime256V1KeyPair() throws NoSuchProviderException, NoSuchAlgorithmException, InvalidAlgorithmParameterException {
		ECParameterSpec ecSpec = ECNamedCurveTable.getParameterSpec("prime256v1");
		KeyPairGenerator generator = KeyPairGenerator.getInstance("ECDSA", "BC");
		generator.initialize(ecSpec, new SecureRandom());
		return generator.generateKeyPair();
	}

}
