package cryptography.hashes.whirlpool;

import java.security.NoSuchAlgorithmException;
import jonelo.jacksum.JacksumAPI;
import jonelo.jacksum.algorithm.AbstractChecksum;

public class Whirlpool {

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

	public static String whirlpool0(String input) {
		return jacksumAPI(input, "Whirlpool-0");
	}

	public static String whirlpool1(String input) {
		return jacksumAPI(input, "Whirlpool-1");
	}

	public static String whirlpool(String input) {
		return jacksumAPI(input, "Whirlpool");
	}

}
