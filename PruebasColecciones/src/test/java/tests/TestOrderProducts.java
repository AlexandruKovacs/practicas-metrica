package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ejercicios.OrderProducts;
import ejercicios.Product;

public class TestOrderProducts {
	
	List<Product> products = new ArrayList<>();
	
	@BeforeEach
	public void setUp() {
		products.add(new Product("Portátil", 999.99, 25));
		products.add(new Product("Smartphone", 799.99, 20));
		products.add(new Product("Tablet", 499.99, 15));
	}
	
	@Test
	public void testOrderByNombre() {
		
		OrderProducts.ComparadorNombre comparador = new OrderProducts.ComparadorNombre();
		products.sort(comparador);
		
		List<Product> expected = new ArrayList<>();
		expected.add(new Product("Portátil", 999.99, 25));
		expected.add(new Product("Smartphone", 799.99, 20));
		expected.add(new Product("Tablet", 499.99, 15));
		
		assertEquals(expected, products);
	}
	
	@Test
	public void testOrderByPrecio() {
		
		OrderProducts.ComparadorPrecio comparador = new OrderProducts.ComparadorPrecio();
		products.sort(comparador);
		
		List<Product> expected = new ArrayList<>();
		expected.add(new Product("Tablet", 499.99, 15));
		expected.add(new Product("Smartphone", 799.99, 20));
		expected.add(new Product("Portátil", 999.99, 25));
		
		assertEquals(expected, products);
	}
	
	@Test
	public void testOrderByCantidad() {
		
		OrderProducts.ComparadorCantidad comparador = new OrderProducts.ComparadorCantidad();
		products.sort(comparador);
		
		List<Product> expected = new ArrayList<>();
		expected.add(new Product("Tablet", 499.99, 15));
		expected.add(new Product("Smartphone", 799.99, 20));
		expected.add(new Product("Portátil", 999.99, 25));
		
		assertEquals(expected, products);
	}

}