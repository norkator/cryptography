package cryptography.ciphers.ec;

import java.security.*;

public class ECTesting {


	public static void main(String[] args) throws InvalidAlgorithmParameterException, NoSuchAlgorithmException, NoSuchProviderException {
		Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());


		KeyPair keypair = EC.generateECDSAPrime256V1KeyPair();
		System.out.println(keypair.getPrivate());
		System.out.println(keypair.getPublic());

	}

}
