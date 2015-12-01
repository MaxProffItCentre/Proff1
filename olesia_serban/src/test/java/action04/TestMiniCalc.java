package action04;

import static org.junit.Assert.*;

import org.junit.Test;



public class TestMiniCalc {

	@Test
	public void test() {
		MiniCalc application = new MiniCalc();
		if (application.getMulti(2, 2) != 4)
			fail("Not yet implemented");
		assertTrue("Oy!", application.getMulti(3, 2) == 6);
	}

}
