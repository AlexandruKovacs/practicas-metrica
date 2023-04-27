package modelo;

import java.util.*;

import modelo.generator.CardGeneratorPro;

public class Deck<N extends Comparable<N>, S> implements Iterable<Card<N, S>> {

	private LinkedList<Card<N, S>> availableCards;
	private Set<Card<N, S>> dealedCards;
	
	public Deck(CardGeneratorPro<N, S> seed) {
		availableCards= new LinkedList();
		// seed.forEachRemaining(availableCards::add);
		
		while(seed.hasNext()) {
			availableCards.add(seed.next());
		}
	}
	
	public Card<N, S> dealCard() {
		Card<N, S> actual = availableCards.poll();
		
		if(actual != null) {
			dealedCards.add(actual);
		}
		
		return actual;
	}
	
	public List<Card<N, S>> dealCard(int n) {
		int max = Math.min(n, availableCards.size());
		List<Card<N, S>> dealed = new ArrayList(max);
		
		for(int i = 0; i < max; i++) {
			dealed.add(dealCard());
		}
		
		return dealed;
		
	}
	
	public int size() {
		return this.availableCards.size();
	}

	public Set<Card<N, S>> remainingCards() {
		return new HashSet(this.availableCards);
	}

	public void shuffle() {
		this.availableCards.addAll(this.dealedCards);
		this.dealedCards.clear();
		
		Collections.shuffle(this.availableCards);
	}

	public boolean contains(Card<N, S> example) {
		return this.availableCards.contains(example);
	}
	
	@Override
	public Iterator<Card<N, S>> iterator() {
		return this.availableCards.iterator();
	}
}
