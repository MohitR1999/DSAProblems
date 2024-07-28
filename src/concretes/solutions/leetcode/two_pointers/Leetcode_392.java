package concretes.solutions.leetcode.two_pointers;

import abstracts.Solution;

public class Leetcode_392 extends Solution {

    private String s;
    private String t;
    private boolean result;

    @Override
    public void prepareInput() {
        s = this.input.get(0);
        t = this.input.get(1);
    }

    @Override
    public void prepareOutput() {
        this.output.add(result + "");
    }

    @Override
    public void solveProblem() {
        this.result = this.isSubsequence(s, t);
    }

    public boolean isSubsequence(String s, String t) {
        if (t.length() < s.length()) return false;
        int i = 0;
        int j = 0;
        for (; i < t.length() && j < s.length(); ) {
            if (t.charAt(i) == s.charAt(j)) j++;
            i++;
        }
        if (i >= t.length() && j < s.length()) return false;
        return true;
    }
    
}
