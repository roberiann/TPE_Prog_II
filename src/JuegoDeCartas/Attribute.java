package JuegoDeCartas;

public class Attribute {
	private String name; 
	private int value;
	
	public Attribute(String name, int value) {
		this.name = name;
		this.value = value;
	}
	
	@Override
	public boolean equals(Object obj) {
		try {
			Attribute att = (Attribute) obj;
			return this.getName().equals(att.getName());
		} catch (Exception e){
			return false;
		}
	}

	public int getValue() {
		return value;
	}

	public String getName() {
		return name;
	}
}
