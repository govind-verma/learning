package com.gs.ds.stack;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author govinda.verma
 *
 */
public class StackApplication {
	private CustomStack<Character> stack;
	private Map<Character, Integer> operatorToOrder;

	public StackApplication() {
		stack = new CustomStack<>();
		operatorToOrder = new HashMap<>();

		operatorToOrder.put('*', 1);
		operatorToOrder.put('/', 1);
		operatorToOrder.put('%', 1);
		operatorToOrder.put('+', 0);
		operatorToOrder.put('-', 0);
	}

	/**
	 * 
	 * @param infix
	 * @return
	 */
	public String infixToPostfix(String infix) {
		if (infix == null || infix.isEmpty()) {
			return infix;
		}

		int l = infix.length();
		char c;
		StringBuilder postfix = new StringBuilder();

		for (int i = 0; i < l; i++) {
			c = infix.charAt(i);

			if (isOperator(c) || c == '(') {
				if (stack.isEmpty() || c == '(') {
					stack.push(c);
				} else {
					char sc = stack.peek();
					boolean isHighPrecedence = isHighPrecedence(c, sc);
					if (isHighPrecedence) {
						stack.push(c);
					} else {
						boolean isLowerPrecedence = true;
						while (!stack.isEmpty() && isLowerPrecedence) {
							sc = stack.peek();
							isLowerPrecedence = isHighPrecedence(sc, c);
							if (isLowerPrecedence) {
								postfix.append(stack.pop());
							}
						}
						stack.push(c);
					}
				}
			} else if (c == ')') {
				boolean stop = false;
				while (!stack.isEmpty() && !stop) {
					char sc = stack.pop();
					if (sc == '(') {
						stop = true;
					} else {
						postfix.append(sc);
					}
				}
			} else {
				postfix.append(c);
			}
		}

		while (!stack.isEmpty()) {
			postfix.append(stack.pop());
		}

		return postfix.toString();
	}

	/**
	 * 
	 * @param str
	 * @return
	 */
	public boolean isBalance(String str) {
		if (str == null || str.isEmpty()) {
			return false;
		}

		int l = 0;
		int r = str.length() - 1;

		while (r >= l) {
			if (!isOpenAndClose(str.charAt(l), str.charAt(r))) {
				return false;
			}
			l++;
			r--;
		}
		
		return true;
	}
	
	/**
	 * 
	 * @param expression
	 * @return
	 */
	public int evaluate(String expression) {
		
		CustomStack<Integer> stack = new CustomStack<>();
		String postfix = infixToPostfix(expression);
		System.out.println(postfix);
		int l = postfix.length();
		
		for(int i = 0; i < l; i++) {
			char c = postfix.charAt(i);
			if(isOperator(c)) {
				int op1 = stack.pop();
				int op2 = stack.pop();
				stack.push(evaluate(op2, op1, c));
			} else {
				stack.push(c - 48);
			}
		}
		
		return stack.pop();
	}
	
	/**
	 * 
	 * @param str
	 * @return
	 */
	public String reverseString(String str) {
		if(str == null || str.isEmpty()) {
			return str;
		}
		stack.clear();
		int l = str.length();
		for(int i = 0; i < l; i++) {
			stack.push(str.charAt(i));
		}
		
		StringBuilder rev = new StringBuilder();
		
		while(!stack.isEmpty()){
			rev.append(stack.pop());
		}
		
		return rev.toString();
	}
	
	/**
	 * 
	 * @param op1
	 * @param op2
	 * @param c
	 * @return
	 */
	private Integer evaluate(int op1, int op2, char c) {
		switch (c) {
			case '+':
				return op1 + op2;
			case '-':
				return op1 - op2;
			case '/':
				return op1 / op2;
			case '*':
				return op1 * op2;
			case '%':
				return op1 % op2;
			default:
				break;
		}
		
		return null;
	}

	/**
	 * 
	 * @param charAt
	 * @param charAt2
	 * @return
	 */
	private boolean isOpenAndClose(char c1, char c2) {
		if ((c1 == '(' && c2 == ')') || (c1 == '{' && c2 == '}') || (c1 == '[' && c2 == ']')) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @param c
	 * @return
	 */
	private boolean isOperator(char c) {
		return operatorToOrder.get(c) != null;
	}

	/**
	 * 
	 * @param c
	 * @param sc
	 */
	private boolean isHighPrecedence(char c, char sc) {
		return (isOperator(sc) && isOperator(c)) && (operatorToOrder.get(c) >= operatorToOrder.get(sc)) ? true : false;

	}
}
