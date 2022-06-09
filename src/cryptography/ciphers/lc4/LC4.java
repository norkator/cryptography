package cryptography.ciphers.lc4;

import java.util.Random;

/**
 * Based on https://github.com/umcconnell/lc4/blob/master/src/lc4.js
 */
public class LC4 {

	public static String encrypt(String msg) {

		return null;
	}


	public static String decrypt(String msg) {

		return null;
	}


	/**
	 * Fisher–Yates shuffle
	 * https://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle
	 * https://www.dotnetperls.com/shuffle-java
	 *
	 * @param array of numbers to shuffle
	 */
	private static void shuffle(int[] array) {
		int n = array.length;
		Random random = new Random();
		for (int i = 0; i < array.length; i++) {
			int randomValue = i + random.nextInt(n - i);
			int randomElement = array[randomValue];
			array[randomValue] = array[i];
			array[i] = randomElement;
		}
	}

	private static void randomElement() {
	}

	private static void shiftRowRight() {
	}

	private static void shiftColumnDown() {
	}

	private static void position() {
	}

}
