package practicas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RecorrimientoMapas {

	public static void main(String[] args) {
		actualizarMapa();
	}
	
	public static void pruebaRecorrer(String[] args) {
		
		for(String s: new ArrayList<String>()) {
			
		}
		for(Map.Entry<String, Integer> o: new HashMap<String, Integer>().entrySet()) {
			
		}
		
	}
	
	public static void actualizarMapa() {
		
		HashMap<Integer, String> mapa = new HashMap<>();
		mapa.put(3, "hola");
		
		String valor = mapa.get(3);
		valor += " caracola";
		
		System.out.println(mapa);
	}

}
