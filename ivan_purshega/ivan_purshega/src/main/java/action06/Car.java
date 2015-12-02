package action06;

public class Car {
	private String number;
	private String color;
	
	public Car(BuilderCar k){
		number=k.getNumber();
		color=k.getColor();
	}
	
	protected String getNumber(){
		return number;
	}
}
