package Aditivos;

import java.util.ArrayList;

import JuegoDeCartas.Attribute;

public class PotionCocktail extends ElementPotion {

	private ArrayList<ElementPotion> potions;

	public PotionCocktail(String name) {
		super(name);
		potions = new ArrayList<ElementPotion>();
	}

	public void addCocktail(ElementPotion p){
		potions.add(p);
	}
	
	@Override
	public Attribute modify(Attribute att) {
		Attribute copy = null;
		for (ElementPotion potion : potions) {
			copy = potion.modify(att);
		}
		return copy;
	}

}
