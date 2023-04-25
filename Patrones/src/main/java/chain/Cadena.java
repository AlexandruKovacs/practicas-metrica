package chain;

public class Cadena {

	public static void main(String[] args) {
		
		Comercial c1 = new Comercial("Alex", "123456789", 1000, 10);
		System.out.println(c1.toMap());
		
		Empleado e1 = new Empleado("Pepe", "123456789", 10);
		System.out.println(e1.toMap());
		
		Persona c2 = new Comercial("David", "123456789", 2500, 4);
		System.out.println(c2.toMap());
		
		Persona p1 = (Persona) e1;
		System.out.println(p1.toMap());
		
	}
}
