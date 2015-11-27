package action04;

import java.util.ArrayList;

public class MiniCalc {
	private static int resultD=0;
	private int result=0;
	private int temp=0;
	private String action=null;
	private ArrayList<Integer> arrDisp = new ArrayList<Integer>();
			
	 

	public int getMulti(int a, int b)
	{
	int aCopy=a/2;
	return aCopy*2*b;}
	
	 public String printResult(){
		 String res;
		 if (this.action==null) res=""+resultD;
		 else res=""+result;
		return res;
		 
	 };
	 public void inChar(char p){
		 int tmp = (int)p;
		 int disp = 0;
		arrDisp.add(tmp);
		for(int j=0; j<arrDisp.size();j++)
			{disp=disp+arrDisp.get(arrDisp.size()-j-1)*(int)Math.pow(10, j);}
		resultD=disp;
		;	 
		 
	 }
	 public void inAction(String action){
		arrDisp.clear();
			 if (this.action==null)
			 {this.action=action;
		result=resultD;
		}
			 else
		 {switch (this.action)
				{case "+": result=result+resultD;
				resultD=0;
					break;
				case "-": result=result-resultD;
				resultD=0;
					break;
				case "*":result=result*resultD;
				resultD=0;
					break;
				case "/": 
					try{result=result/resultD;
				resultD=0;} 
				catch (Exception e){result=0;};
					break;
				default: result=temp;
					break;
				}
		 this.action=action; }
		 
	 }
	 
	public static void main(String[] args) {
		MiniCalc m1=new MiniCalc();
		m1.inChar((char)0);
		m1.inChar((char)0);
		m1.inChar((char) 7);
	System.out.println(resultD);
	m1.inAction("*");
	m1.inChar((char) 3);
	m1.inChar((char) 5);
	System.out.println(resultD);
	m1.inAction("/");
	m1.inChar((char) 8);
	System.out.println(resultD);
	m1.inAction("=");
	System.out.println(m1.printResult()); } 
	}
/*
 * Задание калькулятор:
Реализовать калькулятор в котором:
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
 
