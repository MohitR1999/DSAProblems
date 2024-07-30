package concretes.solutions.leetcode.stack;

import java.util.Stack;

import abstracts.Solution;

public class Leetcode_71 extends Solution {

    private String path;
    private String result;

    @Override
    public void prepareInput() {
        this.path = this.input.get(0);
    }

    @Override
    public void prepareOutput() {
        this.output.add(this.result);
    }

    @Override
    public void solveProblem() {
        this.result = this.simplifyPath(path);
    }

    public String simplifyPath(String path) {
        String correctedPath = path.replaceAll("/+", "/");
        String[] tokens = correctedPath.split("/");
        Stack<String> stack = new Stack<>();
        String finalPath = "";
        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            if (!token.isEmpty()) {
                // if there is a change directory token
                if (token.equals("..") && !stack.isEmpty()) {
                    // if the stack is empty, we are at the root level and we can't move any back
                    stack.pop(); 
                } else if (!token.equals(".") && !token.equals("..")) {
                    stack.push(token);
                }
            }
        }

        while (!stack.isEmpty()) {
            finalPath = "/" + stack.peek() + finalPath;
            stack.pop();
        }

        return finalPath.isEmpty() ? "/" : finalPath;
    }
    
}
