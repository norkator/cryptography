package cryptography.converters.compliment;


public class Compliment {

	public static void main(String[] args) {
	}

	public static String oneCompliment(String binary) {
		for (int a = 0; a < binary.length(); a++) {
			if (binary.charAt(a) == '0') {
				binary = binary.substring(0, a) + '1' + binary.substring(a + 1);
			} else {
				binary = binary.substring(0, a) + '0' + binary.substring(a + 1);
			}
		}
		return binary;
	}

	public static String twoCompliment(String binary) {
		int first1 = 0;
		for (first1 = binary.length() - 1; first1 >= 0; first1--) {
			if (binary.charAt(first1) == '1') {
				break;
			}
		}

		for (int a = 0; a < first1; a++) {
			if (binary.charAt(a) == '0') {
				binary = binary.substring(0, a) + '1' + binary.substring(a + 1);
			} else {
				binary = binary.substring(0, a) + '0' + binary.substring(a + 1);
			}
		}
		return binary;
	}

}
