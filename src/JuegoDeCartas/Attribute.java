package JuegoDeCartas;

public class Attribute implements Comparable<Attribute> {
	private String name; 
	private int value;
	
	public Attribute(String name, int value) {
		this.name = name;
		this.value = value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public String getName() {
		return name;
	}

	@Override
	public int compareTo(Attribute att) {
		return this.getValue() - att.getValue();
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
	
}
