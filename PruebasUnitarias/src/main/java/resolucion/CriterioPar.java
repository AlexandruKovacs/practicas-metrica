package resolucion;

public class CriterioPar extends Criterio<String> {

	@Override
	public boolean cumple(String valor) {
		if(valor == null) return false;
		return false;
		
		// return valor % 2 == 0;
	}

}
