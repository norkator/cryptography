package cryptography.random.dummy;

import java.util.Random;

public class Dummy {

	public static void main(String[] args) {
	}

	/**
	 * Un-secure dummy byte generator
	 * should never be used with crypto
	 *
	 * @param count, how many bytes to return
	 * @return array of bytes
	 */
	public static byte[] dummyBytes(int count) {
		byte[] b = new byte[count];
		new Random().nextBytes(b);
		return b;
	}

}
