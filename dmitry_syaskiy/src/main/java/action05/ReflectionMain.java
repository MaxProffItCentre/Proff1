package action05;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;

public class ReflectionMain {
	public static ArrayList<Class> showClasses(Object obj){
		ArrayList<Class> list = new ArrayList<>();
		Class c = obj.getClass();
		Class temp;
		do{
			temp = c;
			list.add(temp);
			c = c.getSuperclass();
		}while(c!=null);
		return list;
	}

	public static void main(String[] args){
		String testReflection = "REFLECTION";
		Method[] stringMethods = testReflection.getClass().getMethods();
		for(Method m: stringMethods){
			System.out.println(m.getName());
		}
		System.out.println("");
		List<Class> list = showClasses(new ArrayList<>());
		for(Class c: list){
			System.out.println(c.getName());
		}
	}
}
