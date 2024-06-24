package concretes.solutions.leetcode.two_pointers;

import java.util.Iterator;
import abstracts.Solution;

public class Leetcode_125 extends Solution {
    private String s = "";
    private boolean res = false;

    @Override
    public void prepareInput() {
        StringBuilder builder = new StringBuilder();
        Iterator<String> iterator = this.input.iterator();
        while (iterator.hasNext()) {
            builder.append(iterator.next());
        }
        this.s = builder.toString();
    }

    @Override
    public void prepareOutput() {
        this.output.add(s + " ");
        this.output.add(res + " ");
    }

    @Override
    public void solveProblem() {
        this.res = isPalindrome(this.s);
    }

    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        s = s.toLowerCase();
        int i = 0;
        int j = s.length() - 1;
        for (; i < j ;) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else return false;
        }

        return true;
    }
    
}
