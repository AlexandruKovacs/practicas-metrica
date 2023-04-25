package chain;

import java.util.HashMap;
import java.util.Map;

public class Persona implements ChainOfResponsability {

	private String nombre;
	private String dni;
	
	public Persona(String nombre, String dni) {
		super();
		this.nombre = nombre;
		this.dni = dni;
	}

	public Map<String, String> toMap() {
		Map<String, String> atributes = new HashMap<String, String>();
		atributes.put("nombre", nombre);
		atributes.put("dni", dni);
		
		return atributes;
	}
}

class Empleado extends Persona {
	
	private float sueldo;
	
	public Empleado(String nombre, String dni, float sueldo) {
		super(nombre, dni);
		this.sueldo = sueldo;
	}

	public Map<String, String> toMap() {
		Map<String, String> att = super.toMap();
		att.put("sueldo", String.valueOf(sueldo));
		
		return att;
	}
}

class Comercial extends Empleado {
	
	private int comision;
	
	public Comercial(String nombre, String dni, float sueldo, int comision) {
		super(nombre, dni, sueldo);
		this.comision = comision;
	}

	public Map<String, String> toMap() {
		Map<String, String> att = super.toMap();
		att.put("comision", String.valueOf(comision));
		
		return att;
	}
}

interface ChainOfResponsability {
	
	public Map<String, String> toMap();
}
