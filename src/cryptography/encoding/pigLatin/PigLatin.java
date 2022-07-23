package cryptography.encoding.pigLatin;

public class PigLatin {

	public static String encode(String input) {
		StringBuilder sb = new StringBuilder();
		String[] words = input.split(" ");
		for (String w : words) {
			String pigLatinWord = pigLatinWord(w);
			sb.append(pigLatinWord.equals("-1") ? w : pigLatinWord).append(" ");
		}
		return sb.toString();
	}

	// Todo.. decoding doesn't work yet
	public static String decode(String input) {
		StringBuilder sb = new StringBuilder();
		String[] words = input.toLowerCase().split(" ");
		for (String w : words) {
			if (w.endsWith("ay")) {
				w = w.substring(0, w.length() - 2);
				char lastChar = w.charAt(w.length() - 1);
				w = lastChar + w.substring(0, w.length() - 1);
			}
			sb.append(w).append(" ");
		}
		return sb.toString();
	}

	private static boolean isVowel(char ch) {
		return (
			ch == 'A' || ch == 'a' || ch == 'E' || ch == 'e' || ch == 'I' || ch == 'i' ||
				ch == 'O' || ch == 'o' || ch == 'U' || ch == 'u'
		);
	}


	private static String pigLatinWord(String string) {
		int strLength = string.length();
		int index = -1;
		for (int i = 0; i < strLength; i++) {
			if (isVowel(string.charAt(i))) {
				index = i;
				break;
			}
		}
		if (index == -1) {
			return "-1";
		}
		return string.substring(index) + string.substring(0, index) + "ay";
	}


}
