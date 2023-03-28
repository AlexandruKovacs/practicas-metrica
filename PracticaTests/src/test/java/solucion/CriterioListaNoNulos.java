package solucion;
import java.util.List;
import java.util.Objects;

public class CriterioListaNoNulos extends Criterio {
	
    public CriterioListaNoNulos() {
        super("listaNoNulos");
    }

    @Override
    public boolean cumple(Object obj) {
        
        List<?> lista = (List<?>) obj;
        
        return lista.stream().allMatch(Objects::nonNull);
    }
}