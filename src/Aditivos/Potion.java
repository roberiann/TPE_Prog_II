package Aditivos;

import JuegoDeCartas.Attribute;

public abstract class Potion{
	protected String name;
	protected double value;
	
	public Potion(String name, double value) {
		this.name = name;
		this.value = value; 
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public abstract Attribute modify(Attribute att);
}
