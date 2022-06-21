package cryptography.ciphers.lc4;

import java.util.Arrays;
import java.util.Random;

/**
 * Based on https://github.com/umcconnell/lc4/blob/master/src/lc4.js
 */
public class LC4 {

	final static String ALPHABET = "#_23456789abcdefghijklmnopqrstuvwxyz";
	final static String ALPHABET_LS47 = "_abcdefghijklmnopqrstuvwxyz.0123456789,-+*/:?!'()";
	final static int GRID_SIZE = 6;
	final static int GRID_SIZE_LS47 = 7;


	public static int[][] initState(LC4Mode mode, String key) {
		String alphabet = mode.equals(LC4Mode.ALPHABET_LS47) ? ALPHABET_LS47 : ALPHABET;
		int size = mode.equals(LC4Mode.ALPHABET_LS47) ? GRID_SIZE_LS47 : GRID_SIZE;
		char[] characters = key.length() == size * size ? key.toCharArray() : alphabet.toCharArray();

		int[][] S = new int[size][size];

//		Array.fill was initializing with references, exact value needs to be store as elements
		for(int a=0;a<size;a++) {
			for(int b=0;b<size;b++) {
				S[a][b] = 0;
			}
		}

		for (int k = 0; k < alphabet.length(); k++) {
			int t = (int) Math.floor(k / size);
			S[t][k % size] = alphabet.indexOf(characters[k]);
		}
		
		
		if (key.length() != size * size) {
			int i = 0;
			for(char ch:key.toCharArray()) {
	            int Px = alphabet.indexOf(ch) % size;
	            int Py = (int) Math.floor(alphabet.indexOf(ch)/size);
	            
	            for (int shiftedRight = 0; shiftedRight < Px; shiftedRight++) {
					shiftRowRight(mode, i % size, 0, 0, S);
				}

				for (int shiftedDown = 0; shiftedDown < Py; shiftedDown++) {
					shiftColumnDown(mode, i % size, 0, 0, S);
				}
				i++;
			}
		}

		for(int a=0;a<S.length;a++) {
			for(int b=0;b<S[a].length;b++) {
				System.out.print(S[a][b]+",");
			}
			System.out.println();
		}

		return S;
	}


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


	/**
	 * @param mode    algorithm selection
	 * @param row     index of row to shift
	 * @param markerI row of the marker in the state
	 * @param markerJ column of the marker in the state
	 * @param state   matrix
	 * @return updated state matrix
	 */
	public static int[][] shiftRowRight(LC4Mode mode, int row, int markerI, int markerJ, int[][] state) {
		int size = mode.equals(LC4Mode.ALPHABET_LS47) ? GRID_SIZE_LS47 : GRID_SIZE;

		int[] ordered = new int[state[row].length];
		ordered[0] = state[row][state[row].length - 1];
		//noinspection ManualArrayCopy
		for (int j = 1; j < state[row].length; j++) {
			ordered[j] = state[row][j - 1];
		}
		state[row] = ordered;

		if (markerI == row) markerJ = (markerJ + 1) % size;

		return state;
	}


	public static int[][] shiftColumnDown(LC4Mode mode, int col, int markerI, int markerJ, int[][] state) {
		int size = mode.equals(LC4Mode.ALPHABET_LS47) ? GRID_SIZE_LS47 : GRID_SIZE;
		// int shiftRow = size - 1;
		// int last = state[state.length][0];

		int[] shifted = new int[state.length];

		shifted[0] = state[state.length - 1][col];
		for (int j = 1; j < state.length; j++) {
			shifted[j] = state[j - 1][col];
		}
		for (int i = 0; i < state.length; i++) {
			state[i][col] = shifted[i];
			// System.out.println(state[i][0] + ", ");
		}

		if (markerJ == col) markerI = (markerI + 1) % size;

		return state;
	}


	/**
	 * Return the coordinates of given search element in the state matrix
	 *
	 * @param character search element
	 * @param state     matrix [ 1, 17, 23, 30, 12, 25 ], [ 19, 31, 20, 22, 28, 29 ], ...
	 * @return position vector in the form [`row`, `column`]
	 */
	private static int[] position(int character, int[][] state) {
		// int[] vector = {0, 0};
		// for (int row = 0; row < state.length; row++) {
		// 	int column = state[row].indexOf(character);

		// 	if (column > -1) {
		// 		vector[0] = row;
		// 		vector[1] = column;
		// 		break;
		// 	}
		// }
		// return vector;

		return null;
	}

}
