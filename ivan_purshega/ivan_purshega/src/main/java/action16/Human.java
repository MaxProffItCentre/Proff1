package action16;

public class Human {
private String name;


@Override
public String toString() {
	return "Human [name=" + name + "]";
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public Human(String name) {
	super();
	this.name = name;
}

public Human(){
	
}
	
	
}
