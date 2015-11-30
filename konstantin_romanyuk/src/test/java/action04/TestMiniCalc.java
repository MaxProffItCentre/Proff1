package action04;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestMiniCalc {

	@Test
	public void test() {
		MiniCalc app= new MiniCalc();
		if(app.getMulti(2, 2) !=4)
		fail("Not yet implemented");
		assertFalse("Oy!", app.getMulti(3, 2) ==6);
	}
	@Test
	public void testInputChar() {
		MiniCalc app= new MiniCalc();
		app.inChar((char)0);
		app.inChar((char)0);
		app.inChar((char)2);
		app.inChar((char)0);
		app.inChar((char)5);
		assertFalse("Oy!", app.printResult()=="205" );
			}
	@Test
	public void testInputAction() {
		MiniCalc app= new MiniCalc();
		app.inChar((char)2);
		app.inChar((char)0);
		app.inAction("*");
		assertFalse("Oy!", app.printResult()=="20");
		app.inChar((char)5);
		app.inAction("/");
		assertFalse("Oy!", app.printResult()=="100");
		app.inChar((char)7);
		app.inAction("=");
		assertFalse("Oy!", app.printResult()=="700");
	}
	@Test
	public void testInputCalculation() {
		MiniCalc app= new MiniCalc();
		app.inChar((char)2);
		app.inChar((char)0);
		app.inAction("=");
		assertFalse("Oy!", app.printResult()=="20");
		app.inChar((char)5);
		app.inAction("+");
		assertFalse("Oy!", app.printResult()=="5");
		app.inChar((char)7);
		app.inAction("=");
		assertFalse("Oy!", app.printResult()=="13");
	}
}
