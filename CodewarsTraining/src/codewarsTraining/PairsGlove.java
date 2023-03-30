package codewarsTraining;

import java.util.HashMap;

public class PairsGlove {
	public static int numberOfPairs(String[] gloves) {
		  
	    HashMap<String, Integer> colorsCount = new HashMap<>();
	  
	    for (String color : gloves) {
	      
	        if (colorsCount.containsKey(color)) {
	            colorsCount.put(color, colorsCount.get(color) + 1);
	        } else {
	            colorsCount.put(color, 1);
	        }
	      
	    }
	    int pairsCount = 0;
	  
	    for (int colorCount : colorsCount.values()) {
	        pairsCount += colorCount / 2;
	    }
	  
	    return pairsCount;
	}

}
