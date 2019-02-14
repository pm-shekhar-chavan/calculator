package com.text.calc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

import com.text.calc.common.util.CommonUtil;
import com.text.calc.exception.InvalidExpressionException;
import com.text.calc.operation.CalcUtil;

public class MainClass {

	public static double calculate(List<String> elements) throws InvalidExpressionException {
		//To store numbers
		Stack<Double> operandStack = new Stack<Double>();
		//To store operators
		Stack<Character> operatorStack = new Stack<Character>();
		
		String lastElement = null;
		for(String str: elements) {
			//There should be arithmatic operator before (			
			if(str.charAt(0) == '(') {
				if(lastElement != null && !lastElement.equals("(") && !CommonUtil.isArithmaticOperator(lastElement))
				{
					throw new InvalidExpressionException("INVALID EXPRESSION");
				}
			}
			else if(CommonUtil.isArithmaticOperator(str) && CommonUtil.isArithmaticOperator(lastElement)){
				//This will handle use case if expression has operator next to each other
				throw new InvalidExpressionException("INVALID EXPRESSION");
			}
			
			if(CommonUtil.isNumber(str)) {
				operandStack.push(Double.parseDouble(str));
			}
			else if(str.equals("(")) {
				operatorStack.push(str.charAt(0));
			} 
			else if(CommonUtil.isArithmaticOperator(str)) {
				if(!operatorStack.isEmpty() && !operatorStack.peek().toString().equals("(")) {
					while(!operatorStack.isEmpty() && !operatorStack.peek().toString().equals("(") && CommonUtil.isHighOrSamePrecedence(str, ""+operatorStack.peek())){
						removeFromStackAndEvaluate(operandStack, operatorStack);
					}
				}
				operatorStack.push(str.charAt(0));
			} else if(str.equals(")")) {
				if(operatorStack.isEmpty()) {
					throw new InvalidExpressionException("INVALID EXPRESSION");
				}
				while(!operatorStack.peek().toString().equals("(")) {
					removeFromStackAndEvaluate(operandStack, operatorStack);
				}
				//Remove ( brace
				operatorStack.pop();
			}			
			lastElement = str;						
		}		
		removeAllRemainingElements(operandStack, operatorStack);
		return operandStack.pop();
	}
		
	//Remove operator from stack and evaluate it
	public static void removeFromStackAndEvaluate(Stack<Double> operandStack, Stack<Character> operatorStack) throws InvalidExpressionException {
		Character c = operatorStack.pop();
		if(operandStack.size() <2) {
			throw new InvalidExpressionException("INVALID EXPRESSION");
		}
		double n1 = operandStack.pop();
		double n2 = operandStack.pop();
		operandStack.push(CalcUtil.calc(c, n1, n2));						
	}
	
	//Remove all remaining elements from both the stacks. If operator stack still has "(" then its invalid expression
	public static void removeAllRemainingElements(Stack<Double> operandStack, Stack<Character> operatorStack) throws InvalidExpressionException {
		while(!operatorStack.isEmpty()) {
			Character c = operatorStack.pop();
			if(operandStack.size() <2 || c.toString().equals("(")) {
				throw new InvalidExpressionException("INVALID EXPRESSION");
			}
			double n1 = operandStack.pop();
			double n2 = operandStack.pop();
			operandStack.push(CalcUtil.calc(c, n1, n2));
		}		
	}
	
	public static void main(String[] args) {
		//Read input from user
		Scanner sc = new Scanner(System.in);		
		int n = sc.nextInt();
		sc.nextLine();
		List<String> inputs = new ArrayList<>();
		for( int i=0;i<n;i++) {
			inputs.add(sc.nextLine());
		}
		
		for( int i=0;i<n;i++) {
			try {
				System.out.println(calculate(CommonUtil.splitExpr(inputs.get(i))));
			} catch (InvalidExpressionException e) {
				System.out.println(e.getMessage());
			}
		}		
	}
}
