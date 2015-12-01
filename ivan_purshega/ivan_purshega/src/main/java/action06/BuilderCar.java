package action06;

public class BuilderCar {
	private String number;
	private String Color;
	
	
	public BuilderCar() {
		
	}
	
	public Car buildcar(){
		return new Car(number,Color);
	}
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		BuilderCar.this.number = number;
	}
	public String getColor() {
		return Color;
	}
	public void setColor(String color) {
		BuilderCar.this.Color = color;
	}
	
	
	
}
