package action06;

public class Main {
	public static void main(String[] args) {
		Car car = new Car.BuilderCar().setColor("red").setNumber("BC 8986").build();
		System.out.println(car);
	}
}
