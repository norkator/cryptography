package cryptography.encoding.adaptiveHuffman;

import java.util.ArrayList;

public class AdaptiveHuffmanDecode {

	private static ArrayList<Tree> tree;
	private static int NYT;
	private static int nodeNo;
	private static int currNode;

	public AdaptiveHuffmanDecode() {
		tree = new ArrayList<>();
		createNode("NYT", 51, 0, -1, "");
		NYT = 0;
		nodeNo = 51;
		currNode = 0;
	}

	public String Decode(String data) {
		StringBuilder output = new StringBuilder();
		int a = 0, p;
		String code;
		boolean firstFlag;

		do {
			if (tree.get(currNode).left == -1 && tree.get(currNode).right == -1) {
				if (currNode == NYT) {
					code = data.substring(a, a + 4);
					a = a + 4;
					p = Integer.parseInt(code, 2);
					if (p < 10) {
						code += data.charAt(a++);
						p = Integer.parseInt(code, 2);
						output.append(intToCode(p, 5));
					} else {
						output.append(intToCode(p, 4));
					}
				} else {
					output.append(tree.get(currNode).ch);
				}

				firstFlag = first(Character.toString(output.charAt(output.length() - 1)));
				update(firstFlag, Character.toString(output.charAt(output.length() - 1)));

				currNode = 0;
			} else {
				if (data.charAt(a++) == '0') {
					currNode = tree.get(currNode).left;
				} else {
					currNode = tree.get(currNode).right;
				}
			}
		} while (a < data.length());

		return output.toString();
	}

	private void createNode(String str, int num, int freq, int p, String c) {
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

	private String intToCode(int x, int bit) {
		if (bit == 5) {
			if (x == 0) {
				return "a";
			} else if (x == 1) {
				return "b";
			} else if (x == 2) {
				return "c";
			} else if (x == 3) {
				return "d";
			} else if (x == 4) {
				return "e";
			} else if (x == 5) {
				return "f";
			} else if (x == 6) {
				return "g";
			} else if (x == 7) {
				return "h";
			} else if (x == 8) {
				return "i";
			} else if (x == 9) {
				return "j";
			} else if (x == 10) {
				return "k";
			} else if (x == 11) {
				return "l";
			} else if (x == 12) {
				return "m";
			} else if (x == 13) {
				return "n";
			} else if (x == 14) {
				return "o";
			} else if (x == 15) {
				return "p";
			} else if (x == 16) {
				return "q";
			} else if (x == 17) {
				return "r";
			} else if (x == 18) {
				return "s";
			} else if (x == 19) {
				return "t";
			}
		} else if (bit == 4) {
			if (x == 10) {
				return "u";
			} else if (x == 11) {
				return "v";
			} else if (x == 12) {
				return "w";
			} else if (x == 13) {
				return "x";
			} else if (x == 14) {
				return "y";
			} else if (x == 15) {
				return "z";
			}
		}
		return "";
	}

	private boolean first(String str) {
		for (int a = 0; a < tree.size(); a++) {
			if (tree.get(a).ch.equals(str)) {
				return false;
			}
		}
		return true;
	}

	private void update(boolean flag, String str) {
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

	private int findNodeMax(int n) {
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

	private void gotoParent(int n) {
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

	private void switchNodes(int a, int b) {
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

	private void reNumCode(int n) {
		if (tree.get(n).left != -1 && tree.get(n).right != -1) {
			tree.get(tree.get(n).right).no = (--nodeNo);
			tree.get(tree.get(n).left).no = (--nodeNo);

			tree.get(tree.get(n).left).code = tree.get(n).code + "0";
			tree.get(tree.get(n).right).code = tree.get(n).code + "1";

			reNumCode(tree.get(n).right);
			reNumCode(tree.get(n).left);
		}
	}

	@SuppressWarnings("unused")
	private void display() {
		for (int a = 0; a < tree.size(); a++) {
			System.out.println("" + a + " ch:" + tree.get(a).ch + " weight:" + tree.get(a).weight + " no:"
					+ tree.get(a).no + " l:" + tree.get(a).left + " r:" + tree.get(a).right + " p:" + tree.get(a).parent
					+ " code:" + tree.get(a).code);
		}
		System.out.println("Press Enter to continue");
		try {
			System.in.read();
		} catch (Exception ignored) {
		}
	}

}
