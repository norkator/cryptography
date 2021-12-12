package cryptography.signatures.jwt;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import cryptography.ciphers.ec.EC;
import cryptography.encoding.pem.PEM;

import java.security.KeyPair;
import java.security.Security;

public class JWTTesting {


	public static void main(String[] args) throws Exception {
		Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());

		String issuer = "nitramite";


		KeyPair keypair = EC.generateECDSAPrime256V1KeyPair();

		String privatePem = PEM.ECPrivateKeyToPEMFormat(keypair.getPrivate());

		String jwt = JWT.createECDSA256Jwt(privatePem, issuer);
		System.out.println(jwt);

		String publicPem = PEM.PublicKeyToPEMFormat(keypair.getPublic());

		try {
			DecodedJWT decodedJWT = JWT.verifyECDSA256Jwt(publicPem, issuer, jwt);
			System.out.println("Valid jwt");
			System.out.println("Issuer: " + decodedJWT.getIssuer());
		} catch (JWTVerificationException e) {
			System.out.println("Invalid jwt");
		}
	}

}
