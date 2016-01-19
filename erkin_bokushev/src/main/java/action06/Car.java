package action06;

/*Builder:
Car car = new BuilderCar().setNumber("AA 1111").setColor("Red").build();*/

public class Car {
	private int number;
	private String color;
	
	Car (BuilderCar builder) {
		number = builder.getNumber();
		color = builder.getColor();
	};
	public static void main(String[] args) {
		Car car = new BuilderCar().setColor("red").setNumber(111).build();
	}
	
	 static class BuilderCar {
		private int number;
		private String color;
		public BuilderCar () {
	
		}
		public int getNumber() {
			return number;
		}
		public BuilderCar setNumber(int number) {
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
		public Car build () {
			return new Car(this);
		}
		
	}	
	
}
