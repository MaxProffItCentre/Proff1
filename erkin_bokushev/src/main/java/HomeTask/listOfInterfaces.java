
package HomeTask;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

import com.sun.scenario.effect.Reflection;

//Задача1. Написать метод, принимающий любой объект, выводящий список всех интерфейсов по иерархии наследования классов.

public class listOfInterfaces {
	public static void main(String[] args) {
	System.out.println(listInterf(new Integer(0)));	
	}
	
	public static ArrayList<String> listInterf (Object obj) {
		Class [] interf = obj.getClass().getInterfaces();
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<Class> classes = new ArrayList<Class>();
		classes.add(obj.getClass());
		for (int i = 0; i < classes.size(); i ++) {
			Class supCl = classes.get(i).getSuperclass();
			if (supCl != null) classes.add(supCl);
				Class [] temp = classes.get(i).getInterfaces();
				int k = 0;
				for (Class c: temp){
					if (k == 0 && temp.length == 1)list.add("Interfaces of " + classes.get(i).getSimpleName() + " :<" + c.getSimpleName() + ">");
					if (k == 0 && temp.length > 1)list.add("Interfaces of " + classes.get(i).getSimpleName() + " :<" + c.getSimpleName());
					if (k < temp.length-1 && k>0) list.add(c.getSimpleName());
					if (k == temp.length-1 && k != 0) list.add(c.getSimpleName() + ">");
					k++;
				}
		}
		return list;
	}
		
}

