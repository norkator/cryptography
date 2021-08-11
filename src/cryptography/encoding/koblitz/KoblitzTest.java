package cryptography.encoding.koblitz;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import cryptography.EC.ellipticCurve.EllipticCurve;

public class KoblitzTest {
	@Test
	public void runTest() {
		EllipticCurve E = new EllipticCurve();
		
		String[] encodedPoint = Koblitz.encode(Character.toString((char)11), 20, E);
		assertEquals("224", encodedPoint[0]);
		assertEquals("248", encodedPoint[1]);
		
		encodedPoint = Koblitz.encode("Hello World Trying out!!", 20, E);
		String decodedString = Koblitz.decode(encodedPoint, 20, E);
		assertEquals("Hello World Trying out!!",decodedString);
	}
}
