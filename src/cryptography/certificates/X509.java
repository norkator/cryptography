package cryptography.certificates;

import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.X509v3CertificateBuilder;
import org.bouncycastle.cert.jcajce.JcaX509CertificateConverter;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;

import java.math.BigInteger;
import java.security.KeyPair;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;

public class X509 {

	/**
	 * Get X509 certificate for created key pair
	 * Trying to be equivalent to:
	 * openssl req -x509 -new -key ec_private.pem -out ec_cert.pem -subj "/CN=commonName"
	 *
	 * @param keyPair            consisting pubic and private keys
	 * @param signatureAlgorithm like 'SHA256withECDSA'
	 * @param commonName         like domain
	 * @param validityDays       how long certificate is valid
	 * @return X509Certificate
	 * @throws CertificateException
	 * @throws OperatorCreationException
	 */
	public static X509Certificate createCertificate(
		final KeyPair keyPair, final String signatureAlgorithm, final String commonName, final int validityDays
	) throws CertificateException, OperatorCreationException {
		BigInteger serial = new BigInteger(64, new SecureRandom());
		X500Name x500Name = new X500Name("CN=" + commonName);
		final Instant now = Instant.now();
		final Date from = Date.from(now);
		final Date to = Date.from(now.plus(Duration.ofDays(validityDays)));

		SubjectPublicKeyInfo publicKeyInfo = SubjectPublicKeyInfo.getInstance(keyPair.getPublic().getEncoded());
		X509v3CertificateBuilder certificateBuilder = new X509v3CertificateBuilder(
			x500Name, serial, from, to, x500Name, publicKeyInfo
		);

		ContentSigner contentSigner = new JcaContentSignerBuilder(signatureAlgorithm)
			.setProvider(new BouncyCastleProvider()).build(keyPair.getPrivate());

		X509CertificateHolder x509CertificateHolder = certificateBuilder.build(contentSigner);

		return new JcaX509CertificateConverter()
			.setProvider(new BouncyCastleProvider())
			.getCertificate(x509CertificateHolder);
	}

}
