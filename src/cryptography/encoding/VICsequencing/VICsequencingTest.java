package cryptography.encoding.VICsequencing;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class VICsequencingTest {
	@Test
	public void runTest() {
		assertEquals("4062791538", VICsequencing.encode("MYSISTERIS"));
		assertEquals("2163475", VICsequencing.encode("OCTOPUS"));
		assertEquals("51234678", VICsequencing.encode("30111999"));
		assertEquals("Input size cant be more than 10", VICsequencing.encode("MYSISTERISOCTOPUS"));
	}
}
