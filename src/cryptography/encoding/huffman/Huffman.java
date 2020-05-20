package cryptography.encoding.huffman;

import java.util.*;
import cryptography.Mode;

public class Huffman {

	private static ArrayList<tree> v = new ArrayList<tree>();

	public static String huffman(String input, Mode mode) {
		String output = "";
		if (mode == Mode.ENCODE) {
			createList(input);
			prepareTree();
			encode(v.size() - 1);
			output = code(input);
		}
		return output;
	}

	private static void createList(String data) {
		for (int a = 0; a < data.length(); a++) {
			if (!exist(Character.toString(data.charAt(a)))) {
				tree temp = new tree();
				temp.ch = Character.toString(data.charAt(a));
				temp.freq = 1;
				temp.left = -1;
				temp.right = -1;
				temp.code = "";
				v.add(temp);
			}
		}
	}

	private static boolean exist(String c) {
		for (int a = 0; a < v.size(); a++) {
			if (v.get(a).ch.equals(c)) {
				v.get(a).freq++;
				return true;
			}
		}
		return false;
	}

	private static void prepareTree() {
		int pos = 0;
		int n = v.size();
		for (int a = 0; a < n - 1; a++) {
			Collections.sort(v);

			tree t1 = v.get(pos + 0);
			tree t2 = v.get(pos + 1);

			tree temp = new tree();
			temp.ch = t1.ch + t2.ch;
			temp.freq = t1.freq + t2.freq;
			temp.left = pos + 0;
			temp.right = pos + 1;
			temp.code = "";
			v.add(temp);
			pos += 2;
		}
	}

	private static void encode(int pos) {
		if (pos != -1) {
			tree parent = v.get(pos);

			if (parent.left != -1) {
				v.get(parent.left).code = parent.code + "0";
			}
			if (parent.left != -1) {
				v.get(parent.right).code = parent.code + "1";
			}
			encode(parent.left);
			encode(parent.right);
		}
	}

	private static String code(String data) {
		String str = "";
		for (int a = 0; a < data.length(); a++) {
			for (int b = 0; b < v.size(); b++) {
				if (Character.toString(data.charAt(a)).contentEquals(v.get(b).ch)) {
					str += v.get(b).code + "";
				}
			}
		}
		return str;
	}

}
