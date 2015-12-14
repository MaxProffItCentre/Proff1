package HomeTaskMySQL;

public class Contructor {
	private String name;

	@Override
	public String toString() {
		return name;
	}

	public Contructor(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
