package cryptography.hashes.md;

import java.security.NoSuchAlgorithmException;
import jonelo.jacksum.JacksumAPI;
import jonelo.jacksum.algorithm.AbstractChecksum;

public class MDHashes {

	public static void main(String[] args) {
	}

	private static String jacksumAPI(String input, String instance) {
		String output = "";
		AbstractChecksum abstractChecksum = null;
		try {
			abstractChecksum = JacksumAPI.getChecksumInstance(instance.toLowerCase());
			abstractChecksum.update(input.getBytes());
			output = abstractChecksum.getFormattedValue();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return output;
	}

	public static String md2(String input) {
		return jacksumAPI(input, "MD2");
	}

	public static String md4(String input) {
		return jacksumAPI(input, "MD4");
	}

	public static String md5(String input) {
		return jacksumAPI(input, "MD5");
	}

}
