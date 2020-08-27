package cryptography.ciphers.khazad;

/**
 * <b>The Khazad legacy-level block cipher.</b>
 *
 * <P>
 * <b>References</b>
 *
 * <P>
 * The Khazad algorithm was developed by
 * <a href="mailto:pbarreto@scopus.com.br">Paulo S. L. M. Barreto</a> and
 * <a href="mailto:vincent.rijmen@cryptomathic.com">Vincent Rijmen</a>.
 *
 * See P.S.L.M. Barreto, V. Rijmen, ``The Khazad legacy-level block cipher,''
 * NESSIE submission, 2000.
 * 
 * @author Paulo S.L.M. Barreto
 * @author Vincent Rijmen.
 *
 * @version 2.0 (2001.09.24)
 * 
 *          =============================================================================
 *
 *          Differences from version 1.0:
 *
 *          - Original S-box replaced by the tweaked, hardware-efficient
 *          version.
 *
 *          =============================================================================
 *
 *          THIS SOFTWARE IS PROVIDED BY THE AUTHORS ''AS IS'' AND ANY EXPRESS
 *          OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 *          WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 *          ARE DISCLAIMED. IN NO EVENT SHALL THE AUTHORS OR CONTRIBUTORS BE
 *          LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 *          CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 *          SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR
 *          BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 *          LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 *          NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 *          SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 */

public class Khazad {

	/**
	 * Standard number of rounds.
	 */
	public static final int R = 8;

	private static final String Sbox = "\uba54\u2f74\u53d3\ud24d\u50ac\u8dbf\u7052\u9a4c"
			+ "\uead5\u97d1\u3351\u5ba6\ude48\ua899\udb32\ub7fc" + "\ue39e\u919b\ue2bb\u416e\ua5cb\u6b95\ua1f3\ub102"
			+ "\uccc4\u1d14\uc363\uda5d\u5fdc\u7dcd\u7f5a\u6c5c" + "\uf726\uffed\ue89d\u6f8e\u19a0\uf089\u0f07\uaffb"
			+ "\u0815\u0d04\u0164\udf76\u79dd\u3d16\u3f37\u6d38" + "\ub973\ue935\u5571\u7b8c\u7288\uf62a\u3e5e\u2746"
			+ "\u0c65\u6861\u03c1\u57d6\ud958\ud866\ud73a\uc83c" + "\ufa96\ua798\uecb8\uc7ae\u694b\uaba9\u670a\u47f2"
			+ "\ub522\ue5ee\ube2b\u8112\u831b\u0e23\uf545\u21ce" + "\u492c\uf9e6\ub628\u1782\u1a8b\ufe8a\u09c9\u874e"
			+ "\ue12e\ue4e0\ueb90\ua41e\u8560\u0025\uf4f1\u940b" + "\ue775\uef34\u31d4\ud086\u7ead\ufd29\u303b\u9ff8"
			+ "\uc613\u0605\uc511\u777c\u7a78\u361c\u3959\u1856" + "\ub3b0\u2420\ub292\ua3c0\u4462\u10b4\u8443\u93c2"
			+ "\u4abd\u8f2d\ubc9c\u6a40\ucfa2\u804f\u1fca\uaa42";

	private static long[][] T = new long[8][256];
	private static int[] S = new int[256];
	private static long[] c = new long[R + 1];

	static {
		for (int x = 0; x < 256; x++) {
			long c = Sbox.charAt(x / 2) & 0xffffL;
			long s1 = ((x & 1) == 0) ? c >>> 8 : c & 0xff;
			long s2 = s1 << 1;
			if (s2 >= 0x100L) {
				s2 ^= 0x11dL;
			}
			long s3 = s2 ^ s1;
			long s4 = s2 << 1;
			if (s4 >= 0x100L) {
				s4 ^= 0x11dL;
			}
			long s5 = s4 ^ s1;
			long s6 = s4 ^ s2;
			long s7 = s6 ^ s1;
			long s8 = s4 << 1;
			if (s8 >= 0x100L) {
				s8 ^= 0x11dL;
			}
			long sb = s8 ^ s2 ^ s1;

			T[0][x] = (s1 << 56) | (s3 << 48) | (s4 << 40) | (s5 << 32) | (s6 << 24) | (s8 << 16) | (sb << 8) | s7;
			T[1][x] = (s3 << 56) | (s1 << 48) | (s5 << 40) | (s4 << 32) | (s8 << 24) | (s6 << 16) | (s7 << 8) | sb;
			T[2][x] = (s4 << 56) | (s5 << 48) | (s1 << 40) | (s3 << 32) | (sb << 24) | (s7 << 16) | (s6 << 8) | s8;
			T[3][x] = (s5 << 56) | (s4 << 48) | (s3 << 40) | (s1 << 32) | (s7 << 24) | (sb << 16) | (s8 << 8) | s6;
			T[4][x] = (s6 << 56) | (s8 << 48) | (sb << 40) | (s7 << 32) | (s1 << 24) | (s3 << 16) | (s4 << 8) | s5;
			T[5][x] = (s8 << 56) | (s6 << 48) | (s7 << 40) | (sb << 32) | (s3 << 24) | (s1 << 16) | (s5 << 8) | s4;
			T[6][x] = (sb << 56) | (s7 << 48) | (s6 << 40) | (s8 << 32) | (s4 << 24) | (s5 << 16) | (s1 << 8) | s3;
			T[7][x] = (s7 << 56) | (sb << 48) | (s8 << 40) | (s6 << 32) | (s5 << 24) | (s4 << 16) | (s3 << 8) | s1;
			S[x] = (int) s1;
		}
		for (int r = 0; r <= R; r++) {
			c[r] = ((Sbox.charAt(4 * r + 0) & 0xffffL) << 48) | ((Sbox.charAt(4 * r + 1) & 0xffffL) << 32)
					| ((Sbox.charAt(4 * r + 2) & 0xffffL) << 16) | ((Sbox.charAt(4 * r + 3) & 0xffffL));
		}

		/*
		 * for (int t = 0; t < 8; t++) { System.out.println("static const u64 T" + t +
		 * "[256] = {"); for (int i = 0; i < 64; i++) { System.out.print("   "); for
		 * (int j = 0; j < 4; j++) { String v = Long.toHexString(T[t][4*i + j]); while
		 * (v.length() < 16) { v = "0" + v; } System.out.print(" LL(0x" + v + "),"); }
		 * System.out.println(); } System.out.println("};"); System.out.println(); }
		 * System.out.println("static const u64 c[R + 1] = {"); for (int r = 0; r <= R;
		 * r++) { String v = Long.toHexString(c[r]); while (v.length() < 16) { v = "0" +
		 * v; } System.out.println("    LL(0x" + v + "),"); } System.out.println("};");
		 * System.out.println();
		 */
	}

	protected long[] roundKeyEnc = new long[R + 1];
	protected long[] roundKeyDec = new long[R + 1];

	public Khazad() {
	}

	/**
	 * Create the Khazad key schedule for a given cipher key.
	 * 
	 * @param key The 128-bit cipher key.
	 */
	public final void keySetup(byte[/* 16 */] key) {

		if (key.length != 16) {
			throw new RuntimeException("Invalid Khazad key size: " + (8 * key.length) + " bits.");
		}

		/*
		 * map byte array cipher key to initial key state (mu):
		 */
		long K2 = ((long) (key[0]) << 56) ^ ((long) (key[1] & 0xff) << 48) ^ ((long) (key[2] & 0xff) << 40)
				^ ((long) (key[3] & 0xff) << 32) ^ ((long) (key[4] & 0xff) << 24) ^ ((long) (key[5] & 0xff) << 16)
				^ ((long) (key[6] & 0xff) << 8) ^ ((long) (key[7] & 0xff));
		long K1 = ((long) (key[8]) << 56) ^ ((long) (key[9] & 0xff) << 48) ^ ((long) (key[10] & 0xff) << 40)
				^ ((long) (key[11] & 0xff) << 32) ^ ((long) (key[12] & 0xff) << 24) ^ ((long) (key[13] & 0xff) << 16)
				^ ((long) (key[14] & 0xff) << 8) ^ ((long) (key[15] & 0xff));

		/*
		 * compute the round keys:
		 */
		for (int r = 0; r <= R; r++) {
			/*
			 * K[r] = rho(c[r], K1) ^ K2;
			 */
			roundKeyEnc[r] = T[0][(int) (K1 >>> 56)] ^ T[1][(int) (K1 >>> 48) & 0xff] ^ T[2][(int) (K1 >>> 40) & 0xff]
					^ T[3][(int) (K1 >>> 32) & 0xff] ^ T[4][(int) (K1 >>> 24) & 0xff] ^ T[5][(int) (K1 >>> 16) & 0xff]
					^ T[6][(int) (K1 >>> 8) & 0xff] ^ T[7][(int) (K1) & 0xff] ^ c[r] ^ K2;
			K2 = K1;
			K1 = roundKeyEnc[r];
		}
		/*
		 * compute the inverse key schedule: K'^0 = K^R, K'^R = K^0, K'^r =
		 * theta(K^{R-r})
		 */
		roundKeyDec[0] = roundKeyEnc[R];
		for (int r = 1; r < R; r++) {
			K1 = roundKeyEnc[R - r];
			roundKeyDec[r] = T[0][S[(int) (K1 >>> 56)]] ^ T[1][S[(int) (K1 >>> 48) & 0xff]]
					^ T[2][S[(int) (K1 >>> 40) & 0xff]] ^ T[3][S[(int) (K1 >>> 32) & 0xff]]
					^ T[4][S[(int) (K1 >>> 24) & 0xff]] ^ T[5][S[(int) (K1 >>> 16) & 0xff]]
					^ T[6][S[(int) (K1 >>> 8) & 0xff]] ^ T[7][S[(int) (K1) & 0xff]];
		}
		roundKeyDec[R] = roundKeyEnc[0];
	} // keySetup

	/**
	 * Either encrypt or decrypt a data block, according to the key schedule.
	 * 
	 * @param block    the data block to be encrypted/decrypted.
	 * @param roundKey the key schedule to be used.
	 */
	protected final void crypt(byte[/* 8 */] block, long[/* R + 1 */] roundKey) {
		/*
		 * map byte array block to cipher state (mu) and add initial round key
		 * (sigma[K^0]):
		 */
		long state = ((long) (block[0]) << 56) ^ ((long) (block[1] & 0xff) << 48) ^ ((long) (block[2] & 0xff) << 40)
				^ ((long) (block[3] & 0xff) << 32) ^ ((long) (block[4] & 0xff) << 24) ^ ((long) (block[5] & 0xff) << 16)
				^ ((long) (block[6] & 0xff) << 8) ^ ((long) (block[7] & 0xff)) ^ roundKey[0];

		/*
		 * R - 1 full rounds:
		 */
		for (int r = 1; r < R; r++) {
			state = T[0][(int) (state >>> 56)] ^ T[1][(int) (state >>> 48) & 0xff] ^ T[2][(int) (state >>> 40) & 0xff]
					^ T[3][(int) (state >>> 32) & 0xff] ^ T[4][(int) (state >>> 24) & 0xff]
					^ T[5][(int) (state >>> 16) & 0xff] ^ T[6][(int) (state >>> 8) & 0xff] ^ T[7][(int) (state) & 0xff]
					^ roundKey[r];
		}

		/*
		 * last round:
		 */
		state = (T[0][(int) (state >>> 56)] & 0xff00000000000000L)
				^ (T[1][(int) (state >>> 48) & 0xff] & 0x00ff000000000000L)
				^ (T[2][(int) (state >>> 40) & 0xff] & 0x0000ff0000000000L)
				^ (T[3][(int) (state >>> 32) & 0xff] & 0x000000ff00000000L)
				^ (T[4][(int) (state >>> 24) & 0xff] & 0x00000000ff000000L)
				^ (T[5][(int) (state >>> 16) & 0xff] & 0x0000000000ff0000L)
				^ (T[6][(int) (state >>> 8) & 0xff] & 0x000000000000ff00L)
				^ (T[7][(int) (state) & 0xff] & 0x00000000000000ffL) ^ roundKey[R];

		/*
		 * map cipher state to byte array block (mu^{-1}):
		 */
		block[0] = (byte) (state >>> 56);
		block[1] = (byte) (state >>> 48);
		block[2] = (byte) (state >>> 40);
		block[3] = (byte) (state >>> 32);
		block[4] = (byte) (state >>> 24);
		block[5] = (byte) (state >>> 16);
		block[6] = (byte) (state >>> 8);
		block[7] = (byte) (state);
	}

	/**
	 * Encrypt a data block.
	 * 
	 * @param block the data buffer to be encrypted.
	 */
	public final void encrypt(byte[/* 8 */] block) {
		crypt(block, roundKeyEnc);
	}

	/**
	 * Decrypt a data block.
	 * 
	 * @param block the data buffer to be decrypted.
	 */
	public final void decrypt(byte[/* 8 */] block) {
		crypt(block, roundKeyDec);
	}

	private static String display(byte[] array) {
		char[] val = new char[2 * array.length];
		String hex = "0123456789ABCDEF";
		for (int i = 0; i < array.length; i++) {
			int b = array[i] & 0xff;
			val[2 * i] = hex.charAt(b >>> 4);
			val[2 * i + 1] = hex.charAt(b & 15);
		}
		return String.valueOf(val);
	}

	/**
	 * Generate the test vector set for Khazad.
	 *
	 * The test consists of the encryption of every block with a single bit set
	 * under every key with a single bit set for every allowed key size.
	 */
	public static void makeTestVectors() {
		System.out.println("Khazad test vectors");
		System.out.println("--------------------------------------------------");
		Khazad a = new Khazad();

		byte[] key = new byte[16];
		for (int i = 0; i < key.length; i++) {
			key[i] = 0;
		}
		byte[] block = new byte[8];
		for (int i = 0; i < block.length; i++) {
			block[i] = 0;
		}
		/*
		 * long elapsed = -System.currentTimeMillis(); for (int i = 0; i < 100000; i++)
		 * { a.keySetup(key); } elapsed += System.currentTimeMillis();
		 * System.out.println("Key setup time: " + elapsed + " ms."); if (key[0] == 0) {
		 * return; }
		 */

		/*
		 * iteration test -- encrypt the null block under the null key a billion times:
		 */
		System.out.println("Long iteration test:");
		System.out.print("\tKEY: " + display(key));
		a.keySetup(key);
		for (int k = 0; k < 1000; k++) {
			a.encrypt(block);
		}
		System.out.println("\tCT: " + display(block));
		for (int k = 0; k < 1000; k++) {
			a.decrypt(block);
		}
		for (int i = 0; i < block.length; i++) {
			if (block[i] != 0) {
				System.out.println("ERROR IN LONG ITERATION TEST!");
				return;
			}
		}
		System.out.println("Null block under all keys with a single bit set:");
		for (int k = 0; k < 128; k++) {
			// set the k-th bit:
			key[k / 8] |= (byte) (0x80 >>> (k % 8));
			System.out.print("\tKEY: " + display(key));
			// setup key:
			a.keySetup(key);
			// encrypt the null block:
			a.encrypt(block);
			System.out.println("\tCT: " + display(block));
			// decrypt:
			a.decrypt(block);
			for (int i = 0; i < block.length; i++) {
				if (block[i] != 0) {
					System.out.println("ERROR IN SINGLE-BIT KEY TEST!");
					return;
				}
			}
			// reset the k-th key bit:
			key[k / 8] = 0;
		}
		System.out.println("--------------------------------------------------");
	}

	public static void main(String[] args) throws java.io.IOException {
		Khazad.makeTestVectors();
		System.out.println("Press <ENTER> to finish...");
		System.in.read();
	}

}
