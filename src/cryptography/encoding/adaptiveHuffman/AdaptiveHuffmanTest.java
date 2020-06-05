package cryptography.encoding.adaptiveHuffman;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import cryptography.Mode;
import cryptography.encoding.adaptiveHuffman.AdaptiveHuffman;

public class AdaptiveHuffmanTest {
	@Test
	public void runTest() {
		assertEquals("00000101000100000110001011010110001010",
				AdaptiveHuffman.adaptiveHuffman("aardvark", Mode.ENCODE));
		assertEquals("aardvark",
				AdaptiveHuffman.adaptiveHuffman("00000101000100000110001011010110001010", Mode.DECODE));
	}
}