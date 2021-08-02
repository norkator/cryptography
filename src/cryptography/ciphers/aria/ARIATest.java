package cryptography.ciphers.aria;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ARIATest {

    @Test
    public void runTest() {
        final String key = "test key";
        final String plainText = "hello world input";
        final String encrypted = ARIA.encrypt(plainText, key);
        final String decrypted = ARIA.decrypt(encrypted, key);
        assertEquals(plainText, decrypted);
    }

}
