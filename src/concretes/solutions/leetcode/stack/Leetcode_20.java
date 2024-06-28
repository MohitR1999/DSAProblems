package concretes.solutions.leetcode.stack;

import java.util.Stack;

import abstracts.Solution;

public class Leetcode_20 extends Solution {
    private String s;
    private boolean res;

    @Override
    public void prepareInput() {
        s = this.input.get(0);
    }

    @Override
    public void prepareOutput() {
        this.output.add(res + " ");
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } 
            else if (stack.empty()) {
                return false;
            }
            else {
                char top = stack.peek();
                if (
                    (top == '(' && ch == ')') ||
                    (top == '{' && ch == '}') ||
                    (top == '[' && ch == ']')
                ) {
                    stack.pop();
                } else return false;
            }
        }
        return stack.empty();
    }

    @Override
    public void solveProblem() {
        this.res = isValid(s);
    }
    
}
