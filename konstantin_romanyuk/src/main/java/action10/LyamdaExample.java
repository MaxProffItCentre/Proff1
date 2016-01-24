package action10;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class LyamdaExample {
 public static void main(String[] args) {
  List<String> list = new ArrayList<String>();
  list.add("abc");
  list.add("tuy");
  list.add("brkd");
  list.forEach(new Consumer<String>(){
   @Override
   public void accept(String obj) {
    System.out.print(obj+",");   
   }   
  });
  System.out.println();
  list.forEach(obj->System.out.print(obj+","));
  //
  //list.removeIf(obj->obj.equals("abc"));
  list.removeIf(new Predicate<String>(){

   @Override
   public boolean test(String obj) {
    return obj.equals("abc");
   }
   
  });
  System.out.println();
  System.out.println(list);
  
 } 
 
}
