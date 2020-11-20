package Aditivos;

import JuegoDeCartas.Attribute;

public class PotionValue extends Potion {
	
	protected int value;
	
	public PotionValue(String name, int value) {
		super(name);
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public Attribute modify(Attribute att) {
		att.setValue(this.getValue());
		return att;
	}

}
