package action16;

public class Lift {
public Lift() {
		super();
	}

public Lift(String name) {
		super();
		this.name = name;
	}

private String name;
private String operator;

public String getName() {
	return name;
}

public Lift(String name, String operator) {
	super();
	this.name = name;
	this.operator = operator;
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

@Override
public String toString() {
	return "Lift [name=" + name + ", operator=" + operator + "]";
}
}
