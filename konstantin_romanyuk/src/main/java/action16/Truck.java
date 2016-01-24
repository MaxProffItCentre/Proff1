package action16;

public class Truck {
public Truck() {
		super();
	}

public Truck(String number) {
		super();
		this.number = number;
	}

private String number;

public String getNumber() {
	return number;
}

public void setNumber(String number) {
	this.number = number;
}

@Override
public String toString() {
	return "Truck [number=" + number + "]";
}
}
