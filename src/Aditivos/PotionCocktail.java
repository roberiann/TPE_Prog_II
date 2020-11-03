package Aditivos;

import java.util.ArrayList;

import JuegoDeCartas.Attribute;

public class PotionCocktail extends Potion {

	private ArrayList<Potion> potions;

	public PotionCocktail(String name) {
		super(name, 0);
		potions = new ArrayList<Potion>();
	}

	public void addCocktail(Potion p){
		potions.add(p);
	}
	
	@Override
	public Attribute modify(Attribute att) {
		Attribute copy = null;
		for (Potion potion : potions) {
			copy = potion.modify(att);
		}
		return copy;
	}

}
