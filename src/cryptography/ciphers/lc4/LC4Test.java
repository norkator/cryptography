package cryptography.ciphers.lc4;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LC4Test {

	@Test
	public void runTest() {
		// assertEquals("...", LC4.encrypt("testing"));
		// assertEquals("testing", LC4.decrypt("..."));

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

}
