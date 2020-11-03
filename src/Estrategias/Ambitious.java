package Estrategias;

import JuegoDeCartas.Card;

public class Ambitious extends Strategy {

	@Override
	public String getAttribute(Card card) {
		return card.getHigherValue();
	}

}
