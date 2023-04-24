package practicas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class StringOrdenados {

	public static void main(String[] args) {
		
		ArrayList<String> lista = new ArrayList<>();
		lista.add("Hola");
		lista.add("h");
		lista.add("36");
		lista.add("adios");
		lista.add("h1");
		lista.add("h ");
		
		//
		Collections.sort(lista);
		System.out.println(lista);
		
		lista.sort(new MiComparador());
		System.out.println(lista);
		
		//clase anónima
		lista.sort(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				int value= Integer.compare(o1.length(), o2.length());
				if(value==0) value = o1.compareTo(o2);
				
				return value;
			}
			
		});
		
		System.out.println(lista);
		
		// programación lambda
		lista.sort((String a, String b) -> a.length()-b.length());
		
		// programacion funcional
		lista.sort(StringOrdenados::orden);
		lista.sort(String::compareTo);
		
	}
	
	static int orden(String o1, String o2) {
		int value= Integer.compare(o1.length(), o2.length());
		if(value==0) value = o1.compareTo(o2);
		
		return value;
	}
	
	//clase interna
	static class MiComparador implements Comparator<String>{

		@Override
		public int compare(String o1, String o2) {
			int value= Integer.compare(o1.length(), o2.length());
			if(value==0) value = o1.compareTo(o2);
			
			return value;
		}
		
	}
}
