package cryptography.encoding.adaptiveHuffman;

import java.util.ArrayList;

public class AdaptiveHuffmanEncode {
	static ArrayList<Tree> tree = new ArrayList<Tree>();
	static int NYT = 0;
	static int nodeNo = 51;
	static int currNode;
	static String output = "";

	public static String encode(String data) {
		createNode("NYT", 51, 0, -1, "");

		boolean firstFlag;
		for (int a = 0; a < data.length(); a++) {
			firstFlag = false;
			if (first(a, data)) {
				firstFlag = true;
				output += tree.get(NYT).code;
				output += ChartoCode(data.charAt(a));
			} else {
				output += retCodeData(Character.toString(data.charAt(a)));
			}
			update(firstFlag, Character.toString(data.charAt(a)));
		}

		return output;
	}

	public static void createNode(String str, int num, int freq, int p, String c) {
		Tree temp = new Tree();
		temp.ch = str;
		temp.no = num;
		temp.weight = freq;
		temp.left = -1;
		temp.right = -1;
		temp.parent = p;
		temp.code = c;

		tree.add(temp);
	}

	public static boolean first(int n, String data) {
		for (int a = 0; a < n; a++) {
			if (data.charAt(a) == data.charAt(n)) {
				return false;
			}
		}
		return true;
	}

	public static String ChartoCode(char ch) {
		switch (ch) {
		case 'a':
			return "00000";
		case 'b':
			return "00001";
		case 'c':
			return "00010";
		case 'd':
			return "00011";
		case 'e':
			return "00100";
		case 'f':
			return "00101";
		case 'g':
			return "00110";
		case 'h':
			return "00111";
		case 'i':
			return "01000";
		case 'j':
			return "01001";
		case 'k':
			return "01010";
		case 'l':
			return "01011";
		case 'm':
			return "01100";
		case 'n':
			return "01101";
		case 'o':
			return "01110";
		case 'p':
			return "01111";
		case 'q':
			return "10000";
		case 'r':
			return "10001";
		case 's':
			return "10010";
		case 't':
			return "10011";
		case 'u':
			return "1010";
		case 'v':
			return "1011";
		case 'w':
			return "1100";
		case 'x':
			return "1101";
		case 'y':
			return "1110";
		case 'z':
			return "1111";
		default:
			return "";
		}
	}

	public static String retCodeData(String str) {
		for (int a = 0; a < tree.size(); a++) {
			if (str.equals(tree.get(a).ch)) {
				currNode = a;
				return tree.get(a).code;
			}
		}
		return "";
	}

	public static void update(boolean flag, String str) {
		if (flag) {
			tree.get(NYT).ch = "-";
			tree.get(NYT).left = tree.size();
			tree.get(NYT).right = tree.size() + 1;

			createNode("NYT", tree.get(NYT).no - 2, 0, NYT, tree.get(NYT).code + "0");
			createNode(str, tree.get(NYT).no - 1, 1, NYT, tree.get(NYT).code + "1");

			tree.get(NYT).weight++;
			NYT = tree.get(NYT).left;

			currNode = tree.get(NYT).parent;
		} else {
			int nodeMax = findNodeMax(currNode);
			if (nodeMax > 0) {
				switchNodes(currNode, nodeMax);
			}
			tree.get(currNode).weight++;
		}

		gotoParent(currNode);
	}

	public static int findNodeMax(int n) {
		int w = tree.get(n).weight;
		int index = n;

		for (int a = 0; a < tree.size(); a++) {
			if (tree.get(a).weight == w && tree.get(a).no > tree.get(index).no) {
				index = a;
			}
		}

		if (index == n) {
			return -1;
		}

		return index;
	}

	public static void gotoParent(int n) {
		int nodeMax;
		while (tree.get(n).parent != -1) {
			n = tree.get(n).parent;
			nodeMax = findNodeMax(n);

			if (nodeMax < 0) {
				tree.get(n).weight++;
			} else {
				switchNodes(n, nodeMax);
				reNumCode(0);
				tree.get(n).weight++;
				nodeNo = 51;
			}
		}
	}

	static void switchNodes(int a, int b) {
		// swap parent's child
		int parent_a = tree.get(a).parent;
		int parent_b = tree.get(b).parent;
		int parent_a_left = tree.get(parent_a).left;
		int parent_b_left = tree.get(parent_b).left;

		// swap no.
		int temp = tree.get(a).no;
		tree.get(a).no = tree.get(b).no;
		tree.get(b).no = temp;

		// swap code
		String str = tree.get(a).code;
		tree.get(a).code = tree.get(b).code;
		tree.get(b).code = str;

		// swap parent
		temp = tree.get(a).parent;
		tree.get(a).parent = tree.get(b).parent;
		tree.get(b).parent = temp;

		if (parent_a_left == a) {
			tree.get(parent_a).left = b;
		} else {
			tree.get(parent_a).right = b;
		}

		if (parent_b_left == b) {
			tree.get(parent_b).left = a;
		} else {
			tree.get(parent_b).right = a;
		}
	}

	static void reNumCode(int n) {
		if (tree.get(n).left != -1 && tree.get(n).right != -1) {
			tree.get(tree.get(n).right).no = (--nodeNo);
			tree.get(tree.get(n).left).no = (--nodeNo);

			tree.get(tree.get(n).left).code = tree.get(n).code + "0";
			tree.get(tree.get(n).right).code = tree.get(n).code + "1";

			reNumCode(tree.get(n).right);
			reNumCode(tree.get(n).left);
		}
	}

	static void display() {
		for (int a = 0; a < tree.size(); a++) {
			System.out.println("" + a + " ch:" + tree.get(a).ch + " weight:" + tree.get(a).weight + " no:"
					+ tree.get(a).no + " l:" + tree.get(a).left + " r:" + tree.get(a).right + " p:" + tree.get(a).parent
					+ " code:" + tree.get(a).code);
		}
	}
}
