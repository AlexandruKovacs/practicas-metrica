package codewarsTraining;

import java.util.ArrayList;
import java.util.Collections;

public class SortOdd {
	
	public static int[] sortArray(int[] arr) {
	      
	    ArrayList<Integer> oddNumbers = new ArrayList<>();
	    for(int num : arr) {
	        if(num % 2 != 0) {
	            oddNumbers.add(num);
	        }
	    }
	    
	    Collections.sort(oddNumbers);
	    
	    for(int i = 0; i < arr.length; i++) {
	        if(arr[i] % 2 != 0) {
	            arr[i] = oddNumbers.remove(0);
	        }
	    }
	    return arr;
	  }
  
}
