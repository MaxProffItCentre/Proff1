package action04;

import java.util.Scanner;



public class MainMiniCalc {
	public static void main(String[] args) {
	
	MiniCalc Calc = new MiniCalc();
	
	System.out.println("����������� �������");
	
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
		Calc.printResult();
	}
	Calc.inChar(str.charAt(0));
	System.out.println(Calc.printResult());
	}
}