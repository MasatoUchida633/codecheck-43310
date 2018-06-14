package codecheck;

public class App {
	public static void main(String[] args) {
//		for (int i = 0, l = args.length; i < l; i++) {
//			String output = String.format("argv[%s]: %s", i, args[i]);
//			System.out.println(output);
//		}
		
		String subCommand = args[0];
		String number = args[1];
		
		if ("encode".equals(subCommand)) {
			System.out.println(encode(number));
		}
		
		if ("decode".equals(subCommand)) {
			System.out.println(decode(number, 0));
		}
		
		if ("align".equals(subCommand)) {
			System.out.println(align(number));
		}
	}
	
	private static String encode(String decimalNumber) {
		long number = Long.parseLong(decimalNumber);
		long quotient = number/9;
		long remainder = number%9;
		
		if (quotient == 0) {
			return toAlphabet(remainder);
		}
		
		return encode(String.valueOf(quotient)) + toAlphabet(remainder);
	}
	
	private static String toAlphabet(long number) {
		String alphabet;
		
		if (number == 0) {
			alphabet = "A";
		} else if (number == 1) {
			alphabet = "B";
		} else if (number == 2) {
			alphabet = "C";
		} else if (number == 3) {
			alphabet = "D";
		} else if (number == 4) {
			alphabet = "E";
		} else if (number == 5) {
			alphabet = "F"; 
		} else if (number == 6) {
			alphabet = "G";
		} else if (number == 7) {
			alphabet = "H";
		} else if (number == 8) {
			alphabet = "I";
		} else {
			alphabet = "";
		}
		
		return alphabet;
		
	}
	
	private static long decode(String alphabetNumber, int square) {
		if (alphabetNumber.length() == 1) {
			return toNumber(alphabetNumber)*(long)Math.pow(9, square);
		}
		
		String endAlphabet = alphabetNumber.substring(alphabetNumber.length()-1);
		String otherAlphabet = alphabetNumber.substring(0, alphabetNumber.length()-1);
		
		return decode(otherAlphabet, square + 1) + toNumber(endAlphabet)*(long)Math.pow(9, square);
	}
	
	private static long toNumber(String alphabet) {
		long number;
		
		if ("A".equals(alphabet)) {
			number = 0;
		} else if ("B".equals(alphabet)) {
			number = 1;
		} else if ("C".equals(alphabet)) {
			number = 2;
		} else if ("D".equals(alphabet)) {
			number = 3;
		} else if ("E".equals(alphabet)) {
			number = 4;
		} else if ("F".equals(alphabet)) {
			number = 5; 
		} else if ("G".equals(alphabet)) {
			number = 6;
		} else if ("H".equals(alphabet)) {
			number = 7;
		} else if ("I".equals(alphabet)) {
			number = 8;
		} else {
			number = 0;
		}
		
		return number;
	}
	
	private static String align (String alphabetNumber) {
		
		return "1";
	}
}
