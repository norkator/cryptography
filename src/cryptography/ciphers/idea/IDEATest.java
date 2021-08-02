package cryptography.ciphers.idea;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IDEATest {

    @Test
    public void runTest() {
        final String plainText = "key for idea";
        final String encrypted = IDEA.encrypt("Hello world input text", plainText);
        final String decrypted = IDEA.decrypt(encrypted, plainText);

        assertEquals(plainText, decrypted);
    }

}
