package calc;

import org.junit.Assert;
import org.junit.Test;

import com.text.calc.operation.CalcUtil;

public class CalcUtilTest {

	@Test
	public void testCalc() {
		Assert.assertEquals(new Double(7.0), CalcUtil.calc('+', 2.0 , 5.0));
		Assert.assertEquals(new Double(25.0), CalcUtil.calc('^', 2.0 , 5.0));
	}
}
