package ejercicios;
	
import java.util.Random;
import java.util.Scanner;
import java.util.TreeMap;

public class GuessNumber {

    public static void main(String[] args) {
    	
        try (Scanner sc = new Scanner(System.in)) {
        	
			Random random = new Random();
			int randNumber = random.nextInt(20) + 1;
			
			TreeMap<Integer, Boolean> viewedNums = new TreeMap<>();
			
			System.out.println("-- Adivina el número aleatorio ¡A JUGAR! --");
			
			while (true) {
				
			    System.out.print("Introduce un número: ");
			    int guess = sc.nextInt();
			    
			    if (guess == randNumber) {
			        System.out.println("¡Felicidades! Has adivinado el número.");
			        break;
			        
			    } else if (viewedNums.containsKey(guess)) {
			        System.out.println("Ya has intentado ese número, prueba con otro.");
			    } else {
			        viewedNums.put(guess, true);
			        
			        if (guess < randNumber) {
			            System.out.println("El número a adivinar es mayor.");
			        } else {
			            System.out.println("El número a adivinar es menor.");
			        }
			    }
			}
		}
    }
}

