package resolucion.builder;

import resolucion.Criterio;

public abstract class CriterioBuilder<T> {
	
	public abstract Criterio<T> build();
	
}
