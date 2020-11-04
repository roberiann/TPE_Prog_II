package Estrategias;

import java.util.ArrayList;

import JuegoDeCartas.Attribute;
import JuegoDeCartas.Card;

public class Ambitious extends Strategy {

	@Override
	public String getAttribute(Card card) {	
		ArrayList<String> attributes = card.getAttributesNames();
		Attribute higher = card.firstAttribute();
		for (String elem : attributes) {
			if (card.getAttributeByName(elem).compareTo(higher)>0)
				higher = card.getAttributeByName(elem);
				
		}
		return higher.getName();	
	}

}
