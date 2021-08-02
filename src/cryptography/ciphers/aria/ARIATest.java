package cryptography.ciphers.aria;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ARIATest {

    @Test
    public void runTest() {
        final String plainText = "key for aria";
        final String encrypted = ARIA.encrypt("Hello world input text", plainText);
        final String decrypted = ARIA.decrypt(encrypted, plainText);

        assertEquals(plainText, decrypted);
    }

}
