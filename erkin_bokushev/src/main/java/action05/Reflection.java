package action05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

//Задача1: Вывести все методы класса String
/*Задача2: Написать метод принимающий любой обьект. 
 * Метод возвращает все классы в иерархию которых входит данный обьект*/
//Задача3: Написать метод, принимающий любой объект, выводящий список всех интерфейсов по иерархии наследования классов.

public class Reflection {
	public static void main(String[] args) {
//		String str = new String();
//		Method [] methods = str.getClass().getMethods();
//		for (Method m: methods) {
//			System.out.println(m);	
//		}
//		Class [] classe = myMethod(new ArrayList<>());
//		System.out.println(Arrays.toString(classe));
		
		Class [] classe = myMethod(new LinkedList<>());
		System.out.println(Arrays.toString(classe));
	}
	public static Class [] myMethod (Object obj) {
			ArrayList<Class> list = new ArrayList<Class>();
			list.add(obj.getClass());
			for (int i = 0; i<list.size(); i++) {
				Class superCl = list.get(i).getSuperclass();
				if (superCl != null) list.add(superCl);
			}
			return list.toArray(new Class[0]);
		}
	public static Class[] myMethodInterf (Object obj) {
		Class [] classes = myMethod(obj);
		ArrayList<Class> interfaces = new ArrayList<>();
		for (int i =0; i<classes.length; i++) {
			Class[] interf = classes[i].getInterfaces();
			if (interf != null) {
				for (Class in : interf) {
					if (in != null) interfaces.add(in);
				}
			}
		}
		return interfaces.toArray(new Class[0]);
	}
}
