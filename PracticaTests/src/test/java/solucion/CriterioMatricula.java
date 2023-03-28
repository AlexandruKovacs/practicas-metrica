package solucion;

import java.util.regex.Pattern;

public class CriterioMatricula extends Criterio {

	public CriterioMatricula() {
		super("matricula");
	}
	
	@Override
	public boolean cumple(Object obj) {
		
		if (obj == null) {
			return false;
		}
		
		String matricula = (String) obj;
		String matriculaRegExp = "[0-9]{4}[BCDFGHJKLMNPRSTVWXYZ]{3}";
		
		return Pattern.matches(matriculaRegExp, matricula);
	}
}
