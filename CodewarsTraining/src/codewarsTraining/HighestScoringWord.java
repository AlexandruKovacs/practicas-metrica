package codewarsTraining;

import java.util.Arrays;

public class HighestScoringWord {
	public static String high(String s) {
		
		String[] strSplit = s.split("//s");
	    System.out.printf("%s => %d%n", Arrays.toString(strSplit), maxString(strSplit));
		
	    return "";
	}
	
	static int sumString(final String str) {
		
	    int sum = 0;
	    
	    for (char ch : str.toCharArray()) {
	        if (ch >= 'A' && ch <= 'Z') {
	            sum += 1 + ch - 'A';
	        }
	    }
	    return sum;
	}
	
	static int maxString(String[] arr) {
		
	    int max = sumString(arr[0]);
	    
	    for (int i = 1; i < arr.length; i++) {
	        max = Math.max(max, sumString(arr[i]));
	    }
	    return max;
	}
}
