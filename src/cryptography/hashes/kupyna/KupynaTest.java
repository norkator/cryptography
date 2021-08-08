/*
 * This class is part of running automated tests
 */
package cryptography.hashes.kupyna;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KupynaTest {

	@Test
	public void runTest() {
		assertEquals("6ae5d8e72118431e5c51ed6d2e73ad35aa01b82cf6a404f4d2c4edcba418fc2d", Kupyna.kupyna256("testing"));
		assertEquals("6f6309d2a9b053c1fb345eb7cf02170be95e4dec5c40f90bf301907e52e2010b669a6b95aa88cc8cf34955d385cf5a91", Kupyna.kupyna384("testing"));
		assertEquals("81858a9fcc2891435f26e4478b8689906f6309d2a9b053c1fb345eb7cf02170be95e4dec5c40f90bf301907e52e2010b669a6b95aa88cc8cf34955d385cf5a91", Kupyna.kupyna512("testing"));
	}

}
