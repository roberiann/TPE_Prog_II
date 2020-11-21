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
	
	public void addAttribute(Attribute t) {
		attributes.add(t);
	}	

	public String getAttribute (int index) {
		return attributes.get(index).getName();
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
		for (Attribute att : attributes) {
			if (att.getName().equals(attrName)) 
		        return new Attribute(att.getName(), att.getValue());
		}
		return null;
	}

	public String getLog(String att) {
		String result = " con " + att + " " + this.getAttributeByName(att).getValue();
		if (this.hasPotion()) 
			result += ", se aplicó pócima " + this.potion.getName() + " valor resultante " + this.getPotioned(att).getValue();
		return result + "\n";
	 }
	
	public boolean hasPotion() {
	    return potion != null; 			
	}
    	
	public void setPotion(Potion p) {
		this.potion = p;
	}

	
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
		
	public int sizeAttributes() {
		return attributes.size();
	}
		
	private Attribute getPotioned(String att) {
		Attribute aux = this.getAttributeByName(att);
		if (this.hasPotion())
			return this.potion.modify(aux);
		return aux;
	}
	
	public int compareTo(Card c1, String att) {
		return this.getPotioned(att).compareTo(c1.getPotioned(att));
	}
	
	public boolean hasAttribute(String attrName) {
		for (Attribute att : attributes) {
			if (att.getName().equals(attrName))
				return true;
		}
		return false;
	}	
	
	public boolean sameAttributes(Card c) {
		for (Attribute att : attributes) {
			if (!c.hasAttribute(att.getName()))
				return false;
		} 
	    return true;  
	}
	
	@Override
	public boolean equals(Object o) {
		try {
			Card c = (Card) o;
			return (this.sizeAttributes() == c.sizeAttributes() && this.sameAttributes(c));
		} catch (Exception e) {
			return false;
		}
	}

}
