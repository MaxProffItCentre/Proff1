package action05;

import javafx.scene.Scene;

public abstract class AbstractProc implements Procable{
	private int result;
	private int temp;
	private char operation;
	GraficCalc graf=new GraficCalc();
	
	 @Override
	 public void printResult() {
	  System.out.println("Result = " + result);
	 
	 }
	 
	 protected void setOperation(char op){
		 operation=op;
	 }
	 
	 
	 
	 
	 public char getOperation(){
		 return operation;
	 }
	 
	 protected void setResult(int r){
	  result = r;
	 }
	 
	 public int getResult(){
	  return result;
	 }
	 
	 public String getResult2(){
		  return Integer.toString(result);
		 }
	 
	 protected void setTemp(int tp){
		 temp=tp;
	 }
	 
	 public int getTemp(){
		 return temp;
	 }
	
}