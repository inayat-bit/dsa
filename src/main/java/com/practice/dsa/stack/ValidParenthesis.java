package main.java.com.practice.dsa.stack;

import java.util.Stack;

public class ValidParenthesis {
    public static boolean isValid(String expr) {
        Stack<Character> stack = new Stack<>();
        for (char ch: expr.toCharArray()) {
            if(ch == '{' || ch == '(' || ch== '[') {
                stack.push(ch);
            } else if (!stack.isEmpty() &&
                    (stack.peek() == '(' && ch == ')') ||
                    (stack.peek() == '{' && ch == '}') ||
                    (stack.peek() == '[' && ch == ']')) {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String[] tests = {"()[]{}", "(]", "([{}])", "(((", "{[()]}"};

        for (String test : tests) {
            System.out.println(test + " -> " + isValid(test));
        }
    }
}
