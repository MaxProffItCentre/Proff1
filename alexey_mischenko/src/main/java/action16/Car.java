package action16;

public class Car {
	Truck truck;
	String number;
	Human human;
	
	public Truck getTruck() {
		return truck;
	}
	public void setTruck(Truck truck) {
		this.truck = truck;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public Human getHuman() {
		return human;
	}
	public void setHuman(Human human) {
		this.human = human;
	}
	
	public Car() {
	}
	public Car(String number) {
		this.number = number;
	}

	public Car(Truck truck, String number) {
		this.truck = truck;
		this.number = number;
	}
	
	public Car(String number, Human human) {
		this.number = number;
		this.human = human;
	}
	
	
	public Car(Truck truck, String number, Human human) {
		this.truck = truck;
		this.number = number;
		this.human = human;
	}
	
	
	
}
