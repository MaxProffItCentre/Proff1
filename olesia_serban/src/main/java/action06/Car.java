package action06;

public class Car {
	private String color;
	private String number;

	private Car(BuilderCar b) {
		this.color = b.color;
		this.number = b.number;
	}

	@Override
	public String toString() {

		return color + " " + number;
	}

	public static class BuilderCar {
		private String color;
		private String number;

		public BuilderCar() {

		}

		public BuilderCar setColor(String color) {
			this.color = color;

			return this;
		}

		public BuilderCar setNumber(String number) {
			this.number = number;

			return this;
		}

		public Car build() {
			return new Car(this);
		}

	}

}
