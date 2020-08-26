package cryptography.ciphers.anubis;

import cryptography.Mode;

public class AnubisMethod {

	/**
	 * Anubis method for encryption and decryption
	 * 
	 * @param inputText string
	 * @param key       key from GetNewKey method
	 * @param mode      encrypt/decrypt
	 * @return string
	 */
	public static String Anubis(final String inputText, final String key, final Mode mode) {
		try {
			String output = null;

			if (mode == Mode.ENCRYPT) {

			}

			if (mode == Mode.DECRYPT) {

			}

			return output;
		} catch (Exception e) {
			return e.toString();
		}
	}

	/**
	 * Returns new key, matching 320 bits in steps of 32 bits
	 * 
	 * @return
	 */
	public static String GetNewKey() {
		return "";
	}

}
