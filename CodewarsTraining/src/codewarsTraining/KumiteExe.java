package codewarsTraining;

import java.util.Arrays;

public class KumiteExe {

	public static void main(String[] args) {
		powerOfPrimes(1212);
	}
	
	public static long powerOfPrimes(int num) {

	    if(num <= 0) return 0;
	    String numStr = Integer.toString(num);

	    int sumEven = 0;
	    int sumOdd = 0;
	    int exponent = 0;
	   
	    for (int i = 0; i < numStr.length(); i++) {

	      int digit = Character.getNumericValue(numStr.charAt(i));
	      
	      if(digit % 2 == 0) {
	        sumEven += digit;
	      } else {
	        sumOdd += digit;
	      }

	      int[] primes = {2, 3, 5, 7};
	      
	      if(Arrays.binarySearch(primes, digit) >= 0) {
	        exponent ++;
	      }
	      
	    }
	    
	    System.out.println((long) Math.pow(sumEven - sumOdd, exponent));
	    return (long) Math.pow(sumEven - sumOdd, exponent);
	}
}