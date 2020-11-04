package Aditivos;

import JuegoDeCartas.Attribute;

public abstract class Potion extends ElementPotion {
	
	protected double value;
	
	public Potion(String name, double value) {
		super(name);
		this.value = value; 
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public abstract Attribute modify(Attribute att);
}
