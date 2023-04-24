package singleton;

public class Composite {

	public static void main(String[] args) {
		
		ArbolGenealogico<Persona> trastamara = new ArbolGenealogico<Persona>(new Persona("Juan II"));
		ArbolGenealogico<Persona> primeraGeneracion = trastamara.add(new Persona("Isabel La Católica"));
		
		primeraGeneracion.add(new Persona("El que murió"));
		primeraGeneracion.add(new Persona("Catalina"));
		primeraGeneracion.add(new Persona("Juana")).add(new Persona("Carlos I"));
		
		imprimir(trastamara, 0);
	}
	
	
	private static void imprimir(ArbolGenealogico<Persona> raiz, int prof) {
		System.out.println(raiz.getElement());
		
		for(ArbolGenealogico<Persona> actual : raiz) {
			
			for(int i = 0; i < prof; i++) {
				System.out.print("\t");
			}
			
			imprimir(actual, prof + 1);
		}
	}
}

