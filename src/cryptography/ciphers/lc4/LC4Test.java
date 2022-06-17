package cryptography.ciphers.lc4;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LC4Test {

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

}
