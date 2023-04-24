package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ejercicios.Baraja;
import ejercicios.Carta;

public class TestBaraja {

    private Baraja barajaEspanola;
    private Baraja barajaFrancesa;

    @BeforeEach
    public void setUp() {
        List<Carta> cartasEspanolas = new ArrayList<>();
        cartasEspanolas.add(new Carta("Oros", "1"));
        cartasEspanolas.add(new Carta("Oros", "2"));
        cartasEspanolas.add(new Carta("Copas", "3"));
        cartasEspanolas.add(new Carta("Copas", "4"));
        cartasEspanolas.add(new Carta("Espadas", "5"));
        cartasEspanolas.add(new Carta("Espadas", "6"));
        cartasEspanolas.add(new Carta("Bastos", "7"));
        cartasEspanolas.add(new Carta("Bastos", "10"));
        barajaEspanola = new Baraja(cartasEspanolas);

        List<Carta> cartasFrancesas = new ArrayList<>();
        cartasFrancesas.add(new Carta("Corazones", "A"));
        cartasFrancesas.add(new Carta("Corazones", "2"));
        cartasFrancesas.add(new Carta("Corazones", "3"));
        cartasFrancesas.add(new Carta("Picas", "4"));
        cartasFrancesas.add(new Carta("Picas", "5"));
        cartasFrancesas.add(new Carta("Diamantes", "6"));
        cartasFrancesas.add(new Carta("Diamantes", "J"));
        cartasFrancesas.add(new Carta("Treboles", "K"));
        barajaFrancesa = new Baraja(cartasFrancesas);
    }
    
    @Test
    public void testRepartirCarta() {
        Carta carta = barajaEspanola.repartirCarta();
        barajaEspanola.barajar();
        
        assertTrue(barajaEspanola.cartaNoHaSalido(carta));
        
        assertEquals(7, barajaEspanola.cartasRestantes().size());
        assertEquals(1, barajaEspanola.cartasRepartidas().size());
    }

    @Test
    public void testRepartirNCartas() {
        List<Carta> cartas = barajaFrancesa.repartirNCartas(3);
        
        assertEquals(5, barajaFrancesa.cartasRestantes().size());
        assertEquals(3, barajaFrancesa.cartasRepartidas().size());
        
        assertTrue(barajaFrancesa.cartaNoHaSalido(cartas.get(0)));
        assertTrue(barajaFrancesa.cartaNoHaSalido(cartas.get(1)));
        assertTrue(barajaFrancesa.cartaNoHaSalido(cartas.get(2)));
    }

    @Test
    public void testCartasRestantes() {
        assertEquals(8, barajaEspanola.cartasRestantes().size());
        
        barajaEspanola.repartirCarta();
        assertEquals(7, barajaEspanola.cartasRestantes().size());
    }
    
    @Test
    public void testCartasRepartidas() {
        assertEquals(0, barajaFrancesa.cartasRepartidas().size());
        barajaFrancesa.repartirNCartas(3);
        
        assertEquals(3, barajaFrancesa.cartasRepartidas().size());
    }

    @Test
    public void testCartaNoHaSalido() {
        Carta carta = new Carta("Bastos", "6");
        barajaEspanola.repartirCarta();
        
        /* - */
        assertFalse(barajaEspanola.cartaNoHaSalido(carta));
    }

    @Test
    public void testBarajarTodo() {
        List<Carta> cartasRepartidas = barajaFrancesa.repartirNCartas(3);
        barajaFrancesa.barajarTodo();
        
        assertFalse(barajaFrancesa.cartasRepartidas().containsAll(cartasRepartidas));
        assertTrue(barajaFrancesa.cartasRestantes().containsAll(cartasRepartidas));
    }
}
