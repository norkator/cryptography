package cryptography.signatures.jwt;

import cryptography.ciphers.ec.EC;
import cryptography.encoding.pem.PEM;

import java.security.KeyPair;
import java.security.Security;

public class JWTTesting {


	public static void main(String[] args) throws Exception {
		Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());

		KeyPair keypair = EC.generateECDSAPrime256V1KeyPair();


		String privatePem = PEM.ECPrivateKeyToPEMFormat(keypair.getPrivate());


		String jwt = JWT.createECDSA256Jwt(privatePem, "nitramite");
		System.out.println(jwt);
	}

}
