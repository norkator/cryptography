package cryptography.ciphers.bacon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import cryptography.Mode;

public class Bacon {

	public static void main(String[] args) {
	}

	public static String bacon(String input, Mode mode) {
		String output = "";
		StringBuilder stringBuilder = new StringBuilder();
		Map<String, String> table = new HashMap<>();

		if (mode == Mode.ENCRYPT) {
			table.put("A", "AAAAA");
			table.put("B", "AAAAB");
			table.put("C", "AAABA");
			table.put("D", "AAABB");
			table.put("E", "AABAA");
			table.put("F", "AABAB");
			table.put("G", "AABBA");
			table.put("H", "AABBB");
			table.put("I", "ABAAA");
			table.put("J", "ABAAB");
			table.put("K", "ABABA");
			table.put("L", "ABABB");
			table.put("M", "ABBAA");
			table.put("N", "ABBAB");
			table.put("O", "ABBBA");
			table.put("P", "ABBBB");
			table.put("Q", "BAAAA");
			table.put("R", "BAAAB");
			table.put("S", "BAABA");
			table.put("T", "BAABB");
			table.put("U", "BABAA");
			table.put("V", "BABAB");
			table.put("W", "BABBA");
			table.put("X", "BABBB");
			table.put("Y", "BBAAA");
			table.put("Z", "BBAAB");
			char[] chars = input.toUpperCase().replace(" ", "").toCharArray();
			for (char aChar : chars) {
				String ch = Character.toString(aChar);
				stringBuilder.append(table.get(ch)).append(" ");
			}
			output = stringBuilder.toString();
		}

		if (mode == Mode.DECRYPT) {
			table.put("AAAAA", "A");
			table.put("AAAAB", "B");
			table.put("AAABA", "C");
			table.put("AAABB", "E");
			table.put("AABAA", "E");
			table.put("AABAB", "F");
			table.put("AABBA", "G");
			table.put("AABBB", "H");
			table.put("ABAAA", "I");
			table.put("ABAAB", "J");
			table.put("ABABA", "K");
			table.put("ABABB", "L");
			table.put("ABBAA", "M");
			table.put("ABBAB", "N");
			table.put("ABBBA", "O");
			table.put("ABBBB", "P");
			table.put("BAAAA", "Q");
			table.put("BAAAB", "R");
			table.put("BAABA", "S");
			table.put("BAABB", "T");
			table.put("BABAA", "U");
			table.put("BABAB", "V");
			table.put("BABBA", "W");
			table.put("BABBB", "X");
			table.put("BBAAA", "Y");
			table.put("BBAAB", "Z");
			ArrayList<String> chars = new ArrayList<>();
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(input).useDelimiter(" ");
			while (scanner.hasNext()) {
				chars.add(scanner.next());
			}
			for (int i = 0; i < chars.size(); i++) {
				stringBuilder.append(table.get(chars.get(i)));
			}
			output = stringBuilder.toString();
		}

		return output;
	}

}
