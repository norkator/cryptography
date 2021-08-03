/**
 * This class is part of running automated tests
 */
package cryptography.encoding.base16;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Base16Test {

    @Test
    public void runTest() {
        assertEquals("48454C4C4F", Base16.encode("HELLO"));
        assertEquals("HELLO", Base16.decode("48454C4C4F"));
    }

}
