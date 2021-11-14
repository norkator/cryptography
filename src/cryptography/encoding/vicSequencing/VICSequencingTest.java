package cryptography.encoding.vicSequencing;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class VICSequencingTest {

	@Test
	public void runTest() {
		assertEquals("4062791538", VICSequencing.encode("MYSISTERIS"));
		assertEquals("2163475", VICSequencing.encode("OCTOPUS"));
		assertEquals("48123567", VICSequencing.encode("30111999"));
		assertEquals("Input size cannot be more than 10 chars long", VICSequencing.encode("MYSISTERISOCTOPUS"));
	}

}
