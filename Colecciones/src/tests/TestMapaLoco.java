package tests;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import practicas.TreeMapOrdenadoValor;

public class TestMapaLoco {

	@Test
	public void test1() {
		TreeMapOrdenadoValor<Integer, String> mapaLoco = new TreeMapOrdenadoValor<>();
		mapaLoco.put(1, "zaza");
		mapaLoco.put(8, "aza");
		mapaLoco.put(3, "yaza");
		mapaLoco.put(7, "jaza");
		
		doTest(mapaLoco, new Integer[] {8, 7, 3, 1});
	}
	
	@Test
	public void testUnnusual1() {
		TreeMapOrdenadoValor<Integer, String> mapaLoco = new TreeMapOrdenadoValor<>();
		mapaLoco.put(null, "zaza");
		mapaLoco.put(8, "aza");
		mapaLoco.put(3, "yaza");
		mapaLoco.put(7, "jaza");
		
		doTest(mapaLoco, new Integer[] {8, 7, 3, null});
	}
	
	@Test
	public void testUnnusual2() {
		TreeMapOrdenadoValor<Integer, String> mapaLoco = new TreeMapOrdenadoValor<>();
		mapaLoco.put(1, "zaza");
		mapaLoco.put(8, "aza");
		mapaLoco.put(3, "yaza");
		mapaLoco.put(7, "jaza");
		mapaLoco.put(5, null);
		
		doTest(mapaLoco, new Integer[] {5, 8, 7, 3, 1});
	}
	
	@Test
	public void testAllNull() {
		TreeMapOrdenadoValor<Integer, String> mapaLoco = new TreeMapOrdenadoValor<>();
		mapaLoco.put(1, "zaza");
		mapaLoco.put(8, "aza");
		mapaLoco.put(3, "yaza");
		mapaLoco.put(7, "jaza");
		mapaLoco.put(null, null);
		
		doTest(mapaLoco, new Integer[] {null, 8, 7, 3, 1});
	}
	
	private void doTest(TreeMapOrdenadoValor<Integer, String> mapaLoco, Integer[]expected) {
		int actual = 0;
		
		for(Integer i : mapaLoco.keySet()) {
			assertEquals(expected[actual++], i);
		}
	}
}
