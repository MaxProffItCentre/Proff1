package action05;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;

public class OtherExample {
	public static void main(String[] args) {
		//String obj = new String("example");
		ArrayList obj = new ArrayList();
		System.out.println("isInterface="+obj.getClass().isInterface());
		System.out.println("toGenericString="+obj.getClass().toGenericString());
		System.out.println("toString="+obj.getClass().toString());
		obj.getClass().
		Type[] types = obj.getClass().getGenericInterfaces();
		StringBuffer sb = new StringBuffer();
		for(Type type:types) sb.append(type.getTypeName()+", ");
		System.out.println("Types(getTypeName): "+sb.toString());
		
		sb = new StringBuffer();
		for(Type type:types) sb.append(type.getClass().getSimpleName()+", ");
		System.out.println("Types(getSimpleName): "+sb.toString());
		
		Type superType = obj.getClass().getGenericSuperclass();
		System.out.println("Супер класс: " + superType.getTypeName());
		
		Type superSuperType = superType.getClass().getGenericSuperclass();
		System.out.println("Супер супер класс: " + superSuperType.getTypeName());
	}
}
