package cryptography.other.hmac;

import java.util.ArrayList;

@SuppressWarnings("PointlessBitwiseExpression")
public class EatonHMAC {

	public static void main(String[] args) {
	}


	/**
	 * Get Eaton IPM HMAC
	 *
	 * @param key  which is password
	 * @param data which is challenge
	 * @return HMAC string
	 */
	public static String GetEatonHMAC(String key, String data) {
		return hmac_encode(sha1_encode(key), data);
	}

	private static int rotate_left(int n, int s) {
		return (n << s) | (n >>> (32 - s));
	}

	private static String lsb_hex(int val) {
		StringBuilder str = new StringBuilder();
		int i;
		int vh;
		int vl;

		for (i = 0; i <= 6; i += 2) {
			vh = (val >>> (i * 4 + 4)) & 0x0f;
			vl = (val >>> (i * 4)) & 0x0f;
			str.append(Integer.toString(vh, 16)).append(Integer.toString(vl, 16));
		}
		return str.toString();
	}


	private static String cvt_hex(int val) {
		StringBuilder str = new StringBuilder();
		int i;
		int v;

		for (i = 7; i >= 0; i--) {
			v = (val >>> (i * 4)) & 0x0f;
			str.append(Integer.toString(v, 16));
		}
		return str.toString();
	}


	private static String sha1_encode(String msg) {
		int blockstart;
		int i, j;
		Integer[] W = new Integer[80]; // new Array(80);
		int H0 = 0x67452301;
		int H1 = 0xEFCDAB89;
		int H2 = 0x98BADCFE;
		int H3 = 0x10325476;
		int H4 = 0xC3D2E1F0;
		int A, B, C, D, E;
		int temp;

		int msg_len = msg.length();

		ArrayList<Integer> word_array = new ArrayList<>();
		for (i = 0; i < msg_len - 3; i += 4) {
			j = msg.charAt(i) << 24 | msg.charAt(i + 1) << 16 | msg.charAt(i + 2) << 8 | msg.charAt(i + 3);
			word_array.add(j);
		}

		switch (msg_len % 4) {
			case 0:
				i = 0x080000000;
				break;
			case 1:
				i = msg.charAt(msg_len - 1) << 24 | 0x0800000;
				break;
			case 2:
				i = msg.charAt(msg_len - 2) << 24 | msg.charAt(msg_len - 1) << 16 | 0x08000;
				break;
			case 3:
				i = msg.charAt(msg_len - 3) << 24 | msg.charAt(msg_len - 2) << 16 | msg.charAt(msg_len - 1) << 8 | 0x80;
				break;
		}

		word_array.add(i);
		while ((word_array.size() % 16) != 14) word_array.add(0);

		word_array.add(msg_len >>> 29);
		word_array.add((msg_len << 3) & 0x0ffffffff);

		for (blockstart = 0; blockstart < word_array.size(); blockstart += 16) {
			for (i = 0; i < 16; i++) W[i] = word_array.get(blockstart + i);
			for (i = 16; i <= 79; i++) W[i] = rotate_left(W[i - 3] ^ W[i - 8] ^ W[i - 14] ^ W[i - 16], 1);

			A = H0;
			B = H1;
			C = H2;
			D = H3;
			E = H4;

			for (i = 0; i <= 19; i++) {
				temp = (rotate_left(A, 5) + ((B & C) | (~B & D)) + E + W[i] + 0x5A827999) & 0x0ffffffff;
				E = D;
				D = C;
				C = rotate_left(B, 30);
				B = A;
				A = temp;
			}

			for (i = 20; i <= 39; i++) {
				temp = (rotate_left(A, 5) + (B ^ C ^ D) + E + W[i] + 0x6ED9EBA1) & 0x0ffffffff;
				E = D;
				D = C;
				C = rotate_left(B, 30);
				B = A;
				A = temp;
			}

			for (i = 40; i <= 59; i++) {
				temp = (rotate_left(A, 5) + ((B & C) | (B & D) | (C & D)) + E + W[i] + 0x8F1BBCDC) & 0x0ffffffff;
				E = D;
				D = C;
				C = rotate_left(B, 30);
				B = A;
				A = temp;
			}

			for (i = 60; i <= 79; i++) {
				temp = (rotate_left(A, 5) + (B ^ C ^ D) + E + W[i] + 0xCA62C1D6) & 0x0ffffffff;
				E = D;
				D = C;
				C = rotate_left(B, 30);
				B = A;
				A = temp;
			}

			H0 = (H0 + A) & 0x0ffffffff;
			H1 = (H1 + B) & 0x0ffffffff;
			H2 = (H2 + C) & 0x0ffffffff;
			H3 = (H3 + D) & 0x0ffffffff;
			H4 = (H4 + E) & 0x0ffffffff;
		}
		String result = cvt_hex(H0) + cvt_hex(H1) + cvt_hex(H2) + cvt_hex(H3) + cvt_hex(H4);
		return result.toLowerCase();
	}


	// checked => valid
	static String hexToBin(String hStr) {
		StringBuilder bStr = new StringBuilder();
		for (int i = 0; i < hStr.length(); i += 2)
			bStr.append((char) ((Integer.parseInt(String.valueOf(hStr.charAt(i)), 16) << 4) + Integer.parseInt(String.valueOf(hStr.charAt(i + 1)), 16)));
		return bStr.toString();

	}

	private static int charCodeAt(String string, int index) {
		return (int) string.charAt(index);
	}

	private static String hmac_encode(String key, String data) {
		int hashLength = 64;

		if (key.length() > hashLength) {
			key = hexToBin(sha1_encode(key));
		}
		if (key.length() < hashLength) {
			StringBuilder keyBuilder = new StringBuilder(key);
			while (keyBuilder.length() < hashLength) {
				keyBuilder.append("\0");
			}
			key = keyBuilder.toString();
		}

		int i = 0;
		StringBuilder ipad = new StringBuilder();
		StringBuilder opad = new StringBuilder();
		while (i < key.length()) {
			char a = (char) (charCodeAt(key, i) ^ 0x5C);
			char b = (char) (charCodeAt(key, i) ^ 0x36);
			opad.append(a);
			ipad.append(b);
			i++;
		}

		return sha1_encode(opad + hexToBin(sha1_encode(ipad + data)));
	}

}
