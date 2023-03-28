package solucion;

import java.util.regex.Pattern;

public class CriterioFecha extends Criterio {
	
	public CriterioFecha() {
		super("fecha");
	}
	
	public boolean cumple(Object obj) {
		
		if (obj == null) {
			return false;
		}
		
		String fecha = (String) obj;
		String fechaReExp = "(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)";

		return Pattern.matches(fechaReExp, fecha);
	}
}
