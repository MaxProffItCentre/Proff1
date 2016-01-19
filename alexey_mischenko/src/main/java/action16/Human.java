package action16;

public class Human {
	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Human [name=" + name + "]";
	}

	public Human(){
		
	}
	
	public Human(String name) {
		this.name = name;
	}
	
}	
