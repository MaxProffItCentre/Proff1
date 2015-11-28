package action05;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;


public class Task1 {
	public static void main(String[] args) {
		HashSet obj1 = new HashSet(10);
		Object obj2 = new TreeSet();
		System.out.println(getGeneralSuperClass(obj1, obj2));
	}
	public static String getGeneralSuperClass(HashSet obj1,Object obj2){
		MyClass obj = new MyClass(); 
				
		Class[] classes = obj.getClass().getInterfaces();
		for(Class one:classes){
			System.out.println(one.getCanonicalName());
		}
		System.out.println("**************");
		Class cl = obj1.getClass().getSuperclass();
		System.out.println(cl.getCanonicalName()+", "+cl.getName()+", "+cl.getTypeName());
		System.out.println("******************");
		
		System.out.print("Перечень методов: ");
		Method[] methods = obj.getClass().getDeclaredMethods();
		StringBuffer strMetods = new StringBuffer();
		for(Method method:methods){
			strMetods.append("\n" + method.getName() +"( "+ method.getParameterCount()+" параметра) возвращает " 
					+ method.getReturnType().getSimpleName());
			Annotation[] annots = method.getAnnotations();
			System.out.println("annots.length="+annots.length);
			for(Annotation ann:annots)
				strMetods.append(", аннотация "+ann.toString());
		}
		System.out.println(strMetods.toString()); 
		
		System.out.println("************qweqwe**************************");
		Annotation[] annots1 = obj.getClass().getAnnotations();
		System.out.println("annots1.length="+annots1.length);
		
		System.out.println("**************************************");
		
		Set<Type> set = new HashSet<Type>();
		//
		//Type superType = obj1.getClass().getGenericSuperclass();
		Type superType = obj1.getClass();
		System.out.println("ob1="+superType);
		System.out.println();
		Type superTypeOld=null;
		while(superTypeOld!=superType){
			superTypeOld = superType;
			System.out.println("ob1="+superType);
			set.add(superType);
			superType = superType.getClass().getSuperclass();
			System.out.println("	ob1="+superType);
			
		}
		System.out.println("**************");
		System.out.println(set);
		if(1==1)return "";
		superType = obj2.getClass().getGenericSuperclass();
		System.out.println("ob2="+superType);
		superTypeOld=null;
		while(superTypeOld.getClass()!=superType.getClass()){
			superTypeOld = superType;
			System.out.println("ob2="+superType);
			if(set.contains(superType)) return superType.getTypeName(); 
			superType = superType.getClass().getGenericSuperclass();
		}
		System.out.println(set);
		
		//String obj = new String("example");

		System.out.println("isInterface="+obj.getClass().isInterface());
		System.out.println("toGenericString="+obj.getClass().toGenericString());
		System.out.println("toString="+obj.getClass().toString());
		
		Type[] types = obj.getClass().getGenericInterfaces();
		StringBuffer sb = new StringBuffer();
		for(Type type:types) sb.append(type.getTypeName()+", ");
		System.out.println("Types(getTypeName): "+sb.toString());
		
		sb = new StringBuffer();
		for(Type type:types) sb.append(type.getClass().getSimpleName()+", ");
		System.out.println("Types(getSimpleName): "+sb.toString());
		/*
		Type superType = obj.getClass().getGenericSuperclass();
		System.out.println("Супер класс: " + superType.getTypeName());
		
		Type superSuperType = superType.getClass().getGenericSuperclass();
		System.out.println("Супер супер класс: " + superSuperType.getTypeName());

		Type superSuperType1 = superSuperType.getClass().getGenericSuperclass();
		System.out.println("Супер супер1 класс: " + superSuperType1.getTypeName());
		Type superSuperType2 = superSuperType1.getClass().getGenericSuperclass();
		System.out.println("Супер супер1 класс: " + superSuperType2.getTypeName());
		*/
		return "";
		
	}
}
