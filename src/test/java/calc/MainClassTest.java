package calc;

import java.util.Arrays;
import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

import com.text.calc.MainClass;
import com.text.calc.exception.InvalidExpressionException;

public class MainClassTest {

	
	@Test
	public void testCalculate() throws InvalidExpressionException {
		Assert.assertEquals(new Double(4.0), new Double(MainClass.calculate(Arrays.asList("2","+","2"))));
	}
	
	@Test(expected=InvalidExpressionException.class)
	public void testCalculateException() throws InvalidExpressionException {
		Assert.assertEquals(new Double(4.0), new Double(MainClass.calculate(Arrays.asList("2","+","+","3"))));
	}

	@Test
	public void testRemoveFromStackAndEvaluate() throws InvalidExpressionException {
		Stack<Double> operandStack = new Stack<>();
		Stack<Character> operatorStack = new Stack<>();
		operandStack.push(2.0);
		operandStack.push(3.0);
		operatorStack.push('+');
		MainClass.removeFromStackAndEvaluate(operandStack, operatorStack);
		Assert.assertEquals(new Double(5.0), operandStack.pop());
	}
}
