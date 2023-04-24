package solucion;

import java.util.List;

public class VerificarCriterios {
    
    private List<Criterio> criterios;
    
    public VerificarCriterios(List<Criterio> criterios) {
        this.criterios = criterios;
    }
    
    
    public boolean cumpleCriterios(List<Object> objs) {
        int contadorCumplidos = 0;
        
        for (int i = 0; i < criterios.size(); i++) {
        	
            Criterio criterio = criterios.get(i);
            Object obj = objs.get(i);
            
            if (obj == null || !criterio.cumple(obj)) {
                return false;
            }
            
            contadorCumplidos++;
        }
        return contadorCumplidos == criterios.size();
    }
    
    
    public int cantidadCumplidos(List<Object> objs) {
        int contadorCumplidos = 0;
        
        for (int i = 0; i < criterios.size(); i++) {
        	
            Criterio criterio = criterios.get(i);
            Object obj = objs.get(i);
            
            if (obj != null && criterio.cumple(obj)) {
                contadorCumplidos++;
            }
        }
        return contadorCumplidos;
    }
}
