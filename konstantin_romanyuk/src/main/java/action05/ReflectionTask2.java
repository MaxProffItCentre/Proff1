package action05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

//Написать метод, принимающий любой объект, выводящий список всех интерфейсов по иерархии наследования классов.
public class ReflectionTask2 {

	public static void main(String[] args) {
		List<Class[]> interfaces = getAllInterfaces(new ArrayList());
		Iterator<Class[]> iter=interfaces.iterator();
		while(iter.hasNext())System.out.println(Arrays.toString(iter.next()));
	}
	
	
	public static List<Class[]> getAllInterfaces(Object obj){
		List<Class> classes = new ArrayList<Class>();
		List<Class[]> interfaces=new ArrayList<Class[]>();
		classes.add(obj.getClass());
		interfaces.add(obj.getClass().getInterfaces());
		for(int i = 0; i<classes.size();i++){
			Class superCl = classes.get(i).getSuperclass();
			if(superCl!=null){classes.add(superCl);
			interfaces.add(superCl.getInterfaces());}
		}	
		
		return  interfaces;
	}
}
