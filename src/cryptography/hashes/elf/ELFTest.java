/**
 * This class is part of running automated tests
 */
package cryptography.hashes.elf;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ELFTest {

	@Test
	public void runTest() {
		assertEquals("181055543", ELF.elf32("testing"));
	}

}
