package cryptography.other.fileTools;

import org.spongycastle.jce.provider.BouncyCastleProvider;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

public class PEMToKey {

	private static Base64.Decoder decoder = Base64.getMimeDecoder();

	public static PrivateKey getPemPrivateKey(String pemContents, String algorithm) throws Exception {
		String privateKeyPEM = pemContents.replace("-----BEGIN PRIVATE KEY-----", "");
		privateKeyPEM = privateKeyPEM.replace("-----END PRIVATE KEY-----", "");
		privateKeyPEM = privateKeyPEM.replace("-----BEGIN EC PRIVATE KEY-----", "");
		privateKeyPEM = privateKeyPEM.replace("-----END EC PRIVATE KEY-----", "");

		byte[] decoded = decoder.decode(privateKeyPEM);

		PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(decoded);
		KeyFactory kf = KeyFactory.getInstance(algorithm, new BouncyCastleProvider());
		return kf.generatePrivate(spec);
	}

}
