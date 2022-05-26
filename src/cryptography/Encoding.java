package cryptography;


import cryptography.encoding.base58.Base58;
import cryptography.encoding.vicSequencing.VICSequencing;
import cryptography.encoding.a1z26.A1z26;
import cryptography.encoding.base16.Base16;
import cryptography.encoding.base32.Base32;
import cryptography.encoding.base64.Base64;
import cryptography.encoding.base85.Base85;
import cryptography.encoding.base91.Base91;
import cryptography.encoding.huffman.Huffman;
import cryptography.encoding.adaptiveHuffman.AdaptiveHuffman;
import cryptography.encoding.morse.Morse;
import cryptography.encoding.rle.Rle;
import cryptography.encoding.koblitz.Koblitz;

import java.math.BigDecimal;

import cryptography.ciphers.ellipticCurve.EllipticCurve;

public class Encoding {

	public static void main(String[] args) {

		// Base16
		System.out.println("Base16 encode: " + Base16.encode("HELLO"));
		System.out.println("Base16 decode: " + Base16.decode("48454C4C4F"));

		// Base32
		System.out.println("Base32 encode: " + Base32.base32("HELLO", Mode.ENCODE));
		System.out.println("Base32 decode: " + Base32.base32("JBCUYTCP", Mode.DECODE));

		// Base58
		System.out.println("Base58 encode: " + Base58.encodeFromString("HELLO"));
		System.out.println("Base58 decode: " + Base58.decodeToString("99v1Y8E"));

		// Base64
		System.out.println("Base64 encode: " + Base64.base64("HELLO", Mode.ENCODE));
		System.out.println("Base64 decode: " + Base64.base64("SEVMTE8=", Mode.DECODE));

		// Base85
		System.out.println("Base85 encode: " + Base85.base85("HELLO", Mode.ENCODE));
		System.out.println("Base85 decode: " + Base85.base85("84?3G:B", Mode.DECODE));

		// Base91
		System.out.println("Base91 encode: " + Base91.base91("TESTING", Mode.ENCODE));
		System.out.println("Base91 decode: " + Base91.base91("\"OdH0zJpE", Mode.DECODE));

		// A1z26
		System.out.println("A1z26 encode: " + A1z26.a1z26("HELLO", Mode.ENCODE));
		System.out.println("A1z26 decode: " + A1z26.a1z26("8-5-12-12-15", Mode.DECODE));

		// Morse
		System.out.println("Morse encode: " + Morse.morse("TESTING MORSE", Mode.ENCODE));
		System.out.println("Morse decode: " + Morse.morse("- . ... - .. -. --. -- --- .-. ... .", Mode.DECODE));

		// Huffman (only encoding)
		System.out.println("Huffman encode: " + Huffman.huffman("abcdbcdcdd", Mode.ENCODE));

		//AdaptiveHuffman
		System.out.println("AdaptiveHuffman encode: " + AdaptiveHuffman.adaptiveHuffman("aardvark", Mode.ENCODE));
		System.out.println("AdaptiveHuffman decode: " + AdaptiveHuffman.adaptiveHuffman("00000101000100000110001011010110001010", Mode.DECODE));

		// Run-Length Encoding (RLE)
		System.out.println("RLE encode: " + Rle.rle(Mode.ENCODE, "AAAAAAAAAAABBBBCCCCCC"));
		System.out.println("RLE decode: " + Rle.rle(Mode.DECODE, "A10B4C30"));

		// Koblit'z Method
		System.out.println("RLE encode: " + Koblitz.encode("HELLO", 20, new EllipticCurve(new BigDecimal("-1"), new BigDecimal("1"), new BigDecimal("5")))[0]);
		System.out.println("RLE decode: " + Koblitz.decode(new String[]{"427340773284", "248"}, 20, new EllipticCurve(new BigDecimal("-1"), new BigDecimal("1"), new BigDecimal("5"))));

		// VIC sequencing
		System.out.println("VIC sequencing encode: " + VICSequencing.encode("MYSISTERIS"));

	}
}
