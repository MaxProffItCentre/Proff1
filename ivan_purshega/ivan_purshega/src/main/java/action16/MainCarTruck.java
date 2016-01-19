package action16;

	import java.util.Scanner;

	import org.springframework.context.ApplicationContext;
	import org.springframework.context.support.ClassPathXmlApplicationContext;

		public class MainCarTruck {
			public static void main(String[] args) {
				
				//показываем Spring где лежит файл конфигурации
				ApplicationContext context = new ClassPathXmlApplicationContext("action16/config2.xml");
				
				Human human = (Human) context.getBean("human");
		        System.out.println(human);

		        Truck truck = (Truck) context.getBean("truck");//указываем id нашего bean-а
		        System.out.println(truck);
		        
		        Car car = (Car) context.getBean("car");
		        System.out.println(car);
		    }
		}