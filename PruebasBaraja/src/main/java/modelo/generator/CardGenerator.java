package modelo.generator;

import java.util.Iterator;

import modelo.Card;

public abstract class CardGenerator<N extends Comparable<N>, S> implements Iterator<Card<N, S>> {
	
	protected N[] numbers;
	protected S[] suits;
	protected int i;
	
	protected CardGenerator(N[] numbers, S[] suits) {
		this.numbers = numbers;
		this.suits = suits;
		this.i = 0;
	}
	
	@Override
	public boolean hasNext() {
		return i < numbers.length * suits.length;
	}

	@Override
	public Card<N, S> next() {
		return new Card(numbers[i % numbers.length], suits[i++ / suits.length]);
	}
}

class SpanishCardGenerator extends CardGenerator<String, String> {

	public SpanishCardGenerator() {
		super(	new String[] {"1", "2", "3", "4", "5", "6", "7", "sota", "caballo", "rey"},
				new String[] {"espadas", "copas", "bastos", "oros"});
	}
}
