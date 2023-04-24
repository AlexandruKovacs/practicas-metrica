package tests;

import org.junit.jupiter.api.Test;

import ejercicios.CityDistances;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCityDistances {

	@Test
	void testDistanceMadridBarcelona() {
		assertEquals(625, CityDistances.getDistance("Madrid", "Barcelona"));
	}
	
	@Test
	void testDistanceMadridCoruna() {
		assertEquals(607, CityDistances.getDistance("Madrid", "Coruña"));
	}
	
	@Test
	void testDistanceBarcelonaValencia() {
		assertEquals(309, CityDistances.getDistance("Barcelona", "Valencia"));
	}
	
	@Test
	void testDistanceBarcelonaCoruna() {
		assertEquals(975, CityDistances.getDistance("Barcelona", "Coruña"));
	}
	
}
