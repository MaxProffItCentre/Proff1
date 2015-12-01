package action04;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestMiniCalc {
	MiniCalc miniCalc;
	
	@Before
	public void initMiniCalc(){
		miniCalc = new MiniCalc();
	}
	@Test
	public void testFirstNumber(){
		miniCalc.inChar('0');
		miniCalc.inChar('0');
		miniCalc.inChar('7');
		miniCalc.inChar('0');
		miniCalc.inChar('7');
		assertEquals("Error! Enter zero before the number does not give the correct result","707" ,miniCalc.printResult());
		
	}
	@Test
	public void testSecondNumber(){
		miniCalc.setFlag(true);
		miniCalc.inChar('0');
		miniCalc.inChar('0');
		miniCalc.inChar('7');
		miniCalc.inChar('0');
		miniCalc.inChar('7');
		assertEquals("Error! Enter zero before the number does not give the correct result",707,miniCalc.getTemp());
	}
	@Test
	public void testOperation(){
		miniCalc.inChar('+');
		assertEquals("Error! Not equal operations.", '+', miniCalc.getOperation());
		
	}
	@Test
	public void testEqualMark(){
		miniCalc.inChar('7');
		miniCalc.inChar('+');
		String result = miniCalc.printResult();
		miniCalc.inChar('7');
		miniCalc.inChar('=');
		if( result.equals(miniCalc.printResult())){
			fail("Error! Can't recognize equal mark.");
		}
	}
	@Test
	public void testCorrectOperationResult(){
		miniCalc.inChar('0');
		miniCalc.inChar('7');
		miniCalc.inChar('7');
		miniCalc.inChar('/');
		miniCalc.inChar('7');
		miniCalc.inChar('=');
		assertEquals("Error! Not equal operations.", "11" , miniCalc.printResult());
	}
}
