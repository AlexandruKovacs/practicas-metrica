package resolucion;

import java.util.List;
import java.util.Map;

public class CriterioListaCriterios extends Criterio<Map<Criterio, List<Object>>> {

	@Override
	public boolean cumple(Map<Criterio, List<Object>> valor) {
		
		for(Map.Entry<Criterio, List<Object>> pair: valor.entrySet()) {
			for(Object element : pair.getValue())
				if(!pair.getKey().cumple(element)) return false;
		}
		
		return true;
	}

}
