package HomeWork;

import java.util.Scanner;

public class MiniCalcDouble {
	private double result;
	private String previousResult1 = "";
	private String previousResult2 = "";
	private char action = ' ';


	public void printResult() {
		String str = Double.toString(result);;
		String delimiter =  "[.]+";
		String[] masiv = str.split(delimiter);
		if(masiv.length==2 && masiv[1].equals("0")) System.out.println((int)result);
		else System.out.println(result);
		
	}

	public void inChar(char p) {
		if (action == ' ') {
			if (p != '+' && p != '-' && p != '/' && p != '*')
				previousResult1+=p;
			else  action = p;
		} else {
			if (p != '=') previousResult2+=p;
			else {
				if(action=='-')result = new Double(previousResult1)-new Double(previousResult2);
				if(action=='+')result = new Double(previousResult1)+new Double(previousResult2);
				if(action=='/')result = new Double(previousResult1)/new Double(previousResult2);
				if(action=='*')result = new Double(previousResult1)*new Double(previousResult2);
			}
		}
	}
}


