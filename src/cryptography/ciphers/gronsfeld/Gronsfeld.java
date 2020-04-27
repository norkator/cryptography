package cryptography.ciphers.gronsfeld;

import cryptography.Mode;

public class Gronsfeld {

	private static int[] addedNumeric;

	public static void main(String[] args) {
	}

	public static String gronsfeld(String input, String keyword, Mode mode) {
		String output = "";

		if (mode == Mode.ENCRYPT) {
			input = formatInputString(input);
			int[] numericInput = turnInputNumeric(input);
			keyword = formatKeywordString(keyword);
			String lengthenedKeyword = generateGronsfeldKeyword(keyword, input);
			int[] numericKeyword = turnKeywordNumeric(lengthenedKeyword);
			addedNumeric = addNumericStrings(mode, numericInput, numericKeyword);
			output = turnAlpha(addedNumeric);
		}

		if (mode == Mode.DECRYPT) {
			input = formatInputString(input);
			int[] numericInput = turnInputNumeric(input);
			keyword = formatKeywordString(keyword);
			String lengthenedKeyword = generateGronsfeldKeyword(keyword, input);
			int[] numericKeyword = turnKeywordNumeric(lengthenedKeyword);
			addedNumeric = addNumericStrings(mode, numericInput, numericKeyword);
			output = turnAlpha(addedNumeric);
		}

		return output;
	}

	private static String formatInputString(String originalString) {
		return (originalString.replaceAll("[^A-Za-z]", "")).toUpperCase();
	}

	private static String formatKeywordString(String originalString) {
		return (originalString.replaceAll("[^0-9]", ""));
	}

	private static String generateGronsfeldKeyword(String keyword, String input) {
		StringBuilder returnKeyword = new StringBuilder();
		while (returnKeyword.length() < input.length()) {
			returnKeyword.append(keyword);
		}
		returnKeyword = new StringBuilder(returnKeyword.substring(0, input.length()));
		return returnKeyword.toString();
	}

	private static int[] turnInputNumeric(String originalString) {
		int[] returnNumeric = new int[originalString.length()];
		for (int i = 0; i < originalString.length(); i++) {
			returnNumeric[i] = originalString.charAt(i) - 65;
		}
		return returnNumeric;
	}

	private static int[] turnKeywordNumeric(String originalString) {
		int[] returnNumeric = new int[originalString.length()];
		for (int i = 0; i < originalString.length(); i++) {
			returnNumeric[i] = ((int) originalString.charAt(i)) - 48;
		}
		return returnNumeric;
	}

	private static int[] addNumericStrings(Mode mode, int[] numericInput, int[] numericKeyword) {
		int[] returnAddedNumeric = new int[numericInput.length];
		for (int i = 0; i < numericInput.length; i++) {
			if (mode == Mode.ENCRYPT) {
				returnAddedNumeric[i] = (numericInput[i] + numericKeyword[i]) % 26;
			} else {
				returnAddedNumeric[i] = (numericInput[i] + (26 - numericKeyword[i])) % 26;
			}
		}
		return returnAddedNumeric;
	}

	private static String turnAlpha(int[] addedNumeric) {
		StringBuilder returnString = new StringBuilder();
		for (int value : addedNumeric) {
			returnString.append((char) (value + 65));
		}
		return returnString.toString();
	}

}
