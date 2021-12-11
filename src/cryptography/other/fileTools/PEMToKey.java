package cryptography.other.fileTools;

import org.spongycastle.jce.provider.BouncyCastleProvider;
import sun.misc.BASE64Decoder;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;

public class PEMToKey {

	public static PrivateKey getPemPrivateKey(String pemContents, String algorithm) throws Exception {
		String privateKeyPEM = pemContents.replace("-----BEGIN PRIVATE KEY-----", "");
		privateKeyPEM = privateKeyPEM.replace("-----END PRIVATE KEY-----", "");
		privateKeyPEM = privateKeyPEM.replace("-----BEGIN EC PRIVATE KEY-----", "");
		privateKeyPEM = privateKeyPEM.replace("-----END EC PRIVATE KEY-----", "");

		BASE64Decoder b64 = new BASE64Decoder();
		byte[] decoded = b64.decodeBuffer(privateKeyPEM);

		PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(decoded);
		KeyFactory kf = KeyFactory.getInstance(algorithm, new BouncyCastleProvider());
		return kf.generatePrivate(spec);
	}

}
