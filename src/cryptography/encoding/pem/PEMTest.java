/**
 * This class is part of running automated tests
 */
package cryptography.encoding.pem;

import cryptography.other.fileTools.PEMToKey;
import org.junit.Test;

import java.security.PrivateKey;

import static org.junit.Assert.assertEquals;

public class PEMTest {

	@Test
	public void runTest() throws Exception {

		String PEMContentsOriginal = "-----BEGIN EC PRIVATE KEY-----\n" +
			"MIGTAgEAMBMGByqGSM49AgEGCCqGSM49AwEHBHkwdwIBAQQgfLXrITJ2RIoAQhIs\n" +
			"v7TRRoSJK77n1aQHEhIfV3fS7pWgCgYIKoZIzj0DAQehRANCAAQ9Mg8BWfin/qGh\n" +
			"v23YwMThH9ta1pzac/HutSBTg2mO2iYE9OzHpSm0/ZgISsF4uxRCC61kNbr5chCU\n" +
			"U3UiPByE\n" +
			"-----END EC PRIVATE KEY-----";

		PrivateKey privateKey = PEMToKey.getPemPrivateKey(PEMContentsOriginal, "ECDSA");

		String PEMContents = PEM.ECPrivateKeyToPEMFormat(privateKey);

		assertEquals(PEMContentsOriginal, PEMContents);
	}

}
