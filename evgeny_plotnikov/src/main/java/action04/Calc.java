package action04;

import java.util.Scanner;

public class Calc {
	
	private int result;
	private String oper = "";
	private String ravno;
	private int first;
	private int second;
	private String strfirst = "";
	private String strsecond = "";

	public void calcResult(String strfirst, String strsecond, String oper){
		first = new Integer(strfirst);
		second = new Integer(strsecond);
		
		if(oper.equals("+")){
			this.result = first + second;
		}
		if(oper.equals("-")){
			this.result = first - second;
		}
		if(oper.equals("*")){
			this.result = first * second;
		}
		if(oper.equals("/") && second != 0){
			this.result = first / second;
		}
	}
	
	public String printResult(){
		if(second == 0 && oper.equals("/")){
			return "Деление на 0 некорректно";
		} else {
			return(this.first + " " + this.oper + " " + this.second + " = " + this.result);
		}
	}
	
	public char toChar(String s){
		return s.charAt(0);
	}
	
	public void inChar(char p){
		
		if(p != '='){
			if(this.oper == ""){
				if(Character.isDigit(p)){
				this.strfirst += p;
				} else if(p == '+' || p == '-' || p == '*' || p == '/') {
					this.oper = p + "";
				}
			} else if(Character.isDigit(p)){
				this.strsecond += p;
			}
		} else {
			this.ravno = "=";
			calcResult(strfirst, strsecond, oper);
		}
	}
	
	public String enter(){
		Scanner scan = new Scanner(System.in);
		String entered = scan.next();
//		scan.close();
		return entered;
	}
	
	
	public static void main(String[] args) {
		
		Calc calc = new Calc();
		while(calc.ravno != "="){
			calc.inChar(calc.toChar(calc.enter()));
		}
				
		System.out.println(calc.printResult());
	}
}






