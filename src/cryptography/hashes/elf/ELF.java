package cryptography.hashes.elf;

import java.security.NoSuchAlgorithmException;
import jonelo.jacksum.JacksumAPI;
import jonelo.jacksum.algorithm.AbstractChecksum;

public class ELF {

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

	public static String elf32(String input) {
		return jacksumAPI(input, "ELF-32");
	}

}
