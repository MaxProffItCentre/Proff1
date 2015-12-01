package action03;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


import action04.MiniCalc;

public class TestCalc {

private MiniCalc calc;
	
	@Before
	public void setUp() throws Exception {
		calc = new MiniCalc();
	}
	public void inputString(String str) {
		char[] arr = str.toCharArray();
		for(char ch: arr){
			calc.inChar(ch);			 
		}		
	}
	public void inputNumberAssert(String str) {
		String res;
		for(int i =0; i < str.length(); i++){
			char ch = str.charAt(i);
			res = ""+Integer.parseInt(str.substring(0,i+1));
			calc.inChar(ch);
			System.out.println("res = "+res);
			System.out.println("calc = "+calc.printResult());
			assertTrue(res.equals(calc.printResult())); 
		}		
		System.out.println("Konec");
	}

	@Test
	public void firstNumberTest1() {
		String str = ""+(int)(1000*Math.random());
		System.out.println("STR =" +str);
		inputNumberAssert(str);
	}
	@Test
	public void firstNumberTest2() {
		inputNumberAssert("0");
	}
	@Test
	public void firstNumberTest3() {
		inputNumberAssert("000");
	}
	@Test
	public void firstNumberTest4() {
		inputNumberAssert("000"+(int)(10000*Math.random()));
	}	
	
	@Test
	public void checkOperationPlus() {
		inputString(""+(int)(1000*Math.random()));		
		String res = calc.printResult();
		calc.inChar('+');
		assertEquals(res,calc.printResult());
	}
	@Test
	public void checkOperationMinus() {
		inputString(""+(int)(1000*Math.random()));
		String res = calc.printResult();
		calc.inChar('-');
		assertEquals(res,calc.printResult());
	}
	@Test
	public void checkOperationMultiply() {
		inputString(""+(int)(1000*Math.random()));
		String res = calc.printResult();
		calc.inChar('*');
		assertEquals(res,calc.printResult());
	}
	@Test
	public void checkOperationDivide() {
		inputString(""+(int)(1000*Math.random()));
		String res = calc.printResult();
		calc.inChar('/');
		assertEquals(res,calc.printResult());
	}
	
	@Test
	public void secondNumberTest1() {
		char[] arr = new char[]{'+', '-', '*', '/'};
		inputString("" + (int)(1000*Math.random()) + arr[(int)(4*Math.random())]);
		
		String str = "" + (int)(1000*Math.random());
		inputNumberAssert(str);
	}
	@Test
	public void secondNumberTest2() {
		char[] arr = new char[]{'+', '-', '*', '/'};
		inputString("" + (int)(1000*Math.random()) + arr[(int)(4*Math.random())]);
		
		String str = "0" + (int)(1000*Math.random());
		inputNumberAssert(str);
	}
	@Test
	public void secondNumberTest3() {
		char[] arr = new char[]{'+', '-', '*', '/'};
		inputString("" + (int)(1000*Math.random()) + arr[(int)(4*Math.random())]);
		
		String str = "00" + (int)(1000*Math.random());
		inputNumberAssert(str);
	}
	@Test
	public void secondNumberTest4() {
		char[] arr = new char[]{'+', '-', '*', '/'};
		inputString("" + (int)(1000*Math.random()) + arr[(int)(4*Math.random())]);
		
		String str = "0";
		inputNumberAssert(str);
	}

}

