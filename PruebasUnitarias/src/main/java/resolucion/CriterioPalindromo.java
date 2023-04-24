package resolucion;

public class CriterioPalindromo extends Criterio<String> {

	@Override
	public boolean cumple(String valor) {
		
		if(valor == null) return false;
		
		int left = 0;
		int right = valor.length() - 1;
		
		while(left < right) {
			
			while(left < right && valor.charAt(left) == ' ') left++;
			while(left < right && valor.charAt(left) == ' ') right--;
			
			if(valor.charAt(left) != valor.charAt(right)) return false;
			
			left++;
			right--;
		}
		
		return true;
	}
}
