package action14;

public class Lift {
	private String name;

	public Lift(String name) {
		this.name = name;
	}

	public Lift() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "Lift [name=" + name + "]";
	}
	
}
