/**
 * This class is part of running automated tests
 */
package cryptography.hashes.ripemd;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class RIPEMDTest {

	@Test
	public void runTest() {
		assertEquals("03399a40f1ec2330fffcfcf6986e7091", RIPEMD.ripemd128("testing"));
		assertEquals("b89ba156b40bed29a5965684b7d244c49a3a769b", RIPEMD.ripemd160("testing"));
		assertEquals("bb6ce43d9d2a06d4cedb28a5e674e033546f79eec9b7aa045cfde5e98ebaf7f8",
				RIPEMD.ripemd256("testing"));
		assertEquals("bbca34636981e96d41dffa9be4b345f75def4a2dd97f266219baa60da1ae58e106b3b72aab1d6ad5",
				RIPEMD.ripemd320("testing"));

	}

}
