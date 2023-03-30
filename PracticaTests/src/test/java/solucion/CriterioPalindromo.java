package solucion;

public class CriterioPalindromo extends Criterio {
	
    public CriterioPalindromo() {
        super("palindromo");
    }

	@Override
	public boolean cumple(Object obj) {
		 
		if (obj == null) {
			return false;
		}
        
        String cadena = (String) obj;
        
        cadena = cadena.replaceAll("\\s", "").toLowerCase();
        String cadenaInvertida = new StringBuilder(cadena).reverse().toString();
        
        return cadena.equals(cadenaInvertida);
    }
}