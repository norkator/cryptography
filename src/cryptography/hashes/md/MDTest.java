/**
 * This class is part of running automated tests
 */
package cryptography.hashes.md;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MDTest {

	@Test
	public void runTest() {
		assertEquals("fc134df10d6ecafceb5c75861d01b41f", MD.md2("testing"));
		assertEquals("0c2be0003f0debdcf644525bdaf6e45d", MD.md4("testing"));
		assertEquals("ae2b1fca515949e5d54fb22b8ed95575", MD.md5("testing"));
	}

}
