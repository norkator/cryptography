/**
 * This class is part of running automated tests
 */
package cryptography.signatures.jwt;

import com.auth0.jwt.interfaces.DecodedJWT;
import cryptography.ciphers.ec.EC;
import cryptography.encoding.pem.PEM;
import org.junit.Test;

import java.security.*;
import java.security.spec.InvalidKeySpecException;

import static org.junit.Assert.*;

public class JWTTest {

	private static final String ISSUER = "nitramite";

	private static final String INVALID_JWT = "eyJhbGciOiJFUzI1NiJ9.eyJpc3MiOiJuaXRyYW1pdGUiLCJ0ZXN0IGNsYWltIjoidGVzdCBjbGFpbSB2YWx1ZSJ9.MEQCIC0KuyfDV2u_FJuKiIBrcOPb5uwjT_7jADokfokpofkpsodsdrVXi9qCJdF2_ntbdauHCkKh4W0xtIXLtYFbDGCRg";

	@Test
	public void jwtTest() throws InvalidAlgorithmParameterException, NoSuchAlgorithmException, NoSuchProviderException, InvalidKeySpecException {
		Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
		KeyPair keypair = EC.generateECDSAPrime256V1KeyPair();

		String privatePem = PEM.ECPrivateKeyToPEMFormat(keypair.getPrivate());
		String publicPem = PEM.PublicKeyToPEMFormat(keypair.getPublic());

		String jwt = JWT.createECDSA256Jwt(privatePem, ISSUER);


		// jwt valid
		assertTrue(JWT.isVerifiedECDSA256Jwt(publicPem, ISSUER, jwt));

		// jwt content expected
		DecodedJWT decodedJwt = JWT.verifyECDSA256Jwt(publicPem, ISSUER, jwt);
		assertEquals(ISSUER, decodedJwt.getIssuer());

		// jwt is not valid
		assertFalse(JWT.isVerifiedECDSA256Jwt(publicPem, ISSUER, INVALID_JWT));
	}

}
