package codewarsTraining;

public class CamelCase {

	public static String toCamelCase(String s) {
		
		String guion = "-";
		String barraBaja = "_";
		String parts[] = null;
		
		if(guion.equals("-")) {
	        parts = s.split("\\"+guion);   
		} else if (barraBaja.equals("_")) {
			parts = s.split("\\"+barraBaja);
		}
		
		for(String part : parts) {
			
			System.out.println(part);
			
		}
		
		return barraBaja;
	}
}