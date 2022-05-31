package cryptography.ciphers.navajo;

import cryptography.random.randomInt.RandomInt;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Navajo {

	private static Map<String, String[]> getNavajoMap() {
		Map<String, String[]> map = new HashMap<>();
		map.put("A", new String[]{"WOL-LA-CHEE", "BE-LA-SANA", "TSE-NILL"});
		map.put("B", new String[]{"NA-HASH-CHID", "SHUSH", "TOISH-JEH"});
		return map;
	}


	public static String encrypt(String input) {
		Map<String, String[]> map = getNavajoMap();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < input.length(); i++) {
			String c = input.substring(i, i + 1);
			String[] values = map.get(c);
			sb.append(values[RandomInt.getBetween(0, values.length - 1)]);
			sb.append(" ");
		}
		return sb.toString();
	}


	public static String decrypt(String input) {
		Map<String, String[]> map = getNavajoMap();
		StringBuilder sb = new StringBuilder();

		String[] words = input.split(" ");
		for (String word : words) {
			map.forEach((k, v) -> {
				if (Arrays.asList(v).contains(word)) {
					sb.append(k);
				}
			});
		}
		return sb.toString();
	}


}



