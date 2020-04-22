package cryptography.caesar;

import cryptography.Mode;

public class Caesar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	/**
	 * Caesar cipher
	 * @param inputText Text to cipher / decipher
	 * @param shiftCount Alphabet shift count
	 * @param mode encrypt or decrypt mode
	 * @return String based on selected mode
	 */
    public static String caesar(String inputText, final int shiftCount, final Mode mode) {
        try {
        	String output = null;
            char[] alpha = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
            char[] encrypt = new char[alpha.length];
            char[] decrypt = new char[alpha.length];
            
            inputText = inputText.toUpperCase();
            
            for (int i = 0; i < alpha.length; i++) {
                encrypt[i] = alpha[(i + shiftCount) % alpha.length];
            }
            for (int i = 0; i < alpha.length; i++) {
                decrypt[encrypt[i] - 'A'] = alpha[i];
            }
            
            if (mode == Mode.ENCRYPT) {
                char[] temp = inputText.toCharArray();
                for (int i = 0; i < temp.length; i++) {
                	temp[i] = encrypt[temp[i] - 'A'];
                }
                output = new String(temp);
            }

            if (mode == Mode.DECRYPT) {
                char[] temp = inputText.toCharArray();
                for (int i = 0; i < temp.length; i++) {
                	temp[i] = decrypt[temp[i] - 'A'];
                }
                output = new String(temp);
            }
            
            return output;
        } catch (ArrayIndexOutOfBoundsException e) {
            return e.toString();
        }
    }

}
