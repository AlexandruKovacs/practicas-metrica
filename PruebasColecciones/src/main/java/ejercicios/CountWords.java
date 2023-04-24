package ejercicios;

import java.util.HashMap;
import java.util.Map;

public class CountWords {
	
	public static Map<String, Integer> countWords(String text) {

		Map<String, Integer> hashMap = new HashMap<>();
		String[] words = text.split(" ");

		if("".equals(text)) {
			return hashMap;
		}
		
		for (String word : words) {
			
			Integer actual = hashMap.getOrDefault(word, 0);
			hashMap.put(word, actual + 1);
			
			if (actual == 0) {
				hashMap.put(word, 1);
			} else {
				hashMap.put(word, actual + 1);
			}
		}
		
		return hashMap;
	}
}