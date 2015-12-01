package action05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

//import java.lang.reflect*;



public class Task1 {
	
	public static void main(String[] args) {

		ArrayList aList= new ArrayList();
		
		String str = "ABC";
		System.out.println(Arrays.toString(str.getClass().getMethods()));
		
		System.out.println(Arrays.toString(Task1.myGetClasses(new HashMap<String,Object>())));
		
	}
	
	public static Class<?>[] myGetClasses(Object obj){
		
		return obj.getClass().getClasses();
			
	}

}
