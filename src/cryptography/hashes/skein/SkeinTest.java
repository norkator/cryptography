/**
 * This class is part of running automated tests
 */
package cryptography.hashes.skein;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SkeinTest {

	@Test
	public void runTest() {
		assertEquals("e02348353cc3d62234a1caabd7e981482c5790c7b155c458760be03c5dcbf576", Skein.skein_256("testing"));
		assertEquals(
				"6bb105369b2c717e0baf0d4cdc1d6d0b7d981a284095ad18cd1ce24b80dcaffaf14022d5773cdb3374d1e945bd62e70da06c67eb521af5f2b578093015e47814",
				Skein.skein_512("testing"));
		assertEquals(
				"4e0282f3cb5f4d0dd15cc8a69ba7577c3b9932019873b97d1563afd59ce853ac75edcd71c6545a16c29982860e097ebdcf0df107b96be4e91f39378b0375c8c91f2f85e180e0f809a516016f1c78ba16812f2b185f183cbfd25e120e1eb53ae35cfb26a33d2b7b62acb8f63052def70163ac2583be907e713e231b22498f3ba6",
				Skein.skein_1024("testing"));
	}

}
