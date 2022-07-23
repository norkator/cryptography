/**
 * This class is part of running automated tests
 */
package cryptography.encoding.pigLatin;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PigLatinTest {

	@Test
	public void PigLatinTests() throws Exception {
		assertEquals("ellohay orldway ", PigLatin.encode("hello world"));
		assertEquals("hello world ", PigLatin.decode("ellohay orldway"));

		assertEquals("isthay isay aay ongerlay ordway orfay estingtay ", PigLatin.encode("this is a longer word for testing"));
		// assertEquals("this is a longer word for testing ", PigLatin.decode("isthay isay aay ongerlay ordway orfay estingtay "));
	}

}
