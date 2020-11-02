package JuegoDeCartas;

public class Player {
	private String name;
	private Deck deck;
	
    public Player(String name) {
		this.name = name;
		deck = new Deck();
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
	
	public String getRandomAttribute() {
		int randomInt = (int) Math.floor(Math.random()* this.topCard().sizeAttributes());
		return this.topCard().getAttribute(randomInt);
	}

	@Override
	public String toString() {
		return name;
	}
		
	
}
