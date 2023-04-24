package ejercicios;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class OrderProducts {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
        List<Product> products = new ArrayList<>();
        products.add(new Product("Portátil", 999.99, 25));
        products.add(new Product("Smartphone", 799.99, 20));
        products.add(new Product("Tablet", 499.99, 15));
		
        System.out.println("¿Quieres ordenar los prodcutos por nombre (n), precio (p) o cantidad (c)?");
		String input = sc.nextLine();
		
		char opt = input.charAt(0);
		
		switch(opt) {
			case 'n':
				products.sort(new OrderProducts.ComparadorNombre());
				System.out.println("Por nombre: " + products);
				break;
	
			case 'p':
				products.sort(new OrderProducts.ComparadorPrecio());
				System.out.println("Por precio: " + products);
				break;
	
			case 'c':
				products.sort(new OrderProducts.ComparadorCantidad());
				System.out.println("Por cantidad: " + products);
				break;
				
			default:
				System.out.println("Selecciona una opción correcta.");
		}
		sc.close();
	}
	
	public static class ComparadorNombre implements Comparator<Product> {

		@Override
		public int compare(Product o1, Product o2) {
			return o1.getName().compareTo(o2.getName());
		}
	}
	
	public static class ComparadorPrecio implements Comparator<Product> {

		@Override
		public int compare(Product o1, Product o2) {
	        if (o1.getPrice() < o2.getPrice()) {
	            return -1;
	        } else if (o1.getPrice() > o2.getPrice()) {
	            return 1;
	        } else {
	            return 0;
	        }
		}
	}
	
	public static class ComparadorCantidad implements Comparator<Product> {

		@Override
		public int compare(Product o1, Product o2) {
	        if (o1.getQuantity() < o2.getQuantity()) {
	            return -1;
	        } else if (o1.getQuantity() > o2.getQuantity()) {
	            return 1;
	        } else {
	            return 0;
	        }
		}
	}
}

