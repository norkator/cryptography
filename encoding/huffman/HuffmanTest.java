/**
 * This class is part of running automated tests
 */
package cryptography.encoding.huffman;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import cryptography.Mode;
import cryptography.encoding.huffman.Huffman;

public class HuffmanTest {
	@Test
	public void runTest() {
		assertEquals("110010011101110", Huffman.huffman("bccabdbc", Mode.ENCODE));
	}
}
