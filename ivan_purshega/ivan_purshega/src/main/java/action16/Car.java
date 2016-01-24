package action16;

public class Car {
	private Truck truck;
	private String number;
	private Human driver;

	public Car(String number) {
		this.number = number;
	}

	

	@Override
	public String toString() {
		return "Car [truck=" + truck + ", number=" + number + ", driver=" + driver + "]";
	}



	public Car() {

	}

	

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

	public Human getDriver() {
		return driver;
	}

	public void setDriver(Human driver) {
		this.driver = driver;
	}

}
