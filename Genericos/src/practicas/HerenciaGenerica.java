package practicas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

public class HerenciaGenerica <T extends Comparable<T>, E> {

	public static void main(String[] args) {
		TreeSet<Comparable<Padre>> listaRara = new TreeSet<>();
		listaRara.add(new MiClaseA("adios"));
		listaRara.add(new MiClaseB(8));

		System.out.println(listaRara);
	}
}

abstract class Padre implements Comparable<Padre>{
	
	abstract int longitud();
	
	@Override
	public int compareTo(Padre o) {
		return Integer.compare(this.longitud(),o.longitud());
		//return this.longitud()-o.longitud();
	}
}

class MiClaseA extends Padre {

	private String valor;
	
	
	public MiClaseA(String valor) {
		super();
		this.valor = valor;
	}





	@Override
	int longitud() {
		return valor.length();
	}


}

class MiClaseB extends Padre{

	private Integer valor;
	
	
	public MiClaseB(Integer valor) {
		super();
		this.valor = valor;
	}
	

	@Override
	int longitud() {
		if(this.valor ==0) return 1;
		int count =0;
		int n = this.valor;
		while(n >0) {
			count++;
			n/=10;
		}
		return count;
	}
	
}
