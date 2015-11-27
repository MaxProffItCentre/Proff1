package action4;

import java.util.Scanner;

public class MainMiniCalcDouble {
	public static void main(String[] args) {
	
	MiniCalcDouble Calc = new MiniCalcDouble();
	
	System.out.println("Калькулятор запущен");
	
	Scanner scan = new Scanner(System.in);
	String str=scan.nextLine();

	while(str.charAt(0)!='+' && str.charAt(0)!='-' && str.charAt(0)!='/' && str.charAt(0)!='*'){
		Calc.inChar(str.charAt(0));
		str=scan.nextLine();
	}
	Calc.inChar(str.charAt(0));
	str=scan.nextLine();
	while(str.charAt(0)!='='){
		Calc.inChar(str.charAt(0));
		str=scan.nextLine();
	}
	Calc.inChar(str.charAt(0));
	Calc.printResult();
	}
}