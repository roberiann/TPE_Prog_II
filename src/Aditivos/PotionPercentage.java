package Aditivos;

import JuegoDeCartas.Attribute;

public class PotionPercentage extends Potion {
	
	public PotionPercentage(String name, double value) {
		super(name, value);
	}

	@Override
	public Attribute modify(Attribute att) {
		int newValue = (int) (att.getValue()*this.getValue());
		att.setValue(newValue);
		return att;
	}

	
}
