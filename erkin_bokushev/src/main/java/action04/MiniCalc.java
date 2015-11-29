package action04;

import java.util.Scanner;

/*Реализовать калькулятор в котором:
	 - private int result;
	 - public String printResult();
	 - public void inChar(char p);
	Вводимые символы такие: цифры, +, -, *, / и знак =.
	Последовательность ввода такая: число1 + операция + число2 + равно.
	Написать модульный тест для проверки:
	1) корректного введения первого числа(проверяем например ввод 123 или 012 или 0005)
	2) корректного введения операции
	3) корректного введения второго числа
	4) корректного введения знака "=".*/

public class MiniCalc {
	private static int result=0;
	private static int temp;
	private static int count=0;
	private static int tempRavno;
	private static int countOper=0;
	private char lastSymb;
	private char tempLastSymb;
	public int countNull;
	//=============================================================================
	private static char [] numbers = {'0','1','2','3','4','5','6','7','8','9'};
	public int getMulti (int a, int b) {
		int aCopy = a/2;
		return aCopy * 2 * b;
	}
	public String printResult() {
		System.out.println("Result = " + result);
		return Integer.toString(result);
	}
	public void inChar(char p) {
		if (p != '+' && p != '-' && p != '*' && p != '/' && p != '=') {
		for (char c: numbers) {
			if (c == p && count == 0) {
				temp = c - '0';
				if(c == '0') {
					count = 0;
					countNull++;
				} else {
					count++;
				}
			} else if (c == p && count != 0) {
				temp = temp*10 + (c - '0');
			}
		}
		} else if (p == '+' || p == '-' || p == '*' || p == '/' || p == '=') {
			if (countOper == 0) result = temp;
			if (countOper > 0 && p != '=') {
				if (temp != 0) {
				switch (p) {
				case '+':
					result +=temp;
					break;
				case '-':
					result -=temp;
					break;
				case '*':
					result *=temp;
					break;
				case '/':
					result /=temp;
					break;
				}
				}
			}
			if (p == '=' && lastSymb != '=') {
				tempLastSymb = lastSymb;
				if (temp != 0) {
				switch (lastSymb) {
				case '+':
					result +=temp;
					break;
				case '-':
					result -=temp;
					break;
				case '*':
					result *=temp;
					break;
				case '/':
					result /=temp;
					break;
				}
				tempRavno = temp;
				}
				if (temp == 0) {
				tempRavno = result;
				switch (lastSymb) {
				case '+':
					result +=result;
					break;
				case '-':
					result -=result;
					break;
				case '*':
					result *=result;
					break;
				case '/':
					result /=result;
					break;
				}
				} 
			}
			if (p == '=' && lastSymb == '=' ) {
				switch (tempLastSymb) {
				case '+':
					result +=tempRavno;
					break;
				case '-':
					result -=tempRavno;
					break;
				case '*':
					result *=tempRavno;
					break;
				case '/':
					result /=tempRavno;
					break;
				}
			}
			temp = 0;
			count = 0;
			lastSymb = p;
			countOper ++;
			countNull = 0;
		}
	}
	public void getStarted () {
		Scanner scan = new Scanner(System.in);
		while (scan.hasNextLine()) {
		String str = scan.nextLine();
		if (str.length()>1) {
			System.out.println("Введено больше одного символа!");
			break;
		}
		inChar(str.charAt(0));
		if (str.charAt(0) == '=' || str.charAt(0) == '+' || str.charAt(0) == '-' || str.charAt(0) == '*' || str.charAt(0) == '/') {
			printResult();
//			break;
		}
		}
	}
	public static void main(String[] args) {
		MiniCalc calc = new MiniCalc();
		calc.getStarted();
	}
}
