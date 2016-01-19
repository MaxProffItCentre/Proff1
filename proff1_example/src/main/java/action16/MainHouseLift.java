package action16;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainHouseLift {
	public static void main(String []args){
		
		//показываем Spring где лежит файл конфигурации
		ApplicationContext context = new ClassPathXmlApplicationContext("action16/config.xml");

        Lift lift = (Lift) context.getBean("lift");//указываем id нашего bean-а
        System.out.println(lift);
        
        House house = (House) context.getBean("house");
        System.out.println(house);
    }
}
