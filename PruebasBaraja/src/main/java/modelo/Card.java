package modelo;

import java.util.Objects;

public class Card<N extends Comparable<N>, S> {

	private final N number;
	private final S suit;
	
	public Card(N number, S suit) {
		if(number == null || suit == null) throw new IllegalArgumentException("Values cannot be null");
		this.number = number;
		this.suit = suit;
	}

	@Override
	public int hashCode() {
		return Objects.hash(number, suit);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		return Objects.equals(number, other.number) && Objects.equals(suit, other.suit);
	}

	public N getNumber() {
		return number;
	}

	public S getSuit() {
		return suit;
	}

	@Override
	public String toString() {
		return "Card [number=" + number + ", suit=" + suit + "]";
	}
	
	
}
