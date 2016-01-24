package action16;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class House {
private Lift lift;
private String number;

public House() {
	super();
}
public House(Lift lift, String number) {
	super();
	this.lift = lift;
	this.number = number;
}
public House(String number) {
	super();
	this.number = number;
}
public Lift getLift() {
	return lift;
}
public void setLift(Lift lift) {
	this.lift = lift;
}
public String getNumber() {
	return number;
}
public void setNumber(String number) {
	this.number = number;
}
public House getInstance(){
	ApplicationContext context = new ClassPathXmlApplicationContext("action16/config.xml");
	House house=(House)context.getBean("house")	;
return house;}

@Override
public String toString() {
	return "House [lift=" + lift + ", number=" + number + "]";
}

}
