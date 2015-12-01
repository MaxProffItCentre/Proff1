package action06;

public class Car {
	private String number;
	private String color;
	Car(BuilderCar builder){
		number = builder.getNumber();
		color = builder.getColor();
	}
}
class BuilderCar{
	private String number;
	private String color;
	public BuilderCar(){
		
	}
	public BuilderCar setNumber(String number){
		this.number = number;
		return this;
	}
	public String getNumber(){
		return number;
	}
	
	public BuilderCar setColor(String color){
		this.color = color;
		return this;
	}
	public String getColor(){
		return color;
	}
	public Car build(){
		return new Car(this);
	}
	
}
