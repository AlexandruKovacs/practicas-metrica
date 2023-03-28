package solucion;

public class CriterioPar extends Criterio {
	
    public CriterioPar() {
        super("par");
    }

    @Override
    public boolean cumple(Object obj) {
    	
        if (obj == null) {
            return false;
        }
        
        return (int) obj % 2 == 0;
    }
}
