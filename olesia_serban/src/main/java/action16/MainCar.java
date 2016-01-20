package action16;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainCar {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("action16/car_config.xml");
		/*Human human = (Human)context.getBean("human");
		Truck truck = ()*/
		Car car = (Car) context.getBean("car");
		System.out.println(car);
		
	}
}
