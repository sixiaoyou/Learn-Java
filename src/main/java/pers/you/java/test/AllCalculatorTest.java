package pers.you.java.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@Suite.SuiteClasses({
	CalculatorTest.class,
	CalculatorTest2.class
})
public class AllCalculatorTest {

}
