package JuegoDeCartas;

import java.util.ArrayList;
import Aditivos.Potion;

public class Card{

	private String name;
	private ArrayList<Attribute> attributes;
	private Potion potion;
		
	public Card(String name) {
		this.name = name;
		attributes = new ArrayList<Attribute>();
		potion = null;
	}
	
	public boolean hasPotion() {
	    return potion != null; 			
	}
    	
	public void setPotion(Potion p) {
		this.potion = p;
	}
	
	public String getPotionName() {
		return potion.getName();
	}
	
	public int sizeAttributes() {
		return attributes.size();
	}
	
	public void addAttribute(Attribute t) {
		attributes.add(t);
	}	
	
	public boolean sameAttributes(Card c) {
	     return attributes.containsAll(c.getAttributes()); 
	}
	
	private ArrayList<Attribute> getAttributes() {
		return new ArrayList<Attribute>(attributes);
	}

	public String getName() {
		return name;
	}
	
	public int getAttValue(String attrName) {
		for (int i = 0; i < attributes.size(); i++) {
			if (attributes.get(i).getName().equals(attrName)) {
		        return attributes.get(i).getValue();
			}
		}
		return -1;
	}
	
	public int getAttValuePlusPotion(String attrName) {
		Attribute att = new Attribute(attrName, this.getAttValue(attrName));
		return this.potion.modify(att).getValue();
	}
	
	@Override
	public boolean equals(Object o) {
		try {
			Card c = (Card) o;
			return this.getName().equals(c.getName());
		} catch (Exception e) {
			return false;
		}
	}
	
	public String getAttribute (int index) {
		return attributes.get(index).getName();
	}
	
	@Override
	public String toString() {
		return name;
	}

}
