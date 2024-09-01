/*
 * Evaluate reverse polish notation
 */
package concretes.solutions.neetcode.stack;

import java.util.Iterator;
import java.util.Stack;

import abstracts.Solution;

public class Neetcode_11 extends Solution {

    private String[] tokens;
    private int n;
    private int result;

    @Override
    public void prepareInput() {
        Iterator<String> iterator = this.input.iterator();
        this.n = Integer.parseInt(iterator.next());
        this.tokens = new String[n];
        for (int i = 0; i < n; i++) {
            this.tokens[i] = iterator.next();
        }
    }

    @Override
    public void prepareOutput() {
        this.output.add(this.result + "");
    }

    @Override
    public void solveProblem() {
        this.result = this.evalRPN(tokens);
    }
    
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            switch (token) {
                case "+": {
                    int secondOperand = stack.pop();
                    int firstOperand = stack.pop();
                    stack.push(firstOperand + secondOperand);
                    break;
                }

                case "-": {
                    int secondOperand = stack.pop();
                    int firstOperand = stack.pop();
                    stack.push(firstOperand - secondOperand);
                    break;
                }

                case "*": {
                    int secondOperand = stack.pop();
                    int firstOperand = stack.pop();
                    stack.push(firstOperand * secondOperand);
                    break;
                }

                case "/": {
                    int secondOperand = stack.pop();
                    int firstOperand = stack.pop();
                    stack.push(firstOperand / secondOperand);
                    break;
                }

                default : {
                    stack.push(Integer.parseInt(token));
                    break;
                }
            }
        }

        return stack.pop();
    }
}
