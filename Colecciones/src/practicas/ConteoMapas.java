package practicas;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;

public class ConteoMapas {

	public static void main(String[] args) {
		System.out.print(contarPalabras("hola tal estas muy bien alegro"));
	}
	
	public static void agruparPersonasPorMunicipio(List<Persona> lista) {
		
		HashMap<String, List<Persona>> agrupacion = new HashMap<>();
		
		for(Persona p: lista) {
			List<Persona> actual = agrupacion.getOrDefault(p.municipio, new LinkedList<Persona>());
			actual.add(p);
			
			agrupacion.put(p.municipio, actual);
		}
	}
	
	public static String contarPalabrasPro(String frase) {
		
		SortedMap<String, Integer> rep = new TreeMapOrdenadoValor<>();
		
		for(String palabra: frase.split("\\s+")) {
			
			Integer actual = rep.getOrDefault(palabra, 0);
			rep.put(palabra, actual + 1);
			
		}
	
		return rep.firstKey();
	}

	public static String contarPalabras(String frase) {
		
		HashMap<String, Integer> rep = new HashMap<>();
		
		for(String palabra: frase.split("\\s+")) {
			
			Integer actual = rep.getOrDefault(palabra, 0);
			rep.put(palabra, actual + 1);
			
			/* if(rep.containsKey(palabra)) {
				
				Integer value = rep.get(palabra);
				rep.put(palabra, actual + 1);
				
			} else {
				
				rep.put(palabra, 1);
			} */
		}
		
		String mejor = Collections.max(rep.keySet(), (a, b) -> rep.get(a).compareTo(rep.get(b)));
		
		/* String mejor = "";
		int opt = Integer.MIN_VALUE;
		
		for(Map.Entry<String, Integer> pareja: rep.entrySet()) {
			
			if(pareja.getValue() > opt) {
				opt = pareja.getValue();
				mejor = pareja.getKey();
			}
			
		} */
		
		return mejor; 
	}
	
	/*
	 * Nos proporcionan una cadena y se devuelve la vocal más usada
	 */
	public static Character contarVocales(String text) {
		
		int[] vocalsCount = new int[] {0,0,0,0,0};
		
		for(char c: text.toCharArray()) {
			
			switch (c) {
				case 'a': vocalsCount[0]++; break;
				case 'e': vocalsCount[1]++; break;
				case 'i': vocalsCount[2]++; break;
				case 'o': vocalsCount[3]++; break;
				case 'u': vocalsCount[4]++; break;
			}
		}
		
		int maxPos = 0;
		for(int i = 1; i < vocalsCount.length; i++) {
			if (vocalsCount[i] > vocalsCount[maxPos]) {
				maxPos = i;
			}
		}
		
		// Pattern matching
		return switch(maxPos) {
			case 0 -> 'a';
			case 1 -> 'e';
			case 2 -> 'i';
			case 3 -> 'o';
			case 4 -> 'u';
			default -> throw new IllegalArgumentException("Unexpected value: " + maxPos);
		};
	}
}
