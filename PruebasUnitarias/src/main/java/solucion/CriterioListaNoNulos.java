package solucion;

import java.util.List;

public class CriterioListaNoNulos extends Criterio {
	
    public CriterioListaNoNulos() {
        super("listaNoNulos");
    }

    @Override
    public boolean cumple(Object obj) {
    	
        if (obj == null) {
            return false;
        }

        List<?> lista = (List<?>) obj;

        for (Object elemento : lista) {
            if (elemento == null) {
                return false;
            }
        }
        return true;
    }
}