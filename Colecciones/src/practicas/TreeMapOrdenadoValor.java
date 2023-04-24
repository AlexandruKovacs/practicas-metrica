package practicas;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class TreeMapOrdenadoValor<K, V extends Comparable<V>> implements SortedMap<K, V> {

	final TreeMap<K, V> ordenado;
	final HashMap<K, V> instance;
	
	public TreeMapOrdenadoValor() {
		instance = new HashMap<>();
		
		final Comparator<K> com = (k1, k2) -> this.get(k1) != null ? 
				  							  this.get(k1).compareTo(this.get(k2)) :
				  							  -1;
		
		ordenado = new TreeMap<>(com);
	}

	@Override
	public int size() {
		return ordenado.size();
	}

	@Override
	public V get(Object key) {
		return instance.get(key);
	}

	@Override
	public V put(K key, V value) {
		instance.put(key, value);
		return ordenado.put(key, value);
	}

	@Override
	public boolean isEmpty() {
		return ordenado.isEmpty();
	}

	@Override
	public boolean containsKey(Object key) {
		return instance.containsKey(key);
	}

	@Override
	public boolean containsValue(Object value) {
		return instance.containsKey(value);
	}

	@Override
	public V remove(Object key) {
		ordenado.remove(key);
		return instance.remove(key);
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		instance.putAll(m);
		ordenado.putAll(m);
	}

	@Override
	public void clear() {
		instance.clear();
		ordenado.clear();
	}

	@Override
	public Comparator<? super K> comparator() {
		throw new UnsupportedOperationException();
	}

	@Override
	public SortedMap<K, V> subMap(K fromKey, K toKey) {
		throw new UnsupportedOperationException();
	}

	@Override
	public SortedMap<K, V> headMap(K toKey) {
		throw new UnsupportedOperationException();
	}

	@Override
	public SortedMap<K, V> tailMap(K fromKey) {
		throw new UnsupportedOperationException();
	}

	@Override
	public K firstKey() {
		return ordenado.firstKey();
	}

	@Override
	public K lastKey() {
		return ordenado.lastKey();
	}

	@Override
	public Set<K> keySet() {
		return ordenado.keySet();
	}

	@Override
	public Collection<V> values() {
		return ordenado.values();
	}

	@Override
	public Set<Entry<K, V>> entrySet() {
		return ordenado.entrySet();
	}
	
}
