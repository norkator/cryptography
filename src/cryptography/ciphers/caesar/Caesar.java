package cryptography.ciphers.caesar;

import cryptography.Mode;

public class Caesar {

	public static void main(String[] args) {
	}

	/**
	 * Caesar cipher
	 * 
	 * @param inputText  Text to cipher / decipher
	 * @param shiftCount Alphabet shift count
	 * @param mode       encrypt or decrypt mode
	 * @return String based on selected mode
	 */
	public static String caesar(String inputText, int shiftCount, final Mode mode) {
		try {
			String output = "";
			int ascii;

			if (mode == Mode.DECRYPT) {
				shiftCount=-1*shiftCount;	
			}
			
			shiftCount=(shiftCount+26)%26;

			for(int a=0;a<inputText.length();a++){
				ascii=(((int)inputText.charAt(a))+shiftCount);
				output+=(ascii>'Z')?Character.toString((char)((ascii%'Z')+'A'-1)):Character.toString((char)(ascii));
			}
			
			return output;
		} catch (ArrayIndexOutOfBoundsException e) {
			return e.toString();
		}
	}

}
