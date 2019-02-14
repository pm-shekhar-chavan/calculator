package com.text.calc.common.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommonUtil {

	//Check for same or high operator precedence
	public static boolean isHighOrSamePrecedence(String s1, String s2) {
		boolean status = true;
		switch (s1) {
		case "*":
		case "/":
			if(s2.equals("+") || s2.equals("-")) {
				status = false;
			}
			break;
		case "+":
		case "-":	
			status = true;
			break;
		case "^":
			if(!s2.equals("^")) {
				status = false;
			}
			break;
		}
		return status;
	}
	
	public static boolean isNumber(String str) {
		for(int i=0;i<str.length();i++) {
			if(!Character.isDigit(str.charAt(i))){
				return false;
			}
		}
		return true;
	}
	
	public static boolean isArithmaticOperator(String str) {
		if(str.trim().length() == 1 && (str.trim().charAt(0) == '+' 
				|| str.trim().charAt(0) == '-'
				||  str.trim().charAt(0) == '*' 
				||  str.trim().charAt(0) == '/'
				||  str.trim().charAt(0) == '^')) {
			return true;
		}
		else return false;
	}

	public static List<String> splitExpr(String str) {
		Pattern pattern = Pattern.compile("[0-9]+|(\\+|-|\\*|/|\\^|\\(|\\))");
		Matcher matcher = pattern.matcher(str);
		List<String> elements = new ArrayList();
		while (matcher.find()) {
			elements.add(matcher.group());
		}
		return elements;
	}

}
