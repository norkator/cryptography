package cryptography.ciphers.VIC;

import cryptography.encoding.VICsequencing.VICsequencing;

public class VIC {

	public static String keyGen(String input, int date, int personalNo, int key) {
		input = input.toUpperCase().replaceAll(" ", "");
		String lineA = String.valueOf(key);
		String lineB = String.valueOf(date);
		String lineC = modSub(lineA,lineB);
		String lineD = input.substring(0,20);
		String lineE = VICsequencing.encode(lineD.substring(0,10)) + VICsequencing.encode(lineD.substring(10));
		String lineF = chainAddition(lineC, 5) + "1234567890";
		String lineG = modAdd(lineE.substring(0,10),lineF.substring(0, 10));
		String lineH = encodeByReplacing(lineG, lineE.substring(10), lineF.substring(10));
		String lineJ = VICsequencing.encode(lineH);
		String chainAdd50Res = chainAddition(lineH, 50);
		String lineK = chainAdd50Res.substring(10,20);
		String lineL = chainAdd50Res.substring(20,30);
		String lineM = chainAdd50Res.substring(30,40);
		String lineN = chainAdd50Res.substring(40,50);
		String lineP = chainAdd50Res.substring(50,60);

//		System.out.println(lineA);
//		System.out.println(lineB);
//		System.out.println(lineC);
//		System.out.println(lineD);
//		System.out.println(lineE);
//		System.out.println(lineF);
//		System.out.println(lineG);
//		System.out.println(lineH);
//		System.out.println(lineJ);
//		System.out.println(lineK);
//		System.out.println(lineL);
//		System.out.println(lineM);
//		System.out.println(lineN);
//		System.out.println(lineP);
		
		return "abc";
	}
	
	public static String modSub(String str1,String str2) {
		String res = "";
		for(int a=0;a<str1.length();a++) {
			int num1 = Character.getNumericValue(str1.charAt(a));
			int num2 = Character.getNumericValue(str2.charAt(a));
			
			int val = (num1 >= num2)? num1-num2: num1-num2+10;
			res = res + String.valueOf(val);
		}
		return res;
	}
	
	public static String modAdd(String str1, String str2) {
		String res = "";
		for(int a=0;a<str1.length();a++) {
			int num1 = Character.getNumericValue(str1.charAt(a));
			int num2 = Character.getNumericValue(str2.charAt(a));
			
			int val = (num1 + num2) % 10;
			res = res + String.valueOf(val);
		}
		return res;
	}
	
	public static String encodeByReplacing(String str, String key, String aid) {
		String res = str;
		for(int a=0;a<aid.length();a++) {
			for(int b=0;b<str.length();b++) {
				if(str.charAt(b) == aid.charAt(a)) {
					res = res.substring(0,b) + key.charAt(a) + res.substring(b+1);
				}
			}
		}
		return res;
	}
	
	public static String chainAddition(String num, int length) {
		String res = num;
		
		for(int a=0;a<length;a++) {
			res = res + ((Character.getNumericValue(res.charAt(a))+Character.getNumericValue(res.charAt(a+1))) % 10);
		}
		
		return res;
	}
	
}
