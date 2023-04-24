package resolucion;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import resolucion.builder.CriterioBuilder;
import resolucion.builder.PalindromoBuilder;
import resolucion.builder.ParBuilder;

public abstract class Criterio <T> {
	
	private static Map<String, CriterioBuilder> factory = new HashMap<String, CriterioBuilder>() {
		{
			put("palindromo", new PalindromoBuilder());
			put("par", new ParBuilder());
		}
	};
	
	public static Criterio<?> get(String type) {
		
		if(!factory.containsKey(type)) return null;
		
		return factory.get(type).build();
	}
	
	
	
	@Override
	public boolean equals(Object obj) {
		
		if(this == obj) return true;
		if(obj == null) return false;
		if(this.getClass() !=  obj.getClass()) return false;
		
		/* Criterio other = (Criterio) obj;
		
		if(this.type != other.type) return false; */
		
		return true;
	}

	@Override
	public String toString() {
		
		
		return super.toString();
	}

	public boolean cumple(List<T> valor) {
		for (T value: valor) {
			if(!this.cumple(value)) return false;
		}
		return false;
	}
	
	public abstract boolean cumple(T valor);
}
