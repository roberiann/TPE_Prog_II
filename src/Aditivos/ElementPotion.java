package Aditivos;

import JuegoDeCartas.Attribute;

public abstract class ElementPotion {
	private String name;
	 
	 public ElementPotion(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public abstract Attribute modify(Attribute att);
}
