package action06;

public class Car {
	private String number;
	private String Color;
	
	
	 public Car(String number, String color) {
		this.number = number;
		Color = color;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}


	public String getColor() {
		return Color;
	}


	public void setColor(String color) {
		Color = color;
	}


	public static void main(String[] args) {
		 Car car1= new BuilderCar().setNumber("1111").setColor("red").buildcar();
		 }
}
