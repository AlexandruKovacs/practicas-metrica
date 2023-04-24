package ejercicios;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baraja {

    private List<Carta> cartas;
    private List<Carta> cartasRepartidas;

    public Baraja(List<Carta> cartas) {
        this.cartas = cartas;
        this.cartasRepartidas = new ArrayList<>();
    }

    public void barajar() {
        Collections.shuffle(cartas);
        System.out.println(cartas);
    }

    public void barajarTodo() {
        cartas.addAll(cartasRepartidas);
        cartasRepartidas.clear();
        barajar();
    }

    public Carta repartirCarta() {
        Carta carta = cartas.remove(0);
        cartasRepartidas.add(carta);
        
        return carta;
    }

    public List<Carta> repartirNCartas(int n) {
    	
        List<Carta> cartasRepartidas = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            cartasRepartidas.add(repartirCarta());
        }
        
        return cartasRepartidas;
    }

    public List<Carta> cartasRestantes() {
        return cartas;
    }

    public List<Carta> cartasRepartidas() {
        return cartasRepartidas;
    }

    public boolean cartaNoHaSalido(Carta carta) {
    	return cartas.contains(carta) || cartasRepartidas.contains(carta);
    }
}