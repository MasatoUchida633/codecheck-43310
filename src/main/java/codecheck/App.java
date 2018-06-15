package codecheck;

import java.math.BigInteger;

public class App {
	private static final BigInteger TWO = new BigInteger("2");
	private static final BigInteger THREE = new BigInteger("3");
	private static final BigInteger FOUR = new BigInteger("4");
	private static final BigInteger FIVE = new BigInteger("5");
	private static final BigInteger SIX = new BigInteger("6");
	private static final BigInteger SEVEN = new BigInteger("7");
	private static final BigInteger EIGHT = new BigInteger("8");
	private static final BigInteger NINE = new BigInteger("9");
	
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
			System.out.println(decode(number, 0).toString());
		}
		
		if ("align".equals(subCommand)) {
			System.out.println(align(number));
		}
	}
	
	private static String encode(String decimalNumber) {
		BigInteger number = new BigInteger(decimalNumber);
		BigInteger quotient = number.divide(NINE);
		BigInteger remainder = number.remainder(NINE);
		
		if (quotient.equals(BigInteger.ZERO)) {
			return toAlphabet(remainder);
		}
		
		return encode(quotient.toString()) + toAlphabet(remainder);
	}
	
	private static String toAlphabet(BigInteger number) {
		String alphabet;
		
		if (number.equals(BigInteger.ZERO)) {
			alphabet = "A";
		} else if (number.equals(BigInteger.ONE)) {
			alphabet = "B";
		} else if (number.equals(TWO)) {
			alphabet = "C";
		} else if (number.equals(THREE)) {
			alphabet = "D";
		} else if (number.equals(FOUR)) {
			alphabet = "E";
		} else if (number.equals(FIVE)) {
			alphabet = "F"; 
		} else if (number.equals(SIX)) {
			alphabet = "G";
		} else if (number.equals(SEVEN)) {
			alphabet = "H";
		} else if (number.equals(EIGHT)) {
			alphabet = "I";
		} else {
			alphabet = "";
		}
		
		return alphabet;
		
	}
	
	private static BigInteger decode(String alphabetNumber, int square) {
		BigInteger rank;
		if (square == 0) {
			rank = BigInteger.ONE;
		} else {
			rank = NINE.pow(square);
		}
		
		if (alphabetNumber.length() == 1) {
			return toNumber(alphabetNumber).multiply(rank);
		}
		
		String endAlphabet = alphabetNumber.substring(alphabetNumber.length()-1);
		String otherAlphabet = alphabetNumber.substring(0, alphabetNumber.length()-1);
		
		BigInteger decodeNumber = toNumber(endAlphabet).multiply(rank);
		return decode(otherAlphabet, square + 1).add(decodeNumber);
	}
	
	private static BigInteger toNumber(String alphabet) {
		BigInteger number;
		
		if ("A".equals(alphabet)) {
			number = BigInteger.ZERO;
		} else if ("B".equals(alphabet)) {
			number = BigInteger.ONE;
		} else if ("C".equals(alphabet)) {
			number = TWO;
		} else if ("D".equals(alphabet)) {
			number = THREE;
		} else if ("E".equals(alphabet)) {
			number = FOUR;
		} else if ("F".equals(alphabet)) {
			number = FIVE; 
		} else if ("G".equals(alphabet)) {
			number = SIX;
		} else if ("H".equals(alphabet)) {
			number = SEVEN;
		} else if ("I".equals(alphabet)) {
			number = EIGHT;
		} else {
			number = BigInteger.ZERO;
		}
		
		return number;
	}
	
	private static String align (String alphabetNumber) {
		String sum = getSum(alphabetNumber, new StringBuilder("H"));
		
		BigInteger decimalNumber = decode(alphabetNumber, 0);
		BigInteger sumNumber = decode(sum, 0);
		BigInteger addNumber = sumNumber.subtract(decimalNumber);
		
		StringBuilder answer = new StringBuilder(alphabetNumber).append(" + ").
				append(encode(addNumber.toString())).
				append(" = ")
				.append(sum);
		return answer.toString();
	}
	
	private static String getSum(String alphabetNumber, StringBuilder sum) {
		BigInteger decimalNumber = decode(alphabetNumber, 0);
		BigInteger sumNumber = decode(sum.toString(), 0);
		
		if (decimalNumber.compareTo(sumNumber) <= 0) {
			return sum.toString();
		}
		
		return getSum(alphabetNumber, sum.append("H"));
	}
}
