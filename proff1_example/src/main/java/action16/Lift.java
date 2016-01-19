package action16;

public class Lift {
	private String name;
	private String operator;

	public Lift(String name) {
		this.name = name;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
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
		return "Lift [name=" + name + ", operator=" + operator + "]";
	}
	
}