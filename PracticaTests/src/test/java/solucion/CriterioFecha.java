package solucion;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class CriterioFecha extends Criterio {
	
	public CriterioFecha() {
		super("fecha");
	}
	
	@Override
	public boolean cumple(Object obj) {
	    if (obj == null) {
	        return false;
	    }
	    
	    String fechaStr = (String) obj;
	    
	    try {
	        LocalDate.parse(fechaStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	        return true;
	    } catch (DateTimeParseException e) {
	        return false;
	    }
	}
}
