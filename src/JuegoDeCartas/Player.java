package JuegoDeCartas;

import Estrategias.Strategy;

public class Player {
	private String name;
	private Deck deck;
	private Strategy strategy; 
			
    public Player(String name, Strategy strategy) {
    	this.strategy = strategy;
		this.name = name;
		deck = new Deck();
	}
    
    
    public void setStrategy(Strategy strategy) {
    	this.strategy = strategy;
    }
    
    public void addCard(Card c) {
    	if (c != null)
    		deck.addCard(c);
    }
   
	public String getName() {
		return name;
	}
	
	public int deckSize() {
		return deck.size();
	}
	
	public Card topCard() {
		return deck.topCard();
	}
	
	public Card removeTopCard() {
		return deck.removeTopCard();
	}
	
	public String getAttribute() {
		return strategy.getAttribute(this.topCard()); 
	}

	@Override
	public String toString() {
		return name;
	}
		
	public void shuffle() {
	    deck.shuffle();
	}
		
	
}
