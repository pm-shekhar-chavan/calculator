package calc;

import org.junit.Assert;
import org.junit.Test;

import com.text.calc.common.util.CommonUtil;

public class CommonUtilTest {

	@Test
	public void testIsHighOrSamePrecedence() {
		Assert.assertEquals(true, CommonUtil.isHighOrSamePrecedence("+", "*"));
		Assert.assertEquals(false, CommonUtil.isHighOrSamePrecedence("*", "-"));
	}
	
	
	@Test
	public void testIsNumber() {
		Assert.assertEquals(true, CommonUtil.isNumber("123"));
		Assert.assertEquals(false, CommonUtil.isNumber("aa"));
	}
	@Test
	public void testIsArithmaticOperator() {
		Assert.assertEquals(true, CommonUtil.isArithmaticOperator("+"));
		Assert.assertEquals(false, CommonUtil.isArithmaticOperator("("));
	}

}
