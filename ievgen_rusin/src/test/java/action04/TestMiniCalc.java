package action04;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestMiniCalc {

	@Test
	public void test() {
		MiniCalc app = new MiniCalc();
		if(app.getMulti(3, 2) != 6) {
			fail("Not yet implemented");
		}
		assertTrue("Oy!", app.getMulti(3, 2) == 6);
	}
	
	/*
	 * 1) набор параметров
	 * 2) ожидаемый результат
	 * 3) фактический результат
	 * 
	 * fail
	 * assertTrue(сравнение) - ожидаемый результат. Если нет, то выводит сообщение
	 * assertFalse(сравнение)
	 * assertNull(сравнение)
	 * assertNotNull(сравнение)
	 * assertEquals(сравнение)
	 * */
	

}
