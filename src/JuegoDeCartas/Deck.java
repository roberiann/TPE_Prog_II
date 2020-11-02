package JuegoDeCartas;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	 
	private ArrayList<Card> cards;
		
	public Deck() {
		cards = new ArrayList<Card>();
	}
		
    public void addCard(Card c) {  
    		cards.add(c);
    } 
	
    public void addCardCriterio(Card c) {  
      	CriterioIgualCaracteristica criterio = new CriterioIgualCaracteristica(this.topCard());
        if (criterio.cumple(c))
      		cards.add(c);
    }
    
    public Card topCard() {
    	if (!cards.isEmpty()) { 
    		return cards.get(0); 
    	}
    	return null; 
    }
	
	public Card removeTopCard() {
		if (!cards.isEmpty()) {
			return cards.remove(0);
		} else {
			return null;
		}	
	}
	
	public boolean isEmpty() {
		return cards.size()==0;
	}

	public int size() {
		return cards.size();
	}

	
	public void shuffle() {
	    Collections.shuffle(cards);
	}
	
}
