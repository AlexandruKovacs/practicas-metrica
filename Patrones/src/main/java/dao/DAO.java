package dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface DAO<T, PK> {
	
	
	/**
	 * Find and retreives an object of type T that has key as primary key or null if not found.
	 * @param key the id of the object
	 * @return the object that has the indicated key or null if not exists
	 */
	public T find(PK key) throws SQLException;
	
	/**
	 * @param value
	 * @return
	 */
	public boolean insert(T value);
	
	/**
	 * @param key
	 * @return
	 */
	public T delete(PK key);
	
	/**
	 * @param element
	 * @return el objeto que se encontraba anteriormente en la base de datos y ha sido actualizado
	 */
	public T update(T element);
	
	/**
	 * @return
	 */
	public int deleteAll();
	
	/**
	 * @return
	 */
	public List<T> findAll();
	
	/**
	 * @param condiciones
	 * @return
	 */
	public List<T> findBy(Map<String, String> condiciones);
}
