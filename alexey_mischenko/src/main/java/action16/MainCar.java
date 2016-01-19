package action16;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainCar {
	 public static void main(String []args){
		  
		  //показываем Spring где лежит файл конфигурации
		  ApplicationContext context = new ClassPathXmlApplicationContext("action16/configCar.xml");

		        Car car = (Car) context.getBean("car");//указываем id нашего bean-а
		        System.out.println(car);
		        
//		        House house = (House) context.getBean("house");
//		        System.out.println(house);
		    }
		}
