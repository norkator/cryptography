package cryptography.encoding.adaptiveHuffman;

import cryptography.Mode;

public class AdaptiveHuffman {
	public static String adaptiveHuffman(String input, Mode mode) {
		String output="";
		
		if(mode==Mode.ENCODE) {
			output=AdaptiveHuffmanEncode.encode(input);
		}
		if(mode==Mode.DECODE) {
			output=AdaptiveHuffmanDecode.decode(input);
		}
		return output;
	}
}
