package action05;

import java.util.ArrayList;
import java.util.Arrays;

//Вывести все методы класса String
//Написать метод, принимающий любой объект. Метод возвращает все классы, в иерархию которых входит данный объект
public class Task1 {
	public static void main(String[] args) {
		
		ArrayList<String> array = new ArrayList<>();
		Integer i = 0;
		System.out.println(array.getClass().toString());
//		System.out.println(Arrays.toString(String.class.getMethods()));
//		returnSuperClass(array, array);
//		System.out.println(array.toString());
		System.out.println(Arrays.toString(i.getClass().getClasses()));
	}
	
	public void foo(){
		
	}
	
//	public static void returnSuperClass(Object o, ArrayList<String> arr) {
//		if(o.getClass().getSuperclass() == null) {
//			return;
//		}
//		arr.add(o.getClass().getSuperclass().toString());
//		returnSuperClass(o.getClass().getSuperclass(), arr);
//	}
	
	public static void returnSuperClass(Object o, ArrayList<String> arr) {
		Class c = o.getClass();
		while(c != null) {
			arr.add(c.getName());
			c = c.getSuperclass();
		}
//		arr.add(o.getClass().getSuperclass().toString());
//		returnSuperClass(o.getClass().getSuperclass(), arr);
	}
	
}
