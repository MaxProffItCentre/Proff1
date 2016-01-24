package action16;

public class Car {
public Car() {
		super();
	}
public Car(String number) {
		super();
		this.number = number;
	}
public Car(Truck truck, Human human, String number) {
		super();
		this.truck = truck;
		this.human = human;
		this.number = number;
	}
private Truck truck;
private Human human;
private String number;

public Truck getTruck() {
	return truck;
}
public void setTruck(Truck truck) {
	this.truck = truck;
}
public Human getHuman() {
	return human;
}
public void setHuman(Human human) {
	this.human = human;
}
public String getNumber() {
	return number;
}
public void setNumber(String number) {
	this.number = number;
}
@Override
public String toString() {
	return "Car [truck=" + truck + ", human=" + human + ", number=" + number + "]";
}
}
