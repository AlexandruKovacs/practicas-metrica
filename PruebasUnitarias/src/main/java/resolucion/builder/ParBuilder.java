package resolucion.builder;

import resolucion.Criterio;
import resolucion.CriterioPar;

public class ParBuilder extends CriterioBuilder<String> {

	public Criterio<String> build() {
		return new CriterioPar();
	}
}