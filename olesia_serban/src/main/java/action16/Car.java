package action16;

public class Car {
	private Truck truck;
	private Human human;
	private String number;

	public Car() {
	}

	public Car(String number) {
		this.number = number;
	}

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

		return "Car [number : " + number + " " + truck + " " + human + "]";
	}
}
