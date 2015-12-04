package action06;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Task1 {
	public static void main(String[] args) {
		List<String> classes = getAllClasses(new ArrayList());
		List<String> classes2 = getAllClasses(new HashMap());
		System.out.println(classes);
		System.out.println(classes2);

	}

	public static List<String> getAllClasses(Object o) {
		List<Class> list = new ArrayList<Class>();
		list.add(o.getClass());
		Class objectClass = o.getClass();
		while (objectClass.getSuperclass() != null) {
			list.add(objectClass.getSuperclass());
			objectClass = objectClass.getSuperclass();
		}
		List<String> names= new ArrayList<String>();
		for (int i = 0; i < list.size(); i++) {
			names.add(list.get(i).getName());
		}
		return names;

	}
}
