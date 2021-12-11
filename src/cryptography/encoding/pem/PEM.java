package cryptography.encoding.pem;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.Base64;

public class PEM {

	static String LINE_SEPARATOR = System.getProperty("line.separator");
	private static Base64.Encoder encoder = Base64.getMimeEncoder(64, LINE_SEPARATOR.getBytes());


	/**
	 * @param privateKey of EC keypair
	 * @return elliptic curve primary key in PEM format
	 */
	public static String ECPrivateKeyToPEMFormat(PrivateKey privateKey) {
		return "-----BEGIN EC PRIVATE KEY-----\n" +
			new String(encoder.encode(privateKey.getEncoded())) +
			"\n-----END EC PRIVATE KEY-----";
	}

	/**
	 * @param publicKey of keypair
	 * @return public key in PEM format
	 */
	public static String PublicKeyToPEMFormat(PublicKey publicKey) {
		return "-----BEGIN PUBLIC KEY-----\n" +
			new String(encoder.encode(publicKey.getEncoded())) +
			"\n-----END PUBLIC KEY-----";
	}

	/**
	 * @param certificate created from key pair
	 * @return certificate in PEM format
	 */
	public static String X509CertificateToPEMFormat(X509Certificate certificate) throws CertificateEncodingException {
		return "-----BEGIN CERTIFICATE-----\n" +
			new String(encoder.encode(certificate.getEncoded())) +
			"\n-----END CERTIFICATE----";
	}


}
