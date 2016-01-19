package action06;

import java.util.Date;

public class FactoryMethodPattrenExample {
	 public static void main(String[] args) {
	  FactoryRoom iRoom1 = new FactorySklad(); 
	  FactoryRoom iRoom2 = new FactoryManuf();
	  
	  Room room1 = iRoom1.factoryMethod();
	  Room room2 = iRoom2.factoryMethod();
	  
	  System.out.println(room1.getClass());
	  System.out.println(room2.getClass());
	 }
	}
	interface Room{
	}
	class Sklad implements Room{
	 private String name;
	 private Employee storeKeeper; 
	}
	class ManufactureDepartment implements Room{
	 private String name;
	 private Employee master;
	}
	class Employee{
	 private String name;
	 private Date startJob;
	 private int age;
	}

	interface FactoryRoom{
	 public Room factoryMethod();
	}
	class FactorySklad implements FactoryRoom{
	 @Override
	 public Room factoryMethod() {
	  return new Sklad();
	 } 
	}
	class FactoryManuf implements FactoryRoom{
	 @Override
	 public Room factoryMethod() {
	  return new ManufactureDepartment();
	 } 
	}
