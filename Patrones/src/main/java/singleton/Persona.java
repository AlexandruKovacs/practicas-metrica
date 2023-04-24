package singleton;

public class Persona {

	private String nombre;

	public Persona(String nombre) {
		super();
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return nombre;
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
}
