package cryptography.ciphers.VIC;

import cryptography.encoding.VICsequencing.VICsequencing;

public class VIC {

	public static String encrypt(String input, int date, int personalNo, int key) {
		input = input.toUpperCase().replaceAll(" ", "");
		int lineA = key;
		int lineB = date;
		int lineC = modSub(lineA,lineB);
		String lineD = input.substring(0,20);
		String lineE = VICsequencing.encode(lineD.substring(0,10)) + VICsequencing.encode(lineD.substring(10));
		String lineF = chainAddition(lineC) + "1234567890";
		

		System.out.println(lineA);
		System.out.println(lineB);
		System.out.println(lineC);
		System.out.println(lineD);
		System.out.println(lineE);
		System.out.println(lineF);
		
		return "abc";
	}
	
	public static int modSub(int a,int b) {
		
		int res = 0;
		
		while(a > 0 && b > 0) {
			int d1 = a % 10;
			int d2 = b % 10;
			
			int sub = (d1 > d2)? d1-d2: d1-d2+10;

			res = res * 10 + sub;

			a = a / 10;
			b = b / 10;
		}
		return Integer.parseInt((new StringBuilder(String.valueOf(res))).reverse().toString());
	}
	
	public static String chainAddition(int num) {
		String res = String.valueOf(num);
		int length = res.length();
		
		for(int a=0;a<length;a++) {
			res = res + ((Character.getNumericValue(res.charAt(a))+Character.getNumericValue(res.charAt(a+1))) % 10);
		}
		
		return res;
	}
	
}
