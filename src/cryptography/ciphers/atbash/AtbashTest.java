package cryptography.ciphers.atbash;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import cryptography.Mode;

public class AtbashTest {

	@Test
	public void runTest() {
		assertEquals("svooldliow", Atbash.atbash("helloworld", Mode.ENCRYPT));
		assertEquals("helloworld", Atbash.atbash("svooldliow", Mode.DECRYPT));
	}

}
