package practicas;

import java.util.Arrays;
import java.util.List;

public class MetodosToolKits {

	public static void main(String[] args) {
		collect("a", "b", "c");
		collect("a");
	}
	
	public static void collect(String ... args) {
		System.out.println(Arrays.toString(args));
	}
	
	public void metodosArray() {
		List<Integer> lista = Arrays.asList(1,2,6);
		
		Integer[] values = new Integer[] {1,2,6};
		lista = Arrays.asList(values);
		
		collect("a", "b", "c");
		collect("a");
	}
}
