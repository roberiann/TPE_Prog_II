package JuegoDeCartas;

public class Player {
	private String name;
	private Deck deck;
	
    public Player(String name) {
		this.name = name;
		deck = new Deck();
	}
    
    public void addCard(Card c) {
    	deck.addCard(c);
    }
   
	public String getName() {
		return name;
	}
	
	public int getDeckSize() {
		return deck.size();
	}
	
	public Card topCard() {
		return deck.topCard();
	}
	
}
