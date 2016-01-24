package action06;

public class CarBuilder {
	private String number;
	private String colour;
public CarBuilder(){
	}
public static void main(String[] args) {
	Car car=new CarBuilder().setNumber("1").setColour("v").build();
	
}
public Car build(){return new Car(this);
}

public String getNumber() {
	return number;
}

public CarBuilder setNumber(String number) {
	this.number = number;
return this;}

public String getColour() {
	return colour;
}

public CarBuilder setColour(String colour) {
	this.colour = colour;
	return this;}

public class Car{
	String number;
	String colour;
	public Car(CarBuilder cb){
		number=cb.getNumber();
		colour=cb.getColour();
	}
}}
