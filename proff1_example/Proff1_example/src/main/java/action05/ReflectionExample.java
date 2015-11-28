package action05;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionExample {
	public static void main(String[] args) {
		String obj = new String();
		
		System.out.print("Перечень полей: ");
		Field[] fields = obj.getClass().getDeclaredFields();
		StringBuffer strFields = new StringBuffer();
		String delimiter = "";
		for(Field field:fields){
			strFields.append(delimiter + field.getName());
			delimiter = ", ";
		}
		System.out.println(strFields.toString());

		System.out.print("Перечень методов: ");
		Method[] methods = obj.getClass().getDeclaredMethods();
		StringBuffer strMetods = new StringBuffer();
		delimiter = "\n";
		for(Method method:methods){
			strMetods.append(delimiter + method.getName() +"( "+ method.getParameterCount()+" параметра) возвращает " + method.getReturnType().getSimpleName());
		}
		System.out.println(strMetods.toString()); 
		
	}

	@Override
	public String toString() {
		return "Task1 []";
	}
	
}
