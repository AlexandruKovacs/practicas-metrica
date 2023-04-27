package modelo.generator;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Queue;

import modelo.Card;

public class CardGeneratorPro<N extends Comparable<N>, S> implements Iterator<Card<N, S>> {

	private N[] numbers;
	private Iterator<N> numberIt;
	private Queue<S> suitIt;
	
	public CardGeneratorPro(N[] numbers, S[] suits) {
		this.numbers = numbers;
		numberIt = Arrays.stream(numbers).iterator();
		suitIt = new ArrayDeque(Arrays.asList(suits));
	}
	
	@Override
	public boolean hasNext() {
		return numberIt.hasNext() || suitIt.size() > 1;
	}

	@Override
	public Card<N, S> next() {
		
		if(!numberIt.hasNext()) {
			numberIt = Arrays.stream(numbers).iterator();
			suitIt.poll();
		}
		
		return new Card(numberIt.next(), suitIt.peek());
	}
}

class SpanishCardGeneratorPro extends CardGeneratorPro<String, String> {
	
	public SpanishCardGeneratorPro() {
		super(	new String[] {"1", "2", "3", "4", "5", "6", "7", "sota", "caballo", "rey"},
				new String[] {"espadas", "copas", "bastos", "oros"});
	}
}
