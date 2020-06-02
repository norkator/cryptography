package cryptography.ciphers.porta;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class PortaTest {

	@Test
	public void runTest() {
		assertEquals("GMIKWTBWVAUN", Porta.porta("PORTAEXAMPLE", "TEST"));
		// assertEquals("PORTAEXAMPLE", Porta.porta("GMIKWTBWVAUN", "TEST"));
		
		
		// Purposely wrong to test Jenkins
		assertEquals("PORTAEXAMPLE NOT WORKING TEST", Porta.porta("GMIKWTBWVAUN", "TEST"));
	}

}
