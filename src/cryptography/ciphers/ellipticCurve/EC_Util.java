package cryptography.ciphers.ellipticCurve;

import java.math.BigInteger;

@SuppressWarnings("ComparatorResultComparison")
public class EC_Util {

	public static BigInteger[] multiply_EC_PointByKey(BigInteger secretKey, BigInteger[] G, EllipticCurve E) {
		BigInteger[] newPoint = doublePoint(G, E);
		BigInteger index = new BigInteger("2");
		BigInteger slope, X, Y;
		while (index.compareTo(secretKey) == -1) {
			slope = (G[1].subtract(newPoint[1])).multiply(inverseMod((G[0].subtract(newPoint[0])), E.P.toBigInteger(), E)).mod(E.P.toBigInteger());        // slope = ((G(y) - newPoint(y)) / (G(x) - newPoint(x)))
			X = (slope.pow(2).subtract((G[0].add(newPoint[0]))).mod(E.P.toBigInteger()));                            // newPioint(x) = slope^2 - ( newPoint(x) + G(x) )
			Y = ((slope.multiply(G[0].subtract(X))).subtract(G[1])).mod(E.P.toBigInteger());                            // newPoint(y)  = slope * (G(x) - newPoint(x)) - G(y)
			newPoint[0] = X;
			newPoint[1] = Y;
			index = index.add(BigInteger.ONE);
		}

		return newPoint;
	}

	public static BigInteger[] doublePoint(BigInteger[] G, EllipticCurve E) {
		BigInteger numerator = G[0].pow(2).multiply(new BigInteger("3")).add(E.A.toBigInteger()).mod(E.P.toBigInteger());
		BigInteger denominator = G[1].multiply(new BigInteger("2"));
		BigInteger slope = (numerator).multiply(inverseMod(denominator, E.P.toBigInteger(), E)).mod(E.P.toBigInteger());        // slope = (3 * G(x)^2 + A) / (2 * G(y))
		BigInteger X = (slope.pow(2).subtract(G[0].multiply(new BigInteger("2")))).mod(E.P.toBigInteger());                    // X = slope^2 - 2 * G(x)
		BigInteger Y = (slope.multiply(G[0].subtract(X)).subtract(G[1])).mod(E.P.toBigInteger());                            // Y = slope * (G(x) - X) - G(y)

		return new BigInteger[]{X, Y};
	}

	public static BigInteger inverseMod(BigInteger e, BigInteger p, EllipticCurve E) {
		BigInteger d = BigInteger.ONE;
		while (d.compareTo(p) != 1) {
			if (e.multiply(d).remainder(p).compareTo(BigInteger.ONE) == 0) {
				break;
			}
			if (e.multiply(d.negate()).remainder(p).compareTo(BigInteger.ONE) == 0) {
				d = d.negate();
				break;
			}
			d = d.add(BigInteger.ONE);
		}
		return d;
	}

	public static BigInteger[] genSecretKey_DeffieHellman(BigInteger privateKeyA, BigInteger privateKeyB, BigInteger[] G, EllipticCurve E) {
		return multiply_EC_PointByKey(privateKeyA, multiply_EC_PointByKey(privateKeyB, G, E), E);
	}

}
