package Aditivos;

import JuegoDeCartas.Attribute;

public class PotionValue extends Potion {
	
	
	public PotionValue(String name, int value) {
		super(name, value);
	}

	@Override
	public Attribute modify(Attribute att) {
		att.setValue((int) this.getValue());
		return att;
	}

}
