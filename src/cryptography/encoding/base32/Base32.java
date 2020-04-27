package cryptography.encoding.base32;

import cryptography.Mode;

public class Base32 {

	public static void main(String[] args) {
	}

	public static String base32(String input, Mode mode) {
		String output = "";
		
		// See source: https://github.com/apache/commons-codec/blob/master/src/main/java/org/apache/commons/codec/binary/Base32.java
		org.apache.commons.codec.binary.Base32 base32 = new org.apache.commons.codec.binary.Base32();

		if (mode == Mode.ENCODE) {
			output = base32.encodeToString(input.getBytes());
		}

		if (mode == Mode.DECODE) {
			output = new String(base32.decode(input));
		}
		
		return output;
	}

}
