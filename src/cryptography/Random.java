/*
 * This class will stack random methods and just try them all
 */
package cryptography;

import cryptography.random.dummy.Dummy;
import cryptography.random.secureRandom.SecureRandom;

import java.util.Arrays;

public class Random {

	public static void main(String[] args) {
		try {

			System.out.println("Dummy bytes: " + Arrays.toString(Dummy.dummyBytes(16)));
			System.out.println("Secure random SHA1PRNG bytes: " + Arrays.toString(SecureRandom.secureRandomBytes(16, SecureRandom.INSTANCE_ALGORITHM_SHA1PRNG)));
			System.out.println("Secure random strong bytes: " + Arrays.toString(SecureRandom.secureRandomStrongBytes(16)));

		} catch (Exception e) {
			System.out.print(e.toString());
		}
	}

}
