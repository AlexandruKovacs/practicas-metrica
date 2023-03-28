package solucion;

public abstract class Criterio {
	
    protected Criterio(String nombre) {};

    @Override
    public boolean equals(Object obj) {
    	
	    if (obj.getClass() == this.getClass()) {
	    	return true;
	    }
	    
	    return false;
    }

    @Override
    public String toString() {
        return getClass().getName();
    }

    public static Criterio get(String nombre) {
    	
        switch (nombre) {
            case "par":
                return new CriterioPar();
            case "palindromo":
                return new CriterioPalindromo();
            case "listaNoNulos":
                return new CriterioListaNoNulos();
            case "dni":
            	return new CriterioDNI();
            case "matricula":
            	return new CriterioMatricula();
            case "fecha":
            	return new CriterioFecha();
            case "noExiste":
            	return null;
            default:
                return null;
        }
    }
    
    public abstract boolean cumple(Object obj);
}
