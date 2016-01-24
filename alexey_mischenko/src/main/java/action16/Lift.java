package action16;

public class Lift {
	String name;
	String operator;
	
	public Lift() {
	
	}

	public Lift(String name) {
		this.name = name;
	}
	
	public Lift(String name, String operator){
		this.name = name;
		this.operator = operator;
	}

	@Override
	public String toString() {
		return "Lift [name=" + name + ", operator=" + operator + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}
	
}
