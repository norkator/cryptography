/**
 * This class is part of running automated tests
 */
package cryptography.hashes.sm3;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SM3Test {

	@Test
	public void runTest() {
		assertEquals("4e14b71330132c92655bef624a43e1294f9159373f5a7407956b05bf95405dcf", SM3.sm3Hash("testing"));
	}

}
