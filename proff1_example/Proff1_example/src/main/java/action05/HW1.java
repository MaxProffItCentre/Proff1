package action05;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 Написать метод, принимающий любой объект, выводящий список всех интерфейсов 
 по иерархии наследования классов.
 */
public class HW1 {
	public static void main(String[] args) {
		//Class[] interfes = getAllInterfaces(new ArrayList()); 
//		System.out.println(Arrays.toString("".getClass().getFields()));
//		System.out.println(Arrays.toString("".getClass().getDeclaredFields()));
		System.out.println(Arrays.toString("".getClass().getMethods()));
		System.out.println("".getClass().getMethods().length);
		Method obj = "".getClass().getMethods()[0];
		System.out.println(obj.getName());
		System.out.println(obj.getReturnType());
		System.out.println(obj.getParameterTypes()[0].getName());
		Field f = "".getClass().getFields()[0];
		
	}
//	public static Class[] getAllInterfaces(Object obj){
//		//obj.getClass().getd
//	}
	public static Class[] getInterfacesByClass(Object obj){
		Class[] interfes = obj.getClass().getInterfaces();
		return interfes;
	}
	public static Class[] getAllClasses(Object obj){
		List<Class> classes = new ArrayList<Class>();
		classes.add(obj.getClass());
		for(int i = 0; i<classes.size();i++){
			Class superCl = classes.get(i).getSuperclass();
			if(superCl!=null)classes.add(superCl);
		}	
		return classes.toArray(new Class[0]);
	}
}

