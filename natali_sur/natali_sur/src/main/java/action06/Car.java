package action06;

public class Car {
	private String number;
	private String colour;

	private Car(BuilderCar builder) {
		number = builder.getNumber();
		colour = builder.getColour();
	}

	@Override
	public String toString() {
		return "Car [number = " + number + ", colour = " + colour + "]";
	}

	static class BuilderCar {
		private String number;
		private String colour;

		private BuilderCar() {

		}

		public String getNumber() {
			return number;
		}

		public BuilderCar setNumber(String number) {
			this.number = number;
			return this;
		}

		public String getColour() {
			return colour;
		}

		public BuilderCar setColour(String colour) {
			this.colour = colour;
			return this;
		}

		public Car build() {
			return new Car(this);
		}

	}

	public static void main(String[] args) {
		Car car = new BuilderCar().setNumber("AA 1111").setColour("Red").build();
		System.out.println(car);
	}
}
