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
		map.put("C", new String[]{"BA-GOSHI", "TLA-GIN", "MOASI"});
		map.put("D", new String[]{"LHA-CHA-EH", "CHINDI", "BE"});
		map.put("E", new String[]{"AH-NAH", "DZEH", "AH-JAH"});
		map.put("F", new String[]{"MA-E", "TSA-E-DONIN-EE", "CHUO"});
		map.put("G", new String[]{"JEHA", "KLIZZIE", "AH-TAD"});
		map.put("H", new String[]{"LIN", "CHA", "TSE-GAH"});
		map.put("I", new String[]{"TKIN", "YEH-HES", "A-CHI"});
		map.put("J", new String[]{"YIL-DOI", "AH-YA-TSINNE", "TKELE-CHO-G"});
		map.put("K", new String[]{"KLIZZIE-YAZZIE", "BA-AH-NE-DI-TININ", "JAD-HO-LONI"});
		map.put("L", new String[]{"NASH-DOIE-TSO", "AH-JAD", "DIBEH-YAZZIE"});
		map.put("M", new String[]{"NA-AS-TSO-SI", "BE-TAS-TNI", "TSIN-TLITI"});
		map.put("N", new String[]{"A-CHIN", "TSAH"});
		map.put("O", new String[]{"NE-AHS-JAH", "TLO-CHIN", "A-KHA"});
		map.put("P", new String[]{"NE-ZHONI", "BI-SO-DIH", "CLA-GI-AIH"});
		map.put("Q", new String[]{"CA-YEILTH"});
		map.put("R", new String[]{"AH-LOSZ", "DAH-NES-TSA", "GAH"});
		map.put("S", new String[]{"KLESH", "DIBEH"});
		map.put("T", new String[]{"THAN-ZIE", "A-WOH", "D-AH"});
		map.put("U", new String[]{"NO-DA-IH", "SHI-DA"});
		map.put("V", new String[]{"A-KEH-DI-GLINI "});
		map.put("W", new String[]{"GLOE-IH"});
		map.put("X", new String[]{"AL-NA-AS-DZOH "});
		map.put("Y", new String[]{"TSAH-AS-ZIH"});
		map.put("Z", new String[]{"BESH-DO-TLIZ"});
		return map;
	}


	public static String encrypt(String input) {
		input = input.toUpperCase();
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

		String[] words = input.toUpperCase().split(" ");
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



