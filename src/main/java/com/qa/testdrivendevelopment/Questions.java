package com.qa.testdrivendevelopment;

import java.util.HashSet;
import java.util.Set;

public class Questions {

	/**
	 * EXAMPLE: THIS ONE HAS BEEN DONE FOR YOU <br>
	 * 
	 * Given a name, return "Hi" plus the name <br>
	 * <br>
	 * For Example:<br>
	 * greetingExample("John") → "Hi John" <br>
	 * greetingExample("Matt") → "Hi Matt" <br>
	 * greetingExample("Angelica") → "Hi Angelica"
	 * 
	 */
	public String greetingExample(String name) {
		return "Hi " + name;
	}

	/**
	 * Given a string, return a string where for every char in the original string,
	 * there are three chars.<br>
	 * <br>
	 * 
	 * For Example:<br>
	 * multChar("The") → "TTThhheee"<br>
	 * multChar("AAbb") → "AAAAAAbbbbbb"<br>
	 * multChar("Hi-There") → "HHHiii---TTThhheeerrreee"
	 */
	public String multiChar(String input) {
		
		String w = "";
		for (int i = 0; i < input.length(); i++) {
			w = w + input.substring(i, i + 1);
			w = w + input.substring(i, i + 1);
			w = w + input.substring(i, i + 1);
		}
		return w;
	}

	/**
	 * Return the string (backwards) that is between the first and last appearance
	 * of "bread" in the given string, or return the empty string "" if there is not
	 * 2 occurances of "bread". Ignore Case<br>
	 * <br>
	 * For Example: sandwichFilling("breadclivebread") → "evilc"<br>
	 * sandwichFilling("xxbreadfridgebreadyy") → "egdirf"<br>
	 * sandwichFilling("xxBreadfridgeBReAdyy") → "egdirf"<br>
	 * sandwichFilling("xxbreadyy") → "" sandwichFilling("xxbreADyy") → ""<br>
	 * <br>
	 * HINT: "a" == "a" if false HINT: "a".equals("a") is true
	 */

	public String sandwichFilling(String sandwich) {
		/*
		String str = "bread";
		// get first word
		int firstSpacePosition = str.indexOf("bread");
		//String firstWord = str.substring(0, firstSpacePosition); // bread

		// get last word
		//String lastWord = str.substring(str.lastIndexOf(" ") + 1); // bread
		*/
		
		String c = sandwich;
		if (sandwich.toLowerCase().contains("bread")) {
			c = c.substring(c.toLowerCase().indexOf("bread") + 5, c.length());
			if (c.contains("bread")) { // 2 slices of bread
				sandwich = sandwich.substring(0, sandwich.toLowerCase().lastIndexOf("bread"));
				sandwich = sandwich.substring(sandwich.toLowerCase().indexOf("bread") + 5, sandwich.length());
				sandwich = new StringBuilder(sandwich).reverse().toString();
			}
		}
		return sandwich;
	}

	/**
	 * Given three ints, a b c, one of them is small, one is medium and one is
	 * large. Return true if the three values are evenly spaced, so the difference
	 * between small and medium is the same as the difference between medium and
	 * large. Do not assume the ints will come to you in a reasonable order.<br>
	 * <br>
	 * For Example:<br>
	 * evenlySpaced(2, 4, 6) → true<br>
	 * evenlySpaced(4, 6, 2) → true<br>
	 * evenlySpaced(4, 6, 3) → false<br>
	 * evenlySpaced(4, 60, 9) → false
	 */
	public boolean evenlySpaced(int a, int b, int c) {

		int large = Math.max(a, Math.max(b, c));
		int small = Math.min(a, Math.min(b, c));
		int medium = (a + b + c) - (large + small);

		return ((large - medium) == (medium - small));

	}

	/**
	 * Given a string and an int n, return a string that removes n letters from
	 * the'middle' of the string. The string length will be at least n. The input
	 * string will have an odd number of letters. n will always be an odd
	 * number.<br>
	 * <br>
	 * For Example:<br>
	 * nMid("Hello", 3) → "Ho"<br>
	 * nMid("Chocolate", 3) → "Choate"<br>
	 * nMid("Chocolate", 1) → "Choclate"<br>
	 */
	public String nMid(String input, int n) {
		/*  n = input.length();
		  String start = input.substring(0, n);
		  String end = input.substring((n) + 1 , input.length());
		  String result = start + end;
		  return result;
		  */
		  int x = input.length();
	    int y = Math.round(x/2);
	    	
			String c = input.substring(0,y-1);
			//System.out.println(c);
			String d = input.substring((y-1+n), (x));
	    	//System.out.println(d);
			return c+d;
		
	}

	/**
	 * Given a string, return the boolean True if it ends in "java" and False if
	 * does not end in "java". Ignore Case.<br>
	 * <br>
	 * For Example: <br>
	 * endsJava("ilovejava") → true <br>
	 * endsJava("iloveJaVa") → true <br>
	 * endsJava("welovejava") → true <br>
	 * endsJava("welovejavamoreeveryday") → false <br>
	 * endsJava("javaiscool") → false <br>
	 * endsJava("pythoniscool") → false <br>
	 */
	public boolean endsJava(String input) {
		//String keyword = "java";
		boolean c = false;
		if(input.toLowerCase().contains("java")) {
			if (input.toLowerCase().subSequence(input.length()-4, input.length()).equals("java")) {
				c = true;
			}
		} 
		return c;
	}

	/**
	 * Given a string, return the length of the largest "block" in the string. A
	 * block is a run of adjacent chars that are the same, do not ignore case.<br>
	 * <br>
	 * For Example: superBlock("hooopplla") → 3 <br>
	 * superBlock("abbCCCddDDDDeeEEE") → 4 <br>
	 * superBlock("abbCCCCC")) → 5 <br>
	 * superBlock("") → 0 <br>
	 * <br>
	 * HINT: "a" == "a" if false HINT: "a".equals("a") is true
	 */
	public int superBlock(String input) {
		int max = 0;
		int count = 0;
        
		for(int i = 0; i < input.length() - 1; i++) {
			for(int x = 0; x < input.length(); x++) {
				if(input.charAt(i) == input.charAt(x)) {
					count = count +1;
					if(count > max)
						max = count;
				} else {
					count = 0;
				}
			}
		}
    	return max;
	}

	/**
	 * Given a string - return the number of times "am" appears in the String
	 * ignoring case - BUT ONLY WHEN the word "am" appears without being followed or
	 * preceded by other letters <br>
	 * <br>
	 * For Example: <br>
	 * amISearch("Am I in Amsterdam") → 1 <br>
	 * amISearch("I am in Amsterdam am I?") → 2 <br>
	 * amISearch("I have been in Amsterdam") → 0 <br>
	 * <br>
	 * HINT: String.toLowerCase
	 */
	public int amISearch(String sentence) {
		if(sentence.equals("")) {
			return 0;
		} else {
		//sentence = sentence.toLowerCase();
		String find = "am";
		int lastIndex = 0;
		int count = 0;

		while(lastIndex != -1){

		    lastIndex = sentence.indexOf(find,lastIndex);

		    if(lastIndex != -1){
		        count ++;
		        lastIndex += find.length();
		    }
		}
		return count;
		}	}

	/**
	 * Given a number if this number is divisible by 3 return "fizz" if this number
	 * is divisible by 5 return "buzz" if this number is divisible by both 3 and 5
	 * return "fizzbuzz" if this number is not divisible by 3 or 5 return null<br>
	 * <br>
	 * For Example: <br>
	 * fizzBuzz(3) → "fizz" <br>
	 * fizzBuzz(10) → "buzz" <br>
	 * fizzBuzz(15) → "fizzbuzz" <br>
	 * fizzBuzz(8) → null
	 */
	public String fizzBuzz(int number) {
		String s = "";
		if(number%3==0) {s += "fizz";}
		if(number%5==0) {s+="buzz";}
		if(s.contentEquals("")) {s = null;}
    	return s;
	}

	/**
	 * Given a string, split the string into the individual numbers present then add
	 * each digit of each number to get a final value for each number <br>
	 * <br>
	 * String example = "55 72 86"<br>
	 * <br>
	 * "55" will = the integer 10 <br>
	 * "72" will = the integer 9 <br>
	 * "86" will = the integer 14 <br>
	 * <br>
	 * You then need to return the highest vale <br>
	 * <br>
	 * For Example: <br>
	 * largest("55 72 86") → 14 <br>
	 * largest("15 72 80 164") → 11 <br>
	 * largest("555 72 86 45 10") → 15 <br>
	 * <br>
	 * HINT: Integer.parseInt
	 */

	public int largest(String input) {
		return -1;
	}

	/**
	 * Given a string, int and a char, return a boolean value if the 'nth'
	 * (represented by the int provided) char of the String supplied is the same as
	 * the char supplied. The int provided will NOT always be less than than the
	 * length of the String. Ignore case and Whitespace. <br>
	 * <br>
	 * For Example: <br>
	 * compares("The",2,'h') → true <br>
	 * compares("AAbb",1,'b') → false <br>
	 * compares("Hi-There",10,'e') → false <br>
	 * <br>
	 * HINT: String.charAt
	 */
	public boolean compares(String word, int index, char letter) {
		boolean result = false;
		if (word.length() > index) {
			if(word.charAt(index) != letter) {
				result = true;
			}
		} else {
			result = false;
		}
		return result;
	}
}
