import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import junit.framework.TestCase;
import solucion.Criterio;
import solucion.CriterioDNI;
import solucion.CriterioFecha;
import solucion.CriterioListaNoNulos;
import solucion.CriterioMatricula;
import solucion.CriterioPalindromo;
import solucion.CriterioPar;


class Test1 extends TestCase {

	private Criterio c1;
	private Criterio c2;
	private Criterio c3;
	private Criterio c4;
	private Criterio c5;
	private Criterio c6;
	
	@BeforeEach
	void setup() {
		c1 = Criterio.get("par");
		c2 = Criterio.get("palindromo");
		c3 = Criterio.get("listaNoNulos");
		c4 = Criterio.get("dni");
		c5 = Criterio.get("matricula");
		c6 = Criterio.get("fecha");
	}
	
	@Test
	@Tag("UnitTest")
	void testIgualdad() {
		assertEquals(c1, c1);
		assertEquals(c1, Criterio.get("par"));
		assertEquals(c2, Criterio.get("palindromo"));
		assertEquals(c3, Criterio.get("listaNoNulos"));
		assertEquals(c4, Criterio.get("dni"));
		assertEquals(c5, Criterio.get("matricula"));
		assertEquals(c6, Criterio.get("fecha"));
		assertNotEquals(c1, Criterio.get("listaNoNulos"));
		assertNull(Criterio.get("noExiste"));
		assertNotEquals(c1, c2);
	}

	@Test
	@Tag("UnitTest")
	void testConsistencia() {
		assertEquals(CriterioPar.class.getName(), c1.toString());
		assertEquals(CriterioPalindromo.class.getName(), c2.toString());
		assertEquals(CriterioListaNoNulos.class.getName(), c3.toString());
		assertEquals(CriterioDNI.class.getName(), c4.toString());
		assertEquals(CriterioMatricula.class.getName(), c5.toString());
		assertEquals(CriterioFecha.class.getName(), c6.toString());
		assertTrue(c1.cumple(32));
		c1 = c2;
		assertEquals(c1, c2);
		
		try {
			c1.cumple(32);
			fail();
		} catch(ClassCastException e) {
			
		}
		
	}
	
	@Test
	@Tag("UnitTest")
	void testPalindromo() {
		assertTrue(c2.cumple("dabale arroz a la zorra el abad"));
		assertFalse(c2.cumple("dabale arroz al abad la zorra"));
	}
	
	@Test
	@Tag("UnitTest")
	void testListaNoNula() {
		List<String> lista = List.of("hola","que", "tal");
		assertTrue(c3.cumple(lista));
		lista = new ArrayList<>();
		assertTrue(c3.cumple(lista));
		for(int i=0; i< 100; i++) lista.add("palabra");
		assertTrue(c3.cumple(lista));
		lista.add(30, null);
		assertTrue(!c3.cumple(lista));
	}
	
	@Test
	@Tag("UnitTest")
	void testParidad() {
		assertTrue(c1.cumple(10));
		assertFalse(c1.cumple(5));
		assertFalse(c1.cumple(null));
		assertTrue(c1.cumple(-50));
	}
	
	@Test
	@Tag("UnitTest")
	void testDni() {
		assertTrue(c4.cumple("01234567C"));
		assertFalse(c4.cumple("0123567X"));
		assertFalse(c4.cumple(null));
		assertFalse(c4.cumple("01234567U"));
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
	
}
