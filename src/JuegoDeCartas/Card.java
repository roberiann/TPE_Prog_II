package JuegoDeCartas;

import java.util.ArrayList;

import Aditivos.ElementPotion;

public class Card{

	private String name;
	private ArrayList<Attribute> attributes;
	private ElementPotion potion;
		
	public Card(String name) {
		this.name = name;
		attributes = new ArrayList<Attribute>();
		potion = null;
	}
	
	public boolean hasPotion() {
	    return potion != null; 			
	}
    	
	public void setPotion(ElementPotion p) {
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
	
	public boolean hasAttribute(String attrName) {
		for (int i = 0; i < attributes.size(); i++) {
			if (attributes.get(i).getName().equals(attrName)) {
		        return true;
			}
		}
		return false;
	}
	
	public ArrayList<String> getAttributesNames() {
		ArrayList<String> att = new ArrayList<String>();
		for (Attribute elem : attributes) {
			att.add(elem.getName());
		}				
		return att;
	}
	
	public Attribute firstAttribute() {
		return new Attribute(attributes.get(0).getName(), attributes.get(0).getValue());
	}
    
	public Attribute getAttributeByName(String attrName) {
		for (int i = 0; i < attributes.size(); i++) {
			if (attributes.get(i).getName().equals(attrName)) {
		        return new Attribute(attributes.get(i).getName(), attributes.get(i).getValue());
			}
		}
		return null;
	}
	
	

}
