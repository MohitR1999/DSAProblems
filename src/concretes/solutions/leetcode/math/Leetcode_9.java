package concretes.solutions.leetcode.math;

import abstracts.Solution;

public class Leetcode_9 extends Solution {

    private int x;
    private boolean result;

    @Override
    public void prepareInput() {
        this.x = Integer.parseInt(this.input.get(0));
    }

    @Override
    public void prepareOutput() {
        this.output.add(this.result + " ");
    }

    @Override
    public void solveProblem() {
        this.result = this.isPalindrome(x);
    }
    
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        String num = String.valueOf(x);
        for (int i = 0, j = num.length() - 1; i <= j; i++, j--) {
            if (num.charAt(i) != num.charAt(j)) return false;
        }
        return true;    
    }

}
