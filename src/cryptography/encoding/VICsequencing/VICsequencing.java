package cryptography.encoding.VICsequencing;


public class VICsequencing {
	private static String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	public static String encode(String input) {
		if(input.length() > 10) {
			return "Input size cant be more than 10";
		}
		
		char[] output = new char[input.length()];

		int count = 0;
		
		for(int a=0;a<alphabet.length();a++) {
			for(int b=0;b<input.length();b++) {
				if(alphabet.charAt(a) == input.charAt(b)) {
					count++;
					if(count == 10) count = 0; 
					output[b] = (char)(count + '0'); 
				}
			}
		}

		return new String(output);
	}
}
