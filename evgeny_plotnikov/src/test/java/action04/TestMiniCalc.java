package action04;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestMiniCalc {

	@Test
	public void test() {
		MiniCalc app = new MiniCalc();
		if(app.getMulti(2, 2) !=4)
		fail("Not yet implemented");
		assertTrue("Oy!", app.getMulti(3, 2) == 6);
	
		
	}
	
}


