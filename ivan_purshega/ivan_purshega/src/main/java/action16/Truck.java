package action16;

public class Truck {
 private String number;
 
 
 

@Override
public String toString() {
	return "Truck [number=" + number + "]";
}

public String getNumber() {
	return number;
}

public void setNumber(String number) {
	this.number = number;
}

public Truck(String number) {
	super();
	this.number = number;
}
 
public Truck() {

}
}
