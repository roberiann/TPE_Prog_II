package Estrategias;

import JuegoDeCartas.Card;

public class Obstinate extends Strategy {
	
	@Override
	public String getAttribute(Card card) {
		return card.getAttribute(0); 
	}

}
