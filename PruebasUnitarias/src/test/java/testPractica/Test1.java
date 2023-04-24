package testPractica;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import practica.MiniCalculadora;

class Test1 {
	
	static MiniCalculadora calc;

	@BeforeAll
	static void setup() {
		calc = new MiniCalculadora();
	}
	
	@Test
	@DisplayName("Divided by zero")
	void test() {
		
		Integer result = new MiniCalculadora().add(1, 2);
		assertEquals(3, result);
		
		Long result2 = ((long)Integer.MAX_VALUE)*2;
		assertEquals(result2, 
				new MiniCalculadora().add(Integer.MAX_VALUE, Integer.MAX_VALUE));
	}
	
	@Test
	@DisplayName("Test nulidad")
	void test2() {
		
		assertEquals(null, calc.add(null,3));
	}
	
}
