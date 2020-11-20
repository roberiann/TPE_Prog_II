package Aditivos;

import JuegoDeCartas.Attribute;

public class PotionPercentage extends Potion {
		
	protected double value; 
	
	public PotionPercentage(String name, double value) {
		super(name);
		this.value = value;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}
	
	@Override
	public Attribute modify(Attribute att) {
		int newValue = (int) (att.getValue()*this.getValue());
		att.setValue(newValue);
		return att;
	}


	
}
