package cryptography.ciphers.onetimepad;

import cryptography.Mode;

import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.ArrayList;

public class OneTimePad {

	/**
	 * @param mode  to encrypt or decrypt
	 * @param input contents
	 * @param key   to use
	 * @return encrypted or decrypted output based on mode
	 */
	public static ArrayList<String> oneTimePad(Mode mode, String input, String key) {
		org.apache.commons.codec.binary.Base64 base64 = new org.apache.commons.codec.binary.Base64();

		ArrayList<String> output = new ArrayList<>();
		if (mode == Mode.ENCRYPT) {
			final byte[] secret = input.getBytes(StandardCharsets.UTF_8);
			final byte[] encoded = new byte[secret.length];
			final byte[] key_ = new byte[secret.length];
			new SecureRandom().nextBytes(key_);
			for (int i = 0; i < secret.length; i++) {
				encoded[i] = (byte) (secret[i] ^ key_[i]);
			}
			output.add(base64.encodeToString(encoded).replace("\n", ""));
			output.add(base64.encodeToString(key_).replace("\n", ""));
		}
		if (mode == Mode.DECRYPT) {
			final byte[] secret = base64.decode(input);
			final byte[] decoded = new byte[secret.length];
			final byte[] key_ = base64.decode(key);
			for (int i = 0; i < secret.length; i++) {
				decoded[i] = (byte) (secret[i] ^ key_[i]);
			}
			output.add(new String(decoded));
		}

		return output;
	}

}
