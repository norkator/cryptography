package cryptography.ciphers.lc4;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LC4Test {

	@Test
	public void EscapeStringTest() {
		String escaped = LC4.escapeString("Test input");
		assertEquals("test_input", escaped);
	}

	@Test
	public void ShiftRightTest() {
		int[][] rightShifted = LC4.shiftRowRight(LC4Mode.ALPHABET, 0, 0, 0, new int[][]{
			{17, 23, 30, 12, 25, 16},
			{10, 31, 20, 22, 28, 29},
			{14, 15, 26, 27, 34, 6},
			{11, 32, 21, 33, 5, 0},
			{1, 13, 3, 4, 8, 9},
			{19, 18, 7, 24, 35, 2}
		});
		assertEquals(16, rightShifted[0][0]);
	}

	@Test
	public void ShiftDownTest() {
		int[][] downShifted = LC4.shiftColumnDown(LC4Mode.ALPHABET, 0, 0, 0, new int[][]{
			{19, 17, 23, 30, 12, 25},
			{16, 31, 20, 22, 28, 29},
			{10, 15, 26, 27, 34, 6},
			{14, 32, 21, 33, 5, 0},
			{11, 13, 3, 4, 8, 9},
			{1, 18, 7, 24, 35, 2},

		});
		assertEquals(1, downShifted[0][0]);
	}

	@Test
	public void InitStateTest() {
		int[][] initState = LC4.initState(LC4Mode.ALPHABET, "testing");
		assertEquals(1, initState[0][0]);
	}

	@Test
	public void Position() {
		int[][] state = new int[][]{
			{17, 23, 30, 12, 25, 16},
			{10, 31, 20, 22, 28, 29},
			{14, 15, 26, 27, 34, 6},
			{11, 32, 21, 33, 5, 0},
			{1, 13, 3, 4, 8, 9},
			{19, 18, 7, 24, 35, 2}
		};
		int[] vector = LC4.position(32, state);
		assertEquals(3, vector[0]);
		assertEquals(1, vector[1]);
	}

	@Test
	public void EncryptMessage() {
		int[][] state = LC4.initState(LC4Mode.ALPHABET, "testing");
		String encrypted = LC4.encrypt(LC4Mode.ALPHABET, state, 0, 0, "test input");
		assertEquals("ju9__#j_m9", encrypted);
	}

	@Test
	public void DecryptMessage() {
		int[][] state = LC4.initState(LC4Mode.ALPHABET, "testing");
		String encrypted = LC4.decrypt(LC4Mode.ALPHABET, state, 0, 0, "ju9__#j_m9");
		assertEquals("test_input", encrypted);
	}

	// @Test
	// public void EncryptLS47Message() {
	// 	int[][] state = LC4.initState(LC4Mode.ALPHABET_LS47, "testing");
	// 	String encrypted = LC4.encrypt(LC4Mode.ALPHABET_LS47, state, 0, 0, "test input");
	// 	assertEquals("e9egl2*5z0", encrypted);
	// }

}
