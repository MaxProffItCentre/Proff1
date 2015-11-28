package action05;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 Написать метод, принимающий любой объект, выводящий список всех интерфейсов 
 по иерархии наследования классов.
 */
public class Proff1Task3 {
	public static void main(String[] args) throws ClassNotFoundException {
		//Object obj="";
		String s = "Integer";
		Class obj=Class.forName("Integer").getClass();
		System.out.println(Arrays.toString(obj.getClass().getFields()));
		System.out.println(Arrays.toString(obj.getClass().getDeclaredFields()));
		System.out.println(Arrays.toString(obj.getClass().getMethods()));
		System.out.println();
		
		Method method = obj.getClass().getMethods()[0];
		System.out.println("nameMethod = " + method.getName());
		System.out.println("retTypeMethod = " + method.getReturnType());
		System.out.println("paramTypesMethod = " + method.getParameterTypes()[0].getName());
		System.out.println();
		
		Field field = "".getClass().getFields()[0];
		System.out.println("nameField = " + field.getName());
		System.out.println("typeField = " + field.getType());
		
	}

}

