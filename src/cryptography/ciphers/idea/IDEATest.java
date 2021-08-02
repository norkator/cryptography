package cryptography.ciphers.idea;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IDEATest {

    @Test
    public void runTest() {
        final String key = "key for idea";
        final String plainText = "Hello world input text";
        final String encrypted = IDEA.encrypt(plainText, key);
        final String decrypted = IDEA.decrypt(encrypted, key);

        assertEquals(plainText, decrypted);
    }

}
