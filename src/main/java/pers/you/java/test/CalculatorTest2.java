package pers.you.java.test;

import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;




@RunWith(Parameterized.class)
public class CalculatorTest2 {
	private static Calculator calculator = new Calculator();
	private int param;
	private int result;
	
	@Parameters
	public static Collection data(){
		return Arrays.asList(new Object[][]{
			{2,4},
			{0,0},
			{-3,9},
		});
	}
	
//构造函数,对变量初始化
	 public CalculatorTest2(int param,int result){
		// TODO Auto-generated constructor stub
		this.param = param;
		this.result = result;
	}


	@Test
	public void testSquare() {
			calculator.square(param);
			assertEquals(result,calculator.getResult());
	
	}

}
