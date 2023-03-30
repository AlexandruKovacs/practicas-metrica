package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import solucion.Criterio;
import solucion.CriterioDNI;
import solucion.CriterioFecha;
import solucion.CriterioMatricula;
import solucion.VerificarCriterios;

class Test2 {

	private Criterio c4;
	private Criterio c5;
	private Criterio c6;
	
	@BeforeEach
	void setup() {
		c4 = Criterio.get("dni");
		c5 = Criterio.get("matricula");
		c6 = Criterio.get("fecha");
	}
	
	@Test
	@Tag("UnitTest")
	void testIgualdad() {
		assertEquals(c4, Criterio.get("dni"));
		assertEquals(c5, Criterio.get("matricula"));
		assertEquals(c6, Criterio.get("fecha"));
	}

	@Test
	@Tag("UnitTest")
	void testConsistencia() {
		assertEquals(CriterioDNI.class.getName(), c4.toString());
		assertEquals(CriterioMatricula.class.getName(), c5.toString());
		assertEquals(CriterioFecha.class.getName(), c6.toString());
	}
	
	@Test
	@Tag("UnitTest")
	void testDNI() {
		assertTrue(c4.cumple("01234567C"));
		assertFalse(c4.cumple("0123567X"));
		assertFalse(c4.cumple(null));
		assertFalse(c4.cumple("01234567U"));
		assertFalse(c4.cumple("A01234567R"));
	}
	
	@Test
	@Tag("UnitTest")
	void testMatricula() {
		assertTrue(c5.cumple("5643JXS"));
		assertFalse(c5.cumple("1111AAA"));
		assertFalse(c5.cumple(null));
		assertFalse(c5.cumple("3425III"));
	}
	
	@Test
	@Tag("UnitTest")
	void testFecha() {
		assertTrue(c6.cumple("27/03/2023"));
		assertFalse(c6.cumple("35/35/3535"));
		assertFalse(c6.cumple(null));
		assertFalse(c6.cumple("00-00-0000"));
	}
	
	@Test
	@Tag("UnitTest")
	void testCumpleTodosLosCriterios() {
	    
        List<Criterio> criterios = new ArrayList<>();
        criterios.add(c4);
        criterios.add(c5);
        criterios.add(c6);

	    VerificarCriterios verificador = new VerificarCriterios(criterios);
	    
	    List<Object> objeto1 = new ArrayList<>();
	    objeto1.add("01234567C");
	    objeto1.add("5454JXS");
	    objeto1.add("27/03/2023");
	    
	    assertTrue(verificador.cumpleCriterios(objeto1));
	    
	    List<Object> objeto2 = new ArrayList<>();
	    objeto2.add("000000000");
	    objeto2.add("1111AAA");
	    objeto2.add("35/35/3535");
	    
	    assertFalse(verificador.cumpleCriterios(objeto2));
	}
	
    @Test
    @Tag("UnitTest")
    void testCantidadCumplidos() {
    	
        List<Criterio> criterios = new ArrayList<>();
        criterios.add(c4);
        criterios.add(c5);
        criterios.add(c6);
        
        VerificarCriterios verificador = new VerificarCriterios(criterios);
        
        List<Object> objeto1 = new ArrayList<>();
        objeto1.add("01234567C");
        objeto1.add(null);
        objeto1.add("27/06/2000");
        
        assertEquals(2, verificador.cantidadCumplidos(objeto1));
        
        List<Object> objeto2 = new ArrayList<>();
        objeto2.add("01234567C");
        objeto2.add("5454JXS");
        objeto2.add("27/06/2023");
        
        assertEquals(3, verificador.cantidadCumplidos(objeto2));
        
        List<Object> objeto3 = new ArrayList<>();
        objeto3.add(null);
        objeto3.add("5454JXS");
        objeto3.add("35/35/3535");
        
        assertEquals(1, verificador.cantidadCumplidos(objeto3));
    }
}
