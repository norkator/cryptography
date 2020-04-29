package cryptography.hashes.sum;

import java.security.NoSuchAlgorithmException;
import jonelo.jacksum.JacksumAPI;
import jonelo.jacksum.algorithm.AbstractChecksum;

public class SUM {

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

	public static String sum8(String input) {
		return jacksumAPI(input, "sum8");
	}

	public static String sum16(String input) {
		return jacksumAPI(input, "sum16");
	}

	public static String sum24(String input) {
		return jacksumAPI(input, "sum24");
	}

	public static String sum32(String input) {
		return jacksumAPI(input, "sum32");
	}

}
