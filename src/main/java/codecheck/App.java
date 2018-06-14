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
		int number = Integer.parseInt(decimalNumber);
		int quotient = number/9;
		int remainder = number%9;
		
		if (quotient == 0) {
			return toAlphabet(remainder);
		}
		
		return encode(String.valueOf(quotient)) + toAlphabet(remainder);
	}
	
	private static String toAlphabet(int number) {
		String alphabet;
		
		switch (number) {
		case 0:
			alphabet = "A";
			break;
		case 1:
			alphabet = "B";
			break;
		case 2:
			alphabet = "C";
			break;
		case 3:
			alphabet = "D";
			break;
		case 4:
			alphabet = "E";
			break;
		case 5:
			alphabet = "F";
			break;
		case 6:
			alphabet = "G";
			break;
		case 7:
			alphabet = "H";
			break;
		case 8:
			alphabet = "I";
			break;
		default:
			alphabet = "";
		}
		
		return alphabet;
		
	}
	
	private static int decode(String alphabetNumber, int square) {
		if (alphabetNumber.length() == 1) {
			return toNumber(alphabetNumber)*(int)Math.pow(9, square);
		}
		
		String endAlphabet = alphabetNumber.substring(alphabetNumber.length()-1);
		String otherAlphabet = alphabetNumber.substring(0, alphabetNumber.length()-1);
		
		return decode(otherAlphabet, square + 1) + toNumber(endAlphabet)*(int)Math.pow(9, square);
	}
	
	private static int toNumber(String alphabet) {
		int number;
		
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
