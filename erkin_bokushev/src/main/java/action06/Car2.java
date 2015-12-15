package action06;

public class Car2 {
 private String number;
 private String color;
 
 private Car2(){
  
 }
 
 public String getNumber() {
  return number;
 }
 
 public String getColor() {
  return color;
  
 }
 
 public static BuilderCar newBuilderCar() {
        return new Car2().new BuilderCar();
    }
 
 
 
 @Override
 public String toString() {
  // TODO Auto-generated method stub
  
  return number + " " + color;
 }



 public class BuilderCar {
   
  
  private BuilderCar(){
   
  }
  
  public Car2 build(){
   return Car2.this;
  }
  
 
  public BuilderCar setNumber(String number) {
   Car2.this.number = number;
   return this;
  }

  public BuilderCar setColor(String color) {
   Car2.this.color = color;
   return this;
  }

 }
 
public static void main(String[] args) {
	Car2 car = Car2.newBuilderCar().setColor("Red").setNumber("AAAA").build();
	  System.out.println(car);
}

}