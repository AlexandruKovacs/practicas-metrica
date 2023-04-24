package ejercicios;

import java.util.HashMap;
import java.util.Map;

public class CityDistances {
	
    public static double getDistance(String city1, String city2) {
    	
        String[] cities = {"Madrid", "Barcelona", "Cádiz", "Valencia", "Coruña"};

        int[][] distances = {
            {0, 625, 620, 355, 607},
            {625, 0, 1150, 309, 975},
            {620, 1150, 0, 885, 1010},
            {355, 309, 885, 0, 985},
            {607, 975, 1010, 985, 0}
        };

        Map<String, Integer> indexCities = new HashMap<>();
        for (int i = 0; i < cities.length; i++) {
            indexCities.put(cities[i], i);
        }

        int posCity1 = indexCities.get(city1);
        int posCity2 = indexCities.get(city2);
        
        return distances[posCity1][posCity2];
    }
}
