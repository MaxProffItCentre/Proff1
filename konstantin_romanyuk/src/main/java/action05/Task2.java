package action05;

import java.util.ArrayList;

public class Task2 {
public static void main(String[] args) {
	ArrayList<String> arr=new ArrayList<String>();
	method(arr);
}
public static void method(Object obj){
	Class temp=obj.getClass();
	while (!(temp==null))
	{System.out.println(temp.toString());
	temp=temp.getSuperclass();
	}
	
}
}
