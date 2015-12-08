package action06;

public class BuilderCar {
	private String number;
	private String color;
	
	
	
	public Car build(){
		return new Car(this);
	}
	
	
	public BuilderCar() {
	
	}
	
	
	public String getNumber() {
		return number;
	}
	public BuilderCar setNumber(String number) {
		this.number = number;
		return this;
	}
	public String getColor() {
		return color;
	}
	public BuilderCar setColor(String color) {
		this.color = color;
		return this;
	}
	
	
}
