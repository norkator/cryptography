package cryptography.padding.pad;

public class Pad {
	/*
	 	@Param
	 		binary: String => Input binary string to be padded
	 	@return
	 		binary: String => A string with 4 character equivalent to input
	 		exception: String => In case input length > 4
	 */
	public static String to4(String binary) {
		int length = binary.length();
		if (length > 4) {
			return "Input exception. \nCannot pad. \nInput length > 4";
		}

		StringBuilder binaryBuilder = new StringBuilder(binary);
		for (int a = 0; a < 4 - length; a++) {
			binaryBuilder.insert(0, "0");
		}
		binary = binaryBuilder.toString();
		return binary;
	}

	/*
	 	@Param
	 		binary: String => Input binary string to be padded
	 	@return
	 		binary: String => A string with 8 character equivalent to input
	 		exception: String => In case input length > 8
	*/
	public static String to8(String binary) {
		int length = binary.length();
		if (length > 8) {
			return "Input exception. \nCannot pad. \nInput length > 8";
		}

		StringBuilder binaryBuilder = new StringBuilder(binary);
		for (int a = 0; a < 8 - length; a++) {
			binaryBuilder.insert(0, "0");
		}
		binary = binaryBuilder.toString();
		return binary;
	}

	/*
	 	@Param
	 		binary: String => Input binary string to be padded
	 	@return
	 		binary: String => A string with 16 character equivalent to input
	 		exception: String => In case input length > 16
	*/
	public static String to16(String binary) {
		int length = binary.length();
		if (length > 16) {
			return "Input exception. \nCannot pad. \nInput length > 16";
		}

		StringBuilder binaryBuilder = new StringBuilder(binary);
		for (int a = 0; a < 16 - length; a++) {
			binaryBuilder.insert(0, "0");
		}
		binary = binaryBuilder.toString();
		return binary;
	}

	/*
	 	@Param
	 		binary: String => Input binary string to be padded
	 	@return
	 		binary: String => A string with 32 character equivalent to input
	 		exception: String => In case input length > 32
	*/
	public static String to32(String binary) {
		int length = binary.length();
		if (length > 32) {
			return "Input exception. \nCannot pad. \nInput length > 32";
		}

		StringBuilder binaryBuilder = new StringBuilder(binary);
		for (int a = 0; a < 32 - length; a++) {
			binaryBuilder.insert(0, "0");
		}
		binary = binaryBuilder.toString();
		return binary;
	}

	/*
	 	@Param
	 		binary: String => Input binary string to be padded
	 		customLength: int => final required length of the input string
	 	@return
	 		binary: String => A string with customLength and equivalent to input
	 		exception: String => In case input length > customLength
	 		exception: String => In case custom length <= 0
	*/
	public static String toCustomLength(String binary, int customLength) {
		int length = binary.length();
		if (length > customLength) {
			return "Input exception. \nCannot pad. \nInput length > " + customLength;
		}
		if (customLength <= 0) {
			return "Input exception. \nCannot pad. \nCustom length <= 0";
		}

		StringBuilder binaryBuilder = new StringBuilder(binary);
		for (int a = 0; a < customLength - length; a++) {
			binaryBuilder.insert(0, "0");
		}
		binary = binaryBuilder.toString();
		return binary;
	}

}
