package action06;

public class Main {

	public static void main(String[] args) {
		
		Server ser = Server.getInctance();
		
		System.out.println(ser);
		
		Server ser2 = ser.getInctance();
		System.out.println(ser == ser2);
		
		Car car = Car.newBuilderCar().setColor("Red").setNumber("AAAA").build();
		System.out.println(car);
		
	}

}
