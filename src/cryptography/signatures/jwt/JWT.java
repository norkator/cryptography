package cryptography.signatures.jwt;

import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import cryptography.other.fileTools.PEMToKey;

import java.security.NoSuchAlgorithmException;
import java.security.interfaces.ECKey;
import java.security.spec.InvalidKeySpecException;


public class JWT {


	/**
	 * Create elliptic curve based JWT
	 *
	 * @param privatePem of EC keypair
	 * @param issuer     party name
	 * @return json web token
	 * @throws JWTCreationException if jwt creation fails
	 */
	public static String createECDSA256Jwt(String privatePem, String issuer) throws InvalidKeySpecException, NoSuchAlgorithmException {
		ECKey privateKey = (ECKey) PEMToKey.getPemPrivateKey(privatePem, "ECDSA");
		Algorithm algorithm = Algorithm.ECDSA256(privateKey);
		return com.auth0.jwt.JWT.create()
			.withIssuer(issuer)
			.withClaim("test claim", "test claim value")
			// .withNotBefore()
			// .withExpiresAt()
			.sign(algorithm);
	}


	/**
	 * Verify elliptic curve based JWT
	 *
	 * @param publicPem of key pair
	 * @param issuer    party name
	 * @param token     of created jwt
	 * @return DecodedJWT including claims
	 * @throws JWTVerificationException thrown if verification fails
	 */
	public static DecodedJWT verifyECDSA256Jwt(String publicPem, String issuer, final String token) throws JWTVerificationException, InvalidKeySpecException, NoSuchAlgorithmException {
		ECKey publicKey = (ECKey) PEMToKey.getPemPublicKey(publicPem, "ECDSA");
		Algorithm algorithm = Algorithm.ECDSA256(publicKey);
		JWTVerifier verifier = com.auth0.jwt.JWT.require(algorithm)
			.withIssuer(issuer)
			.build();
		return verifier.verify(token);
	}


	/**
	 * Verify elliptic curve based JWT
	 * # this is meant for test case
	 *
	 * @param publicPem of key pair
	 * @param issuer    party name
	 * @param token     of created jwt
	 * @return boolean result
	 */
	public static boolean isVerifiedECDSA256Jwt(String publicPem, String issuer, final String token) throws InvalidKeySpecException, NoSuchAlgorithmException {
		try {
			ECKey publicKey = (ECKey) PEMToKey.getPemPublicKey(publicPem, "ECDSA");
			Algorithm algorithm = Algorithm.ECDSA256(publicKey);
			JWTVerifier verifier = com.auth0.jwt.JWT.require(algorithm)
				.withIssuer(issuer)
				.build();
			verifier.verify(token);
			return true;
		} catch (JWTVerificationException e) {
			return false;
		}
	}

}
