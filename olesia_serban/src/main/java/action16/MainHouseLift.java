package action16;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainHouseLift {
	public static void main(String []args){
		
		
		ApplicationContext context = new ClassPathXmlApplicationContext("action16/config.xml");

        Lift lift = (Lift) context.getBean("lift");
        System.out.println(lift);
        
        House house = (House) context.getBean("house");
        System.out.println(house);
    }
}
