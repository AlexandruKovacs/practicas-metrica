package practicas;

import java.util.ArrayList;
import java.util.Comparator;

public class OrdenacionListas {

	public static void main(String[] args) {
		
		ArrayList<Persona> personas = new ArrayList<>();
		personas.add(new Persona("1111A", "Pepe"));
		personas.add(new Persona("2222A", "Maria"));
		personas.add(new Persona("02222A", "Pepito"));
		
		System.out.println(personas);
		
		personas.sort(new OrdenacionListas.ComparadorNombre());
		System.out.println(personas);
		
		personas.sort(new OrdenacionListas.ComparadorDNI());
		System.out.println(personas);

	}
	
	static class ComparadorNombre implements Comparator<Persona>{

		@Override
		public int compare(Persona o1, Persona o2) {
			return o1.nombre.compareTo(o2.nombre);
		}
		
	}
	
	static class ComparadorDNI implements Comparator<Persona>{

		@Override
		public int compare(Persona o1, Persona o2) {
			return o1.DNI.compareTo(o2.DNI);
		}
		
	}
}
