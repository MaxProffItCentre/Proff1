package action04;

import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;
/*Вводимые символы такие: цифры, +, -, *, / и знак =.
Последовательность ввода такая: число1 + операция + число2 + равно.
Написать модульный тест для проверки:
1) корректного введения первого числа(проверяем например ввод 123 или 012 или 0005)
2) корректного введения операции
3) корректного введения второго числа
4) корректного введения знака "=".*/

public class TestMiniCalc {

	@Test
	public void test() {
		MiniCalc app = new MiniCalc();
		Scanner scan = new Scanner(System.in);
		char [] numbers = {'0','1','2','3','4','5','6','7','8','9'};
		int operation =1;
		int countNull1= 0; int countNull2 = 0;
		char op = ' ';
		while (scan.hasNextLine()) {
			String str = scan.nextLine();
			String message1 = "Неверно введено первое число! Нулей вначале числа - " + countNull1;
			String message2 = "Неверно введено второе число! Нулей вначале числа - " + countNull2;
			int oper = 0;
			switch (operation) {
			case 1:
				countNull1 = app.countNull;
				app.inChar(str.charAt(0));
				for (char c: numbers) {
					if (c == str.charAt(0)) oper = 1;
				} 
				if (oper != 1){
					operation = 2;
					op = str.charAt(0);
					assertTrue(message1, countNull1 == 0);
					if (op != '+' && op != '-' && op != '*' && op != '/') fail("Неверно введена операция!");
				}
				break;
			case 2:
				countNull2 = app.countNull;
				app.inChar(str.charAt(0));
				for (char c: numbers) {
					if (c == str.charAt(0)) oper = 1;
				}
				if (oper != 1) {
					operation = 3;
					op = str.charAt(0);
					assertTrue(message2, countNull2 == 0);
					if (op != '=') fail("Неверно веден знак равно!");
					if (op == '=') app.printResult();
				}
				break;
			case 3:
				System.out.println("Тестирование прошло успешно!");
				operation = 4;
				break;
			}
		if (operation == 4) break;	
		}	
		
//		if (app.getMulti(2, 2) != 4) 
//		fail("Not yet implemented");
//		
//		assertTrue("Oy!", app.getMulti(3, 2) == 6);	
		}
	}




