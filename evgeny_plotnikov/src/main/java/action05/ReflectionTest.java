package action05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class ReflectionTest {
	
	public static void main(String[] args) {
		
		String str = new String("3434");
		
		Class class1 = str.getClass();
		
//		System.out.println(class1.getName());
		
//		System.out.println(Arrays.toString(str.getClass().getMethods()));
	
		ArrayList a = new ArrayList();
		Integer b = new Integer(98);
		System.out.println((hierarchyInterfaces(a)));
	}
	
	public static ArrayList<Class> hierarchy(Object obj){
		
		ArrayList<Class> arr = new ArrayList<Class>();
		
		Class cl = obj.getClass();
			
		while(cl.getSuperclass() != null){
			arr.add(cl.getSuperclass());
			cl = cl.getSuperclass();
		}
		
		return arr;
	}
	
	public static ArrayList<Class> hierarchyInterfaces(Object obj){
		
		HashSet<Class> set = new HashSet<Class>();
		ArrayList<Class> arr = new ArrayList<Class>();
		
		Class cl = obj.getClass();
			
		while(cl.getSuperclass() != null){
			
			Class[] interfs = cl.getInterfaces();
			for(int i = 1; i < interfs.length; i++){
				set.add(interfs[i]);
				arr.add(interfs[i]);
			}
			
			cl = cl.getSuperclass();
		}
		
		return arr;
	}

}
