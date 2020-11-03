package Estrategias;

import JuegoDeCartas.Card;

public class Random extends Strategy {

	@Override
	public String getAttribute(Card card) {
		int randomInt = (int) Math.floor(Math.random()* card.sizeAttributes());
		return card.getAttribute(randomInt);
	}

}
