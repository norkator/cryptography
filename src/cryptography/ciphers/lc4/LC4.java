package cryptography.ciphers.lc4;

import java.util.Random;

/**
 * Based on https://github.com/umcconnell/lc4/blob/master/src/lc4.js
 */
public class LC4 {

	final static String ALPHABET = "#_23456789abcdefghijklmnopqrstuvwxyz";
	final static String ALPHABET_LS47 = "_abcdefghijklmnopqrstuvwxyz.0123456789,-+*/:?!'()";
	final static int GRID_SIZE = 6;
	final static int GRID_SIZE_LS47 = 7;


	public static String encrypt(LC4Mode mode, String msg) {
		String alphabet = mode.equals(LC4Mode.ALPHABET_LS47) ? ALPHABET_LS47 : ALPHABET;
		int size = mode.equals(LC4Mode.ALPHABET_LS47) ? GRID_SIZE_LS47 : GRID_SIZE;

		char[] msgA = msg.toCharArray();
		for (int i = 0; i < msgA.length; i++) {
			char msgC = msgA[i];
			int code = alphabet.indexOf(msgC);

			//        let [row, col] = position(code, state);
		}

		return null;
	}


	public static String decrypt(LC4Mode mode, String msg) {

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

	/**
	 * Return the coordinates of given search element in the state matrix
	 * @param c search element
	 * @param state matrix
	 * @return position vector in the form [`row`, `column`]
	 */
	private static int[] position(char c, String[] state) {
		int[] vector = {0, 0};
		for (int row = 0; row < state.length; row++) {
			int column = state[row].indexOf(c);

			if (column > -1) {
				vector[0] = row;
				vector[1] = column;
				break;
			}
		}
		return vector;
	}

}
