package Aditivos;

import JuegoDeCartas.Attribute;

public abstract class Potion{
	
	protected String name;
		 
	public Potion(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public abstract Attribute modify(Attribute att);
}
