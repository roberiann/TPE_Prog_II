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
			String nn = (String) obj;
			return nn.equals(name);
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
