/**
 * This class is part of running automated tests
 */
package cryptography.ciphers.ec;

import org.junit.Test;

import java.security.*;

import static org.junit.Assert.assertNotNull;

public class ECTest {

	@Test
	public void runTest() throws InvalidAlgorithmParameterException, NoSuchAlgorithmException, NoSuchProviderException {
		Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());

		KeyPair keypair = EC.generateECDSAPrime256V1KeyPair();

		assertNotNull(keypair.getPrivate());
		assertNotNull(keypair.getPublic());
	}

}
