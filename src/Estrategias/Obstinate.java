package Estrategias;

import JuegoDeCartas.Card;

public class Obstinate extends Strategy {
	
	private String name; 
	
	
	public Obstinate(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String getAttribute(Card card) {
		if (card.hasAttribute(this.getName()))		
			return this.getName(); 
		else 
			return null;
	}


}
