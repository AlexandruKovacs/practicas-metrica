package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modelo.Card;
import modelo.Deck;
import modelo.generator.GeneratorFactory;

public class TestInicial {

	private Deck<String, String> deck;
	
	@Test
	@BeforeEach
	public void setup() {
		deck = new Deck(GeneratorFactory.get("esp"));
	}
	
	@Test
	public void testRepartir() {
		int previousSize = deck.size();
		Card dealed = deck.dealCard();
		
		HashSet<Card> allCards = new HashSet<>();
		allCards.add(dealed);
		
		assertEquals(previousSize - 1, deck.size());
		for(Card c : deck) {
			allCards.add(c);
		}
		
		assertEquals(previousSize, allCards.size());
	}
	
	@Test
	public void testRepartirN() {
		int previousSize = deck.size();
		
		List<Card<String, String>> listOfCards = deck.dealCard(20);
		assertEquals(previousSize - 20, deck.size());
		
		List<Card<String, String>> secondList = deck.dealCard(deck.size() + 1);
		assertEquals(previousSize, listOfCards.size() + secondList.size());
		
		assertTrue(Collections.disjoint(listOfCards, secondList));
	}
	
	@Test
	public void remainingCards() {
		Set<Card<String, String>> initialCards = deck.remainingCards();
		
		Card dealed = deck.dealCard();
		Set<Card<String, String>> remaining = deck.remainingCards();
		
		assertTrue(initialCards.contains(dealed));
		
		assertFalse(remaining.contains(dealed));
		assertNotEquals(initialCards, remaining);
		assertTrue(remaining.add(dealed));
		
		assertEquals(initialCards, remaining);
	}
	
	@Test
	public void testShuffle() {
		int previousSize = deck.size();
		Card dealed = deck.dealCard();
		
		deck.shuffle();
		
		assertEquals(previousSize, deck.size());
		assertTrue(deck.remainingCards().contains(dealed));
	}
	
	@Test
	public void testContains() {
		Card<String, String> example = new Card("1", "Espadas");
		assertTrue(deck.contains(example));
		
		List<Card<String, String>> cards = deck.dealCard(deck.size());
		assertFalse(deck.contains(example));
		
		assertTrue(cards.contains(example));
	}
	
	/* @Test
	public void testMalo() {
		this.deck.iterator().forEachRemaining(System.out::println);
	} */
}
