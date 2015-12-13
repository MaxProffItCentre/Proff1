package action06;

public class Car1 {
	private String number;
	private String color;

	private Car1() {

	}

	public String getNumber() {
		return number;
	}

	public String getColor() {
		return color;

	}

	public static BuilderCar newBuilderCar() {
		return new Car1().new BuilderCar();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub

		return number + " " + color;
	}

	public class BuilderCar {

		private BuilderCar() {

		}

		public Car1 build() {
			return Car1.this;
		}

		public BuilderCar setNumber(String number) {
			Car1.this.number = number;
			return this;
		}

		public BuilderCar setColor(String color) {
			Car1.this.color = color;
			return this;
		}

	}

	public static void main(String[] args) {
		Car1 car = Car1.newBuilderCar().setColor("Red").setNumber("AAAA").build();
		System.out.println(car);
	}
}
