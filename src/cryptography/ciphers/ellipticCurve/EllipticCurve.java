package cryptography.ciphers.ellipticCurve;

import java.math.BigDecimal;
import java.math.BigInteger;

import cryptography.encoding.koblitz.Koblitz;

@SuppressWarnings("ComparatorResultComparison")
public class EllipticCurve {
	final public BigDecimal BIT_MAX_VALUE_128 = new BigDecimal("128");
	final public BigDecimal BIT_MAX_VALUE_256 = new BigDecimal("256");

	public BigDecimal P;        //bigger than all # points on Curve
	public BigDecimal A;
	public BigDecimal B;
	public BigDecimal b;

//	public EllipticCurve(){
//		this.A = new BigDecimal("-1");
//		this.B = new BigDecimal("188");
//		this.P = new BigDecimal("751");
//		this.b = BIT_MAX_VALUE_128 ;
//	}

	public EllipticCurve(String A, String B, String P) {
		this.A = new BigDecimal(A);
		this.B = new BigDecimal(B);
		this.P = new BigDecimal(P);
		this.b = BIT_MAX_VALUE_128;
	}

	public EllipticCurve(BigDecimal A, BigDecimal B, BigDecimal P) {
		this.A = A;
		this.B = B;
		this.P = P;
		this.b = BIT_MAX_VALUE_128;
	}

	String getEqn() {
		return "y^2 mod " + this.P + " = ( x^3 + (" + this.A + ")x + (" + this.B + ") ) mod " + this.P;
	}

	/* input: String => input text message
	 * G: BigInteger[2] => a random point on the curve (x,y)
	 * secretKey: BigInteger => SecretKey decided by both party, must be same (just X coordinate)
	 * publicKeyReceiver: BigInteger => public key of receiver (just X coordinate)
	 * multiplier: int => order of the curve at G (Can be random but must be same for encryption and decryption)
	 * */
	public String[] encrypt(String input, BigInteger[] G, BigInteger secretKey, BigInteger publicKeyReceiver, int multiplier) {
		String encodedPointX = Koblitz.encode(input, multiplier, this)[0];
		BigInteger cipherX = EC_Util.multiply_EC_PointByKey(secretKey, G, this)[0];
		BigInteger cipherY = (new BigInteger(encodedPointX)).add(secretKey.multiply(publicKeyReceiver));
		return new String[]{cipherX.toString(), cipherY.toString()};
	}

	/* input: String => cipher text message
	 * privateKeyReceiver: BigInteger => private key of receiver
	 * multiplier: int => order of the curve at G (Can be random but must be same for encryption and decryption)
	 * */
	public String decrypt(String[] input, BigInteger privateKeyReceiver, int multiplier) {
		BigInteger pointToDecode = (new BigInteger(input[1])).subtract((new BigInteger(input[0])).multiply(privateKeyReceiver));
		return Koblitz.decode((pointToDecode.add(BigInteger.valueOf(multiplier / 2))).toString(), multiplier, this);
	}

	public BigInteger[] calcG() {
		boolean pairFound = false;
		BigInteger X = this.P.toBigInteger().negate().add(BigInteger.ONE);
		BigInteger Y = this.P.toBigInteger().negate();
		while (X.compareTo(this.P.toBigInteger()) == -1) {
			BigInteger RHS = ((X.pow(3)).add(X.multiply(this.A.toBigInteger())).add(this.B.toBigInteger())).mod(this.P.toBigInteger());
			Y = BigInteger.ZERO;
			while (Y.compareTo(this.P.toBigInteger()) == -1) {
				BigInteger LHS = (Y.pow(2)).mod(this.P.toBigInteger());
				if (LHS.compareTo(RHS) == 0) {
					pairFound = true;
					break;
				}
				LHS = ((Y.negate()).pow(2)).mod(this.P.toBigInteger());
				if (LHS.compareTo(RHS) == 0) {
					Y = Y.negate();
					pairFound = true;
					break;
				}
				Y = Y.add(BigInteger.ONE);
			}
			if (pairFound) {
				break;
			}
			X = X.add(BigInteger.ONE);
		}
		return new BigInteger[]{X, Y};
	}
}
