package practicas;

import java.util.TreeSet;

public class EstructurasOrdenadas {

	public static void main(String[] args) {
		
		// TreeSet<Persona> personas = new TreeSet<>((a, b) -> a.DNI.compareTo(b.DNI));
		TreeSet<Persona> personas = new TreeSet<>((a, b) -> {
			
			int value = a.nombre.compareTo(b.nombre);
			
			if(value == 0) {
				value = a.DNI.compareTo(b.DNI);
			}
			
			return value;
		});
		
		personas.add(new Persona("1111A", "Pepe"));
		personas.add(new Persona("2222A", "Maria"));
		personas.add(new Persona("02222A", "Pepito"));
		
		System.out.println(personas);
	}
}
