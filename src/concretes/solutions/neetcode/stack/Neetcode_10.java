/*
 * Implement min stack
 */
package concretes.solutions.neetcode.stack;

import java.util.Stack;

import abstracts.Solution;

public class Neetcode_10 extends Solution {

    class MinStack {

        private Stack<Integer> stack;
        private Stack<Integer> helperStack;

        public MinStack() {
            this.stack = new Stack<>();
            this.helperStack = new Stack<>();
        }
        
        public void push(int val) {
            this.stack.push(val);
            if (this.helperStack.isEmpty() || val <= this.helperStack.peek()) {
                helperStack.push(val);
            }
        }
        
        public void pop() {
            int top = this.stack.pop();
            if (top == this.helperStack.peek()) {
                this.helperStack.pop();
            }
        }
        
        public int top() {
            return this.stack.peek();
        }
        
        public int getMin() {
            return this.helperStack.peek();
        }
    }

    @Override
    public void prepareInput() {
        
    }

    @Override
    public void prepareOutput() {
        
    }

    @Override
    public void solveProblem() {
        MinStack stack = new MinStack();
        this.output.add("Pushing 1...\n");
        stack.push(1);
        this.output.add("Pushing 2...\n");
        stack.push(2);
        this.output.add("Pushing 0...\n");
        stack.push(0);
        this.output.add(String.format("[stack.getMin]: %d\n", stack.getMin()));
        this.output.add("Popping...\n");
        stack.pop();
        this.output.add(String.format("[stack.top]: %d\n", stack.top()));
        this.output.add(String.format("[stack.getMin]: %d\n", stack.getMin()));
    }
    
}
