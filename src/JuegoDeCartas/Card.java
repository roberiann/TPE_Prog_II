package JuegoDeCartas;

import javax.json.JsonObject;
import java.util.ArrayList;

public class Card {

	private String name;
	private ArrayList<Attribute> attributes;
	
	public Card(String name) {
		this.name = name;
		attributes = new ArrayList<Attribute>();
	}	
	
    public Card (JsonObject card) {
    	JsonObject jsonAttrib = (JsonObject) card.getJsonObject("atributos");
    	
        this.name = card.getString("nombre");
        for (String attribName:jsonAttrib.keySet()) {    	
        	this.addAttribute(new Attribute(attribName, (int) card.getInt(attribName)));
        }   
    }
	
	public void addAttribute(Attribute t) {
		attributes.add(t);
	}	
	
	public void agregar(Attribute c) {
		attributes.add(c);
	}
	
	
	public boolean sameAttributes(Card c) {
		for (int i = 0; i < attributes.size(); i++) {
			if (!attributes.containsAll(c.getAttributes())) { 
			      return false;	
			}
		}
        return true;
	}

	public ArrayList<Attribute> getAttributes() {
		return attributes;
	}

	public String getName() {
		return name;
	}
	
	public String getRandomAttributeName() {
		int randomInt = (int) Math.floor(Math.random()*attributes.size());
		return attributes.get(randomInt).getName();
	}

	public int getAttributeValue(String attrName) {
		for (int i = 0; i < attributes.size(); i++) {
			if (attributes.get(i).getName().equals(attrName)) {
		        return (int) attributes.get(i).getValue();
			}
		}
		return -1;
	}
}
