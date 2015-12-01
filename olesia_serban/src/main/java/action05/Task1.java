package action05;

import java.lang.reflect.Method;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;


public class Task1 {
	public static void main(String[] args) {
		String str = "sth";
		Method[] meth= str.getClass().getMethods();
		
//		System.out.println(Arrays.toString(meth));
		System.out.println(Arrays.toString(hierarchy(new ArrayList<Object>())));
	}
	
	public static Class<?>[] hierarchy(Object o){
		
		return o.getClass().getClasses();
	
	}
	public static Array [] interfaces(Object o){
		return null;
		
	}
	
}
