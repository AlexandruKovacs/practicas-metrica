package practicas;

public class Persona implements Comparable<Persona> { // POJO
	
	String DNI;
	String nombre;
	String municipio;
	
	public Persona(String dni, String nombre) {
		super();
		DNI = dni;
		this.nombre = nombre;
	}

	@Override
	public int compareTo(Persona o) {
		return DNI.compareTo(o.DNI);
	}

	@Override
	public String toString() {
		return "Persona [DNI=" + DNI + ", nombre=" + nombre + "]";
	}
}