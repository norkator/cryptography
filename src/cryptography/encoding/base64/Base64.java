package cryptography.encoding.base64;

import cryptography.Mode;

public class Base64 {

	public static void main(String[] args) {
	}

	public static String base64(String input, Mode mode) {
		String output = "";
		byte[] encode = input.getBytes();
		byte[] decode;

		/*
		 * Note, Cryptography application uses 'android.util.Base64;' implementation
		 * instead but works by the standard You can find Apache codec Base64 source
		 * code from link below
		 * https://github.com/apache/commons-codec/blob/master/src/main/java/org/apache/
		 * commons/codec/binary/Base64.java
		 */
		org.apache.commons.codec.binary.Base64 base64 = new org.apache.commons.codec.binary.Base64();

		if (mode == Mode.ENCODE) {
			output = base64.encodeToString(encode);
		}

		if (mode == Mode.DECODE) {
			decode = base64.decode(input);
			output = new String(decode);
		}

		return output;
	}

}
