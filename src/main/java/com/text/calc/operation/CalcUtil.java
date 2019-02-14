package com.text.calc.operation;

public class CalcUtil {

	public static Double calculate(Double d1, Double d2, Operation operation) {
		return operation.calculate(d1, d2);
	}
	
	public static Operation add = (d1, d2) -> d1 + d2;
	public static Operation sub = (d1, d2) -> d1 - d2;
	public static Operation mult = (d1, d2) -> d1 * d2;
	public static Operation div = (d1, d2) -> d1 / d2;
	public static Operation pow = (d1, d2) -> Math.pow(d1, d2);
	
	public static Double calc(Character c, Double n1 , Double n2) {
		Double result =0.0;
		switch (c) {
		case '+':
			result = calculate(n2, n1, add);
			break;
		case '-':
			result = calculate(n2, n1, sub);
			break;
		case '*':
			result = calculate(n2, n1, mult);
			break;
		case '/':
			result = calculate(n2, n1, div);
			break;
		case '^':
			result = calculate(n2, n1, pow);
			break;
		}
		return result;
	}
}
