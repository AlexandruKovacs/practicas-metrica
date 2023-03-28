package solucion;

import java.util.regex.Pattern;

public class CriterioDNI extends Criterio {
	
	 public CriterioDNI() {
		 super("dni");
	 }
	 
	 @Override
	 public boolean cumple(Object obj) {
		
		if (obj == null) {
		    return false;
		}
		
		String dni = (String) obj;
		String dniRegExp = "[0-9]{8}[A-HJ-NP-TV-Z]";
		
		return Pattern.matches(dniRegExp, dni);
		
	 }
}
