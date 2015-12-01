package action04;

import java.util.Scanner;

public class MiniCalc {
	private  int result;
	private int temp;
	private boolean flag;
	private char operation;
	
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public int getTemp() {
		return temp;
	}
	public void setTemp(int temp) {
		this.temp = temp;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public char getOperation() {
		return operation;
	}
	public void setOperation(char operation) {
		this.operation = operation;
	}
	public MiniCalc(){
		result = 0;
		temp = 0;
		flag = false;
	}
	public int getMulti(int a, int b){
		int aCopy = a/2;
		return aCopy * 2 *b;
	}
	public String printResult(){
		System.out.println("Result: " + result);
		return Integer.toString(result);
	}
	public void inChar(char p){
		if(!Character.isDigit(p)){
			if(p != '='){
				operation = p;
			}else{
				System.out.println("----------------");
				result = culc(operation);
			}
			flag = true;
		}else{
			if(!flag){
				if(result != 0){
					result *= 10;
				}
				result += Character.getNumericValue(p);
			}else{
				if(temp != 0){
					temp *= 10;
				}
				temp += Character.getNumericValue(p);
			}
		}
	}
	public int culc(char operation){
		switch(operation){
		case '+':
			result += temp;
			break;
		case '-':
			result -= temp;
			break;
		case '*':
			result *= temp;
			break;
		case '/':
			result /= temp;
			break;
		default:
			System.out.println("Input error!");
			break;
		}
		return result;
	}
	public void start(){
		Scanner scan = new Scanner(System.in);
		char in = '0'; 
		do{
			in = scan.nextLine().charAt(0);
			inChar(in);
			printResult();
		}while(in != '=');
	}
}
