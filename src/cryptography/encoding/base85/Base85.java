/**
 * Ascii85 is also called Base85
 */
package cryptography.encoding.base85;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.regex.Pattern;

import cryptography.Mode;

public class Base85 {

	private final static int ASCII_SHIFT = 33;

	private static int[] BASE85_POW = { 1, 85, 85 * 85, 85 * 85 * 85, 85 * 85 * 85 * 85 };

	private static Pattern REMOVE_WHITESPACE = Pattern.compile("\\s+");

	public static void main(String[] args) {
	}

	public static String base85(String input, Mode mode) {
		String output = "";
		if (mode == Mode.ENCODE) {
			output = encode(input.getBytes());
		}

		if (mode == Mode.DECODE) {
			output = decode(input);
		}
		return output;
	}

	public static String encode(byte[] payload) {
		if (payload == null || payload.length == 0) {
			throw new IllegalArgumentException("You must provide a non-zero length input");
		}
		StringBuilder stringBuff = new StringBuilder(payload.length * 5 / 4);
		byte[] chunk = new byte[4];
		int chunkIndex = 0;
		for (int i = 0; i < payload.length; i++) {
			byte currByte = payload[i];
			chunk[chunkIndex++] = currByte;
			if (chunkIndex == 4) {
				int value = byteToInt(chunk);
				if (value == 0) {
					stringBuff.append('z');
				} else {
					stringBuff.append(encodeChunk(value));
				}
				Arrays.fill(chunk, (byte) 0);
				chunkIndex = 0;
			}
		}
		if (chunkIndex > 0) {
			int numPadded = chunk.length - chunkIndex;
			Arrays.fill(chunk, chunkIndex, chunk.length, (byte) 0);
			int value = byteToInt(chunk);
			char[] encodedChunk = encodeChunk(value);
			for (int i = 0; i < encodedChunk.length - numPadded; i++) {
				stringBuff.append(encodedChunk[i]);
			}
		}
		return stringBuff.toString();
	}

	private static char[] encodeChunk(int value) {
		char[] encodedChunk = new char[5];
		for (int i = 0; i < encodedChunk.length; i++) {
			encodedChunk[i] = (char) ((value / BASE85_POW[4 - i]) + ASCII_SHIFT);
			value = value % BASE85_POW[4 - i];
		}
		return encodedChunk;
	}

	// Decode
	public static String decode(String chars) {
		try {
			if (chars == null || chars.length() == 0) {
				throw new IllegalArgumentException("You must provide a non-zero length input");
			}
			BigDecimal decodedLength = BigDecimal.valueOf(chars.length()).multiply(BigDecimal.valueOf(4))
					.divide(BigDecimal.valueOf(5));
			ByteBuffer bytebuff = ByteBuffer.allocate(decodedLength.intValue());
			chars = REMOVE_WHITESPACE.matcher(chars).replaceAll("");
			byte[] payload = chars.getBytes("UTF-8");
			byte[] chunk = new byte[5];
			int chunkIndex = 0;
			for (int i = 0; i < payload.length; i++) {
				byte currByte = payload[i];
				if (currByte == 'z') {
					if (chunkIndex > 0) {
						throw new IllegalArgumentException("The payload is not base 85 encoded.");
					}
					chunk[chunkIndex++] = '!';
					chunk[chunkIndex++] = '!';
					chunk[chunkIndex++] = '!';
					chunk[chunkIndex++] = '!';
					chunk[chunkIndex++] = '!';
				} else {
					chunk[chunkIndex++] = currByte;
				}

				if (chunkIndex == 5) {
					bytebuff.put(decodeChunk(chunk));
					Arrays.fill(chunk, (byte) 0);
					chunkIndex = 0;
				}
			}

			if (chunkIndex > 0) {
				int numPadded = chunk.length - chunkIndex;
				Arrays.fill(chunk, chunkIndex, chunk.length, (byte) 'u');
				byte[] paddedDecode = decodeChunk(chunk);
				for (int i = 0; i < paddedDecode.length - numPadded; i++) {
					bytebuff.put(paddedDecode[i]);
				}
			}

			bytebuff.flip();
			return new String(Arrays.copyOf(bytebuff.array(), bytebuff.limit()));
		} catch (UnsupportedEncodingException e) {
			return "Error; (Invalid Base85|Ascii85 input) " + e.toString();
		} catch (BufferOverflowException e) {
			return "Error; " + e.toString();
		}
	}

	private static byte[] decodeChunk(byte[] chunk) {
		if (chunk.length != 5) {
			throw new IllegalArgumentException("You can only decode chunks of size 5.");
		}
		int value = 0;
		value += (chunk[0] - ASCII_SHIFT) * BASE85_POW[4];
		value += (chunk[1] - ASCII_SHIFT) * BASE85_POW[3];
		value += (chunk[2] - ASCII_SHIFT) * BASE85_POW[2];
		value += (chunk[3] - ASCII_SHIFT) * BASE85_POW[1];
		value += (chunk[4] - ASCII_SHIFT) * BASE85_POW[0];
		return intToByte(value);
	}

	private static int byteToInt(byte[] value) {
		if (value == null || value.length != 4) {
			throw new IllegalArgumentException("You cannot create an int without exactly 4 bytes.");
		}
		return ByteBuffer.wrap(value).getInt();
	}

	private static byte[] intToByte(int value) {
		return new byte[] { (byte) (value >>> 24), (byte) (value >>> 16), (byte) (value >>> 8), (byte) (value) };
	}

}
