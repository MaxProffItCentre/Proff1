package action05;

import java.lang.reflect.*;
import java.util.ArrayList;
//import java.lang.reflect.Method;
import java.util.Arrays;

public class ReflectString {
	private ReflectString(){
		
	}
	public  void main(String[] args) {
//		String teststr = "test";
//		Method[] met = teststr.getClass().getMethods();
//		Field[] field = teststr.getClass().getFields(); 
//		System.out.println(Arrays.toString(met));
//		System.out.println(Arrays.toString(field));
		ArrayList list = new ArrayList();
		viewClass(list);
		//System.out.println(Object.getClass().getSuperclass());
		ReflectString rf = new ReflectString();
		
	}
	
	public static <T> void viewClass(T obj){
		Class cl = obj.getClass().getSuperclass();
		while(cl != null){
			System.out.println(cl.getName());
			cl = cl.getSuperclass();
		}
	}

}
