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
	
	private Potion getPotion() {
		return potion;
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
		String result = "";
		if (this.hasPotion()) 
			result += ", se aplicó pócima " + this.potion.getName() + " valor resultante " + this.getAttValuePlusPotion(att);
		return result + "\n";
	 }
	
	public boolean hasPotion() {
	    return potion != null; 			
	}
    	
	public void setPotion(Potion p) {
		this.potion = p;
	}

	public int getAttValue(String attrName) {
		for (Attribute att : attributes) {
			if (att.getName().equals(attrName)) 
				return att.getValue();
		}
		return -1;
	}	
	
	public boolean hasAttribute(String attrName) {
		for (Attribute att : attributes) {
			if (att.getName().equals(attrName))
				return true;
		}
		return false;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
		
	public boolean sameAttributes(Card c) {
		for (Attribute att : attributes) {
			if (!c.hasAttribute(att.getName()))
				return false;
		} 
	    return true;  
	}
	
	public int sizeAttributes() {
		return attributes.size();
	}
	
	
	public int getAttValuePlusPotion(String attrName) {
		if (this.hasPotion()) {
			Attribute att = new Attribute(attrName, this.getAttValue(attrName));
			return this.potion.modify(att).getValue();
		} else {
			return this.getAttValue(attrName);
		}
	}
	
	//MAL
	public int compareTo(Card c1, String att) {
		Attribute att1 = this.getAttributeByName(att);
		Attribute att2 = c1.getAttributeByName(att);
		if (this.hasPotion())
			att1 = this.potion.modify(att1);
		if (c1.hasPotion())
			att2 = c1.getPotion().modify(att2);
		return att1.compareTo(att2);		
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
