package practicas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;

public class Aleatorizacion {
	
	public static void main(String[] args) {
		generarFraseFrecuencias(80);
	}
	
	static Map<Character, Integer> letterFrequencies = new HashMap<>() {
		{
			put('A', 13);
			put('E', 11);
		}
	};

	public Integer[] listaAleatoriaConsecutiva(int n) {
		
		// int n = new Random().nextInt(100);
		
		ArrayList<Integer> numbersList = new ArrayList<>();
		
		for(int i = 0; i < n; i++) numbersList.add(i);
		
		Collections.shuffle(numbersList);
		
		numbersList.sort((a, b) -> new Random().nextBoolean()? 1 : -1);
		
		return numbersList.toArray(new Integer[0]);
	}
	
	public Integer[] listaGenerador(int n) {
		
		ArrayList<Integer> numbersList = new ArrayList<>();
		
		for(int i = 0; i < n; i++) numbersList.add(i);
		
		Collections.shuffle(numbersList);
		
		return numbersList.toArray(this::listaAleatoriaConsecutiva);
	}
	
	public Integer[] listaAleatoriaSinRepetidos(final int max, final int n) {
		Integer[] possibleNumbers = listaAleatoriaConsecutiva(max);
		
		int actualSize = Math.min(max, n);
		
		return Arrays.copyOf(possibleNumbers, actualSize);
		
	}
	
	public int[] listaAleatoriaSinRepetidosIneficiente(int max) {
		
		int n = new Random().nextInt(100);
		HashSet<Integer> distinctNumbers = new HashSet();
		
		while(distinctNumbers.size() < n) {
			distinctNumbers.add(new Random().nextInt(max));
		}
		
		int[] result = new int[n];
		int i = 0;
		
		for(Integer value : distinctNumbers) result[i++] = value;
		
		return result;
	}
	
	public String generarFrase() {
		StringBuilder phrase = new StringBuilder();
		
		for(int i = 0; i < 100; i++) {
			char letter = (char)(new Random().nextInt('z' - 'A') + 'A');
			phrase.append(new Random().nextBoolean() ? letter: Character.toLowerCase(letter));
		}
		
		return phrase.toString();
	}
	
	public static String generarFraseFrecuencias(int n) {
		ArrayList<Character> pool = new ArrayList<>(100);
		
		for(Map.Entry<Character, Integer> letter : letterFrequencies.entrySet()) {
			for(int i = 0; i < letter.getValue(); i++) pool.add(letter.getKey());
		}
		
		// Proporcion lineas 4:1
		
		for(int i = 0; i < pool.size() / 4; i++) pool.add(' ');
		
		StringBuilder phrase = new StringBuilder();
		for(int i = 0; i < n; i++) {
			phrase.append(pool.get(new Random().nextInt(pool.size())));
		}
		
		return phrase.toString();
	}
	
	class LimitedList<T> extends ArrayList<T> {
		private int maxLength;
		
		public LimitedList(int max) {
			this.maxLength = max;
		}
		
		@Override
		public boolean add(T e) {
			if(this.size() == maxLength) {
				return false;
			}
			
			return super.add(e);
		}
	}
}