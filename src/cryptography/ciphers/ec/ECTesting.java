package cryptography.ciphers.ec;

import cryptography.certificates.X509;
import cryptography.encoding.pem.PEM;
import org.bouncycastle.operator.OperatorCreationException;

import java.security.*;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

public class ECTesting {


	public static void main(String[] args) throws InvalidAlgorithmParameterException, NoSuchAlgorithmException,
		NoSuchProviderException, CertificateException, OperatorCreationException {
		Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());

		KeyPair keypair = EC.generateECDSAPrime256V1KeyPair();

		System.out.println(PEM.ECPrivateKeyToPEMFormat(keypair.getPrivate()));
		System.out.println(PEM.PublicKeyToPEMFormat(keypair.getPublic()));

		X509Certificate certificate = X509.createCertificate(
			keypair, "SHA256withECDSA", "com.nitramite.cryptography", 365
		);

		System.out.println(PEM.X509CertificateToPEMFormat(certificate));
	}

}
