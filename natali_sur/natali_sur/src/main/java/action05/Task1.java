package action05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Задача 1. Вывести все методы класса String
//Задача 2. Написать метод принимающий любой объект. Метод возвращает все классыв иерархию которых входит данный объкт.
//Задача 3. Написать метод, принимающий любой объект, выводящий список всех интерфейсов по иерархии наследования классов.

public class Task1 {
	public static void main(String[] args) {
		String str = "ffffoooo";
		System.out.println(str.getClass().getMethods());
		Class[] classes = getAllClasses(new ArrayList());
		System.out.println(Arrays.toString(classes));
}

	public static Class[] getAllClasses(Object obj) {
		List<Class> cl = new ArrayList<Class>();
		cl.add(obj.getClass());
		for(int i = 0; i<cl.size();i++){
			Class superCl = cl.get(i).getSuperclass();
			if(superCl!=null)cl.add(superCl);
		}	
		return cl.toArray(new Class[0]);
	}
}