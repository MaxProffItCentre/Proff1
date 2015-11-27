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
	private static int result;
	private static int temp;
	private static int count=0;
	private static int countPlus=0;
	private static int countMinus=0;
	private static int countMultip=0;
	private static int countDivis=0;
	private static char lastSymb;
	
	private static char [] oper = {'+','-', '*', '/', '='};
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
				result = c - '0';
				count++;
			} else if (c == p && count != 0) {
				result = result*10 + (c - '0');
			}
		}
		} else {
		for (char c: oper) {
			//Операция добавления
			if (c == p && p == '+' && countPlus ==0) {
				countPlus++;
				count = 0;
				temp = result;
			} else if (c == p && p == '+' && countPlus !=0) {
				result = temp + result;
				count = 0;
				if (lastSymb == '+') {
					countPlus++;
					count = 0;
					temp = result;
				} else {
					countPlus = 0;
				}	
			} //Операция отнимания 
			else if (c == p && p == '-' && countMinus ==0) {
				countMinus++;
				count = 0;
				temp = result;
			} else if (c == p && p == '-' && countMinus !=0) {
				result = temp - result;
				count = 0;
				if (lastSymb == '-') {
					countMinus++;
					count = 0;
					temp = result;
				} else {
					countMinus = 0;
				}
			} //Операция умножения
			else if (c == p && p == '*' && countMultip ==0) {
				countMultip++;
				count = 0;
				temp = result;
			} else if (c == p && p == '*' && countMultip !=0) {
				result = temp * result;
				count = 0;
				if (lastSymb == '*') {
					countMultip++;
					count = 0;
					temp = result;
				} else {
					countMultip = 0;
				}
			} //Операция деления
			else if (c == p && p == '/' && countDivis ==0) {
				countDivis++;
				count = 0;
				temp = result;
			} else if (c == p && p == '/' && countDivis !=0) {
				result = temp / result;
				count = 0;
				if (lastSymb == '/') {
					countDivis++;
					count = 0;
					temp = result;
				} else {
					countDivis = 0;
				}
			}//Операция Равно
			else if (c == p && p == '=' && countPlus != 0) {
				result = temp + result;
				count = 0;
				countPlus = 0;
			} else if (c == p && p == '=' && countMinus != 0) {
				result = temp - result;
				count = 0;
				countMinus = 0;
			} else if (c == p && p == '=' && countMultip != 0) {
				result = temp * result;
				count = 0;
				countMultip = 0;
			} else if (c == p && p == '=' && countDivis != 0) {
				result = temp / result;
				count = 0;
				countDivis = 0;
			}
			lastSymb = p;
		}
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
		if (str.charAt(0) == '=') printResult();
		if (str.charAt(0) == '-' && countMinus > 1) printResult();
		if (str.charAt(0) == '+' && countPlus > 1) printResult();
		if (str.charAt(0) == '*' && countMultip > 1) printResult();
		if (str.charAt(0) == '/' && countDivis > 1) printResult();
		if (str.charAt(0) == 's') break;
		}
		
	}
	public static void main(String[] args) {
		MiniCalc calc = new MiniCalc();
		calc.getStarted();
	}
}
