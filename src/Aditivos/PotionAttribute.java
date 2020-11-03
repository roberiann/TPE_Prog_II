package Aditivos;

import JuegoDeCartas.Attribute;

public class PotionAttribute extends PotionPercentage {

	private String attributeName;

	public PotionAttribute(String name, double value, String attName) {
		super(name, value);
		this.attributeName = attName;
	}
	
	@Override
	public Attribute modify(Attribute att) {
		
		if (att.getName().equals(attributeName)) {
			super.modify(att);
		} 
		
		return att;
	}

}
