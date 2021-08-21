/*BASED ON PAPER: https://informatika.stei.itb.ac.id/~rinaldi.munir/Kriptografi/2014-2015/IJCSE10-02-05-08.pdf*/
package cryptography.encoding.koblitz;

import java.math.BigDecimal;

import cryptography.ciphers.ellipticCurve.EllipticCurve;

import java.math.RoundingMode;

public class Koblitz {

	public static String[] encode(String input, int k, EllipticCurve E) {
		BigDecimal m = stringEncoding(input, E);                                // m = sum( input[a] * b^a );

		BigDecimal x = BigDecimal.ZERO;
		BigDecimal y2 = BigDecimal.ZERO;
		BigDecimal y = BigDecimal.ZERO;
		BigDecimal s = BigDecimal.ZERO;

		for (int a = 1; a < k; a++) {
			x = m.multiply(new BigDecimal(k)).add(new BigDecimal("4"));        // x = m * k + a;
			s = x.pow(3).add(E.A.multiply(x)).add(E.B).remainder(E.P);        // s = (x^3 + A * x + B) % P;

			//noinspection ComparatorResultComparison
			while (y.compareTo(E.P) == -1) {
				y2 = y.pow(2).remainder(E.P);                                //y2 = y^2 % P
				if (y2.equals(s)) {
					break;
				}
				y = y.add(BigDecimal.ONE);
			}
		}
		return new String[]{x.toString(), y.toString()};
	}

	public static String decode(String[] point, int k, EllipticCurve E) {
		BigDecimal x = new BigDecimal(point[0]);
		BigDecimal m = x.divide(new BigDecimal(Integer.toString(k)), 0, RoundingMode.FLOOR);
		StringBuilder output = new StringBuilder();
		while (!m.equals(BigDecimal.ZERO)) {
			output.append((char) m.remainder(E.b).intValueExact());
			m = m.divide(E.b, RoundingMode.FLOOR);
		}

		return output.toString();
	}


	public static String decode(String point, int k, EllipticCurve E) {
		BigDecimal x = new BigDecimal(point);
		BigDecimal m = x.divide(new BigDecimal(Integer.toString(k)), 0, RoundingMode.FLOOR);
		StringBuilder output = new StringBuilder();
		while (!m.equals(BigDecimal.ZERO)) {
			output.append((char) (m.remainder(E.b).intValueExact()));
			m = m.divide(E.b, RoundingMode.FLOOR);
		}

		return output.toString();
	}

	public static BigDecimal stringEncoding(String str, EllipticCurve E) {
		BigDecimal mappedStringValue = BigDecimal.ZERO;
		for (int a = 0; a < str.length(); a++) {
			int ascii = str.charAt(a);
			String stringedInteger = Integer.toString(ascii);
			mappedStringValue = mappedStringValue.add(E.BIT_MAX_VALUE_128.pow(a).multiply(new BigDecimal(stringedInteger)));
		}

		return mappedStringValue;
	}

}
