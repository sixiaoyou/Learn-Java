package pers.you.java.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CalculatorTest1 {
	private static Calculator calculator = new Calculator();

	@Before
	public void setUp() throws Exception {
		calculator.clear();
	}
	
	@Test
	public void testSquare1() {
		calculator.square(2);
		assertEquals(4,calculator.getResult());
	}
	
	@Test
	public void testSquare2() {
			calculator.square(0);
			assertEquals(0, calculator.getResult());
	}
	
	@Test
	public void testSquare3() {
		calculator.square(-3);
		assertEquals(9, calculator.getResult());
	}
}
