package cryptography.ciphers.anubis;

import java.security.SecureRandom;
import java.util.Arrays;

import org.apache.commons.codec.binary.Base64;

import cryptography.Mode;

public class AnubisMethod {

	/**
	 * Anubis method for encryption and decryption
	 * 
	 * @param inputText string
	 * @param keyBytes  key from GetNewKey method
	 * @param mode      encrypt/decrypt
	 * @return string
	 */
	public static String Anubis(final String inputText, final byte[] keyBytes, final Mode mode) {
		try {
			Base64 base64 = new Base64();

			Anubis anubis = new Anubis();
			anubis.keySetup(keyBytes);
			
			final int take = 16;

			if (mode == Mode.ENCRYPT) {
				byte[] cipherBytes = applyPadding(inputText.getBytes());
				
				int from = 0;
				int to = 0;
				int left = cipherBytes.length;
				byte[] resultBytes = new byte[left];
				
				while (left > 0) {
					
					if (left < from + take) {
						to = left;
					} else {
						to = from + take;
					}
					
					byte[] slice = Arrays.copyOfRange(cipherBytes, from, to);
					anubis.encrypt(slice);
					
					System.arraycopy(slice, 0, resultBytes, from, to + slice.length);
					
					from = from + to;
					
				}
				
				return base64.encodeToString(cipherBytes);
			}

			if (mode == Mode.DECRYPT) {
				byte[] cipherBytes = base64.decode(inputText.getBytes());
				anubis.decrypt(cipherBytes);
				return new String(cipherBytes);
			}

			return null;
		} catch (Exception e) {
			return e.toString();
		}
	}

	/**
	 * Returns new key, matching 320 bits in steps of 32 bits
	 * 
	 * @return
	 */
	public static byte[] GetRandomKeyBytes() {
		SecureRandom random = new SecureRandom();
		byte[] bytes = new byte[40];
		random.nextBytes(bytes);
		return bytes;
	}

	/**
	 * Return key bytes as base64 string
	 * 
	 * @param keyBytes key
	 * @return base64 string
	 */
	public static String KeyBytesToBase64String(byte[] keyBytes) {
		Base64 base64 = new Base64();
		return base64.encodeToString(keyBytes);
	}
	
	/**
	 * Return base64 key as byte array
	 * @param base64Key b64 key string
	 * @return byte array
	 */
	public static byte[] KeyBase64StringToBytes(final String base64Key) {
        Base64 base64 = new Base64();
        return base64.decode(base64Key.getBytes());
    }

	/**
	 * Applies padding on too short input
	 * 
	 * @param input byte array input
	 * @return either input or padded input
	 */
	private static byte[] applyPadding(byte[] input) {
		final int l = input.length;
		if (l < 16) {
			int n = 16 - l;
			byte[] padding = new byte[n];
			return concatenateByteArrays(input, padding);
		}
		return input;
	}

	/**
	 * Connects two byte arrays together
	 * 
	 * @param a first byte array
	 * @param b second byte array
	 * @return concatenated byte array
	 */
	private static byte[] concatenateByteArrays(byte[] a, byte[] b) {
		byte[] result = new byte[a.length + b.length];
		System.arraycopy(a, 0, result, 0, a.length);
		System.arraycopy(b, 0, result, a.length, b.length);
		return result;
	}

}
