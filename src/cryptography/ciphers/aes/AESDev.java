package cryptography.ciphers.aes;

import org.spongycastle.util.encoders.Base64;
import org.spongycastle.util.encoders.Hex;

import java.nio.charset.StandardCharsets;


public class AESDev {

	private final static String plainText = "Simple testing string for AES cipher encryption and decryption testing";
	private final static String password = "test password for AES testing";

	public static void main(String[] args) {
		try {
			aesWithBlankIV();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	private static void aesWithBlankIV() throws Exception {
		System.out.println("-------- aesWithBlankIV -------- ");
		byte[] salt = Hex.decode("68656c6c6f776f72");
		byte[] iv = AES.IV_BLANK; //Hex.decode("68656c6c6f776f726c6468656c6c6f77");


		byte[] key = AES.createKey(password, salt, AES.KEY_GENERATION_ITERATIONS, AES.KEY_SIZE_256_BITS).getKey();
		String encrypted = Base64.toBase64String(AES.encrypt(plainText.getBytes(), key, iv));
		System.out.println(encrypted);

		String decryptedData = new String(AES.decrypt(Base64.decode(encrypted), key, iv), StandardCharsets.UTF_8);
		System.out.println(decryptedData);
	}


}
