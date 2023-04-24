package singleton;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ArbolGenealogico<T> implements Iterable<ArbolGenealogico<T>> {

	private T elemento;
	private Set<ArbolGenealogico<T>> descendientes;
	
	public ArbolGenealogico(T element) {
		this.elemento = element;
		descendientes = new HashSet<ArbolGenealogico<T>>();
	}
	
	public ArbolGenealogico<T> add(T descendiente) {
		ArbolGenealogico<T> nuevo = new ArbolGenealogico<T>(descendiente);
		descendientes.add(nuevo);
		
		return nuevo;
	}
	
	public T getElement() {
		return elemento;
	}
	
	public Iterator<ArbolGenealogico<T>> iterator() {
		return descendientes.iterator();
	}
}
