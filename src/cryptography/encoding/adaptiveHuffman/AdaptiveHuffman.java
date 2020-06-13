package cryptography.encoding.adaptiveHuffman;

import cryptography.Mode;

public class AdaptiveHuffman {
	public static String adaptiveHuffman(String input, Mode mode) {
		String output = "";

		if (mode == Mode.ENCODE) {
			AdaptiveHuffmanEncode adaptiveHuffmanEncode = new AdaptiveHuffmanEncode();
			output = adaptiveHuffmanEncode.Encode(input);
		}
		if (mode == Mode.DECODE) {
			AdaptiveHuffmanDecode adaptiveHuffmanDecode = new AdaptiveHuffmanDecode();
			output = adaptiveHuffmanDecode.Decode(input);
		}
		return output;
	}
}
