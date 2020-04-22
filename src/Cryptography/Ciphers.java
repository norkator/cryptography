package Cryptography;

import Cryptography.caesar.Caesar;

public class Ciphers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		// Caesar
		String caesarCiphered = Caesar.caesar("HELLO", 3, Mode.ENCRYPT);
		System.out.println("Caesar encrypt: " + caesarCiphered);
		System.out.println("Caesar decrypt: " + Caesar.caesar(caesarCiphered, 3, Mode.DECRYPT));
	
		
		

	}

}
