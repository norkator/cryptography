package cryptography.encoding.morse;

import cryptography.Mode;

public class Morse {
	
	public static String morse( String input, Mode mode ) {
		input=input.toUpperCase();
		StringBuilder str = new StringBuilder();
		if( mode == Mode.ENCODE ) {
			input = input.replace(" ", "");
			for(int a=0; a<input.length();a++) {
				switch(input.charAt(a)) {
					case 'A': str.append(".-");break;
					case 'B': str.append("-...");break;
					case 'C': str.append("-.-.");break;
					case 'D': str.append("-..");break;
					case 'E': str.append(".");break;
					case 'F': str.append("..-.");break;
					case 'G': str.append("--.");break;
					case 'H': str.append("....");break;
					case 'I': str.append("..");break;
					case 'J': str.append(".---");break;
					case 'K': str.append("-.-");break;
					case 'L': str.append(".-..");break;
					case 'M': str.append("--");break;
					case 'N': str.append("-.");break;
					case 'O': str.append("---");break;
					case 'P': str.append(".--.");break;
					case 'Q': str.append("--.-");break;
					case 'R': str.append(".-.");break;
					case 'S': str.append("...");break;
					case 'T': str.append("-");break;
					case 'U': str.append("..-");break;
					case 'V': str.append("...-");break;
					case 'W': str.append(".--");break;
					case 'X': str.append("-..-");break;
					case 'Y': str.append("-.--");break;
					case 'Z': str.append("--..");break;
					case '0': str.append("-----");break;
					case '1': str.append(".----");break;
					case '2': str.append("..---");break;
					case '3': str.append("...--");break;
					case '4': str.append("....-");break;
					case '5': str.append(".....");break;
					case '6': str.append("-....");break;
					case '7': str.append("--...");break;
					case '8': str.append("---..");break;
					case '9': str.append("----.");break;
					case ' ': str.append("  ");break;
				}
				str.append(" ");
			}
		} else if ( mode == Mode.DECODE ) {
			StringBuilder temp=new StringBuilder();
			for(int a=0;a<=input.length();a++){
				if(a==input.length()||input.charAt(a)==' '){
					if(input.charAt(a-1)==' '&&input.charAt(a+1)==' '){
						str.append(" ");		
					} else {
						switch(temp.toString()) {
							case ".-": str.append("A");break;
							case "-...": str.append("B");break;
							case "-.-.": str.append("C");break;
							case "-..": str.append("D");break;
							case ".": str.append("E");break;
							case "..-.": str.append("F");break;
							case "--.": str.append("G");break;
							case "....": str.append("H");break;
							case "..": str.append("I");break;
							case ".---": str.append("J");break;
							case "-.-": str.append("K");break;
							case ".-..": str.append("L");break;
							case "--": str.append("M");break;
							case "-.": str.append("N");break;
							case "---": str.append("O");break;
							case ".--.": str.append("P");break;
							case "--.-": str.append("Q");break;
							case ".-.": str.append("R");break;
							case "...": str.append("S");break;
							case "-": str.append("T");break;
							case "..-": str.append("U");break;
							case "...-": str.append("V");break;
							case ".--": str.append("W");break;
							case "-..-": str.append("X");break;
							case "-.--": str.append("Y");break;
							case "--..": str.append("Z");break;
							case "-----": str.append("0");break;
							case ".----": str.append("1");break;
							case "..---": str.append("2");break;
							case "...--": str.append("3");break;
							case "....-": str.append("4");break;
							case ".....": str.append("5");break;
							case "-....": str.append("6");break;
							case "--...": str.append("7");break;
							case "---..": str.append("8");break;
							case "----.": str.append("9");break;
						}
						temp.delete(0,temp.length());	
					}	
				} else {
					temp.append(Character.toString(input.charAt(a)));
				}
			}
		}
		String output=str.toString();
		return output;
	}
}
