package resolucion.builder;

import resolucion.Criterio;
import resolucion.CriterioPalindromo;

public class PalindromoBuilder extends CriterioBuilder<String> {

	public Criterio<String> build() {
		return new CriterioPalindromo();
		
	}
}
