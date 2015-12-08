package action06;


public class MainCar {
	public static void main(String[] args) {
		Car car1= new BuilderCar().setNumber("12345").setColor("red").build();
		System.out.println(car1.getNumber());
	}

	
}
