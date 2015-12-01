package action04;

import java.util.Scanner;

public class MiniCalc {
	private int result;
	private int previousResult;
	private char action = ' ';

	public String printResult() {

		return result+"";
	}

;
		
	public void inChar(char p) {
		if (action == ' ') {
			if (p != '+' && p != '-' && p != '/' && p != '*')
				previousResult=new Integer(Integer.toString(previousResult) + p);
			else  action = p;
		} else {
			if (p != '=') result=new Integer(Integer.toString(result) + p);
			else {
				if(action=='+') result = previousResult + result;
				if(action=='-') result = previousResult - result;
				if(action=='*') result = previousResult * result;
				if(action=='/') {
					if(result==0)result = 0;
					else result=previousResult / result;
				}
				action=' ';
				previousResult=0;
			}
		}
	}
}
