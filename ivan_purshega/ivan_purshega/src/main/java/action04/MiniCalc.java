package action4;

import java.util.Scanner;

public class MiniCalc {
	private int result;
	private String previousResult = "";
	private char action = ' ';

	public int printResult() {

		return result;
	}

	public void inChar(char p) {
		if (action == ' ') {
			if (p != '+' && p != '-' && p != '/' && p != '*')
				result=new Integer(Integer.toString(result) + p);
			else  action = p;
		} else {
			if (p != '=') previousResult+=p;
			else {
				if(action=='-')result -= new Integer(previousResult);
				if(action=='+')result += new Integer(previousResult);
				if(action=='/')result /= new Integer(previousResult);
				if(action=='*')result *= new Integer(previousResult);
			}
		}
	}
}
