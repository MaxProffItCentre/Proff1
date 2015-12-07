package action05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
<<<<<<< HEAD
	�������� ����� ����������� ����� ������.
����� ���������� ��� ������ � �������� ������� ������ ������ ������. 
=======
 	Написать метод принимающий любой объект.
Метод возвращает все классы в иерархию которых входит данный объект. 
>>>>>>> branch 'master' of https://github.com/MaxProffItCentre/Proff1.git
*/
public class ReflectionTask1Example {
	public static void main(String[] args) {
		Class[] classes = getAllClasses(new ArrayList());
		System.out.println(Arrays.toString(classes));
		
		
		
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
