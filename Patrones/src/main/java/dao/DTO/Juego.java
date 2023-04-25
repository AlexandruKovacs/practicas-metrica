package dao.DTO;

public class Juego {

	private String nombre;
	private int numJugadores;
	private String genero;
	
	public Juego(String nombre, int numJugadores, String genero) {
		super();
		this.nombre = nombre;
		this.numJugadores = numJugadores;
		this.genero = genero;
	}


	public String getNombre() {
		return nombre;
	}

	public int getNumJugadores() {
		return numJugadores;
	}

	public String getGenero() {
		return genero;
	}
	
	
}
