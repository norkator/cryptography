/*
 * This class is part of running automated tests
 */
package cryptography.ciphers.ellipticCurve;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

public class EllipticCurveTest {

	@Test
	public void runTest() {

		//Create Elliptic Eqn
		Random rand = new Random();
		BigInteger A = new BigInteger(3, rand);
		BigInteger B = new BigInteger(3, rand);
		BigInteger P = (new BigInteger(3, rand)).add(BigInteger.ONE);
		EllipticCurve E = new EllipticCurve(new BigDecimal(A), new BigDecimal(B), new BigDecimal(P));
		// EllipticCurve E = new EllipticCurve();

		//Generate Secret Key
		BigInteger privateKeyA = new BigInteger(3, rand);
		BigInteger privateKeyB = new BigInteger(3, rand);
		BigInteger[] G = E.calcG();
		BigInteger[] secretKey = EC_Util.genSecretKey_DeffieHellman(privateKeyA, privateKeyB, G, E);
		BigInteger[] publicKeyA = EC_Util.multiply_EC_PointByKey(privateKeyA, G, E);
		BigInteger[] publicKeyB = EC_Util.multiply_EC_PointByKey(privateKeyB, G, E);

		//encryption
		String[] ciphered = E.encrypt("Test input string", G, secretKey[0], publicKeyB[0], 2000);
		String deciphered = E.decrypt(ciphered, privateKeyB, 2000);

		//tests
		Assert.assertEquals("Test input string", deciphered);
//		Assert.assertEquals("y^2 mod "+P+" = ( x^3 + ("+A+")x + ("+B+") ) mod "+P, E.getEqn());
	}
}
