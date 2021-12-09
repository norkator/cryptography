package cryptography.encoding.pem;

import javax.xml.bind.DatatypeConverter;
import java.security.PrivateKey;
import java.security.PublicKey;

public class PEM {


	/**
	 * @param privateKey of EC keypair
	 * @return elliptic curve primary key in PEM format
	 */
	public static String ECPrivateKeyToPEMFormat(PrivateKey privateKey) {
		return "-----BEGIN EC PRIVATE KEY-----\n" +
			// Todo... add PEM file specific line char length
			DatatypeConverter.printBase64Binary(privateKey.getEncoded()) +
			"-----END EC PRIVATE KEY-----";
	}

	/**
	 * @param publicKey of keypair
	 * @return public key in PEM format
	 */
	public static String PublicKeyToPEMFormat(PublicKey publicKey) {
		return "-----BEGIN PUBLIC KEY-----\n" +
			// Todo... add PEM file specific line char length
			DatatypeConverter.printBase64Binary(publicKey.getEncoded()) +
			"-----END PUBLIC KEY-----";
	}

	/**
	 * @param certificate created from key pair
	 * @return public key in PEM format
	 */
	// public static String PublicKeyToPEMFormat(String certificate) {
	// 	return "-----BEGIN CERTIFICATE-----\n" +
	// 		// Todo... add PEM file specific line char length
	// 		DatatypeConverter.printBase64Binary(certificate.getEncoded()) +
	// 		"-----END CERTIFICATE----";
	// }


}
