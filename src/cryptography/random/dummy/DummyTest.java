/*
 * This class is part of running automated tests
 */
package cryptography.random.dummy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DummyTest {

	@Test
	public void runTest() {
		byte[] dummy = Dummy.dummyBytes(16);
		assertEquals(16, dummy.length);
	}

}
