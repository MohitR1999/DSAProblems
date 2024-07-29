package concretes.solutions.leetcode.sliding_window;

import java.util.HashSet;
import java.util.Set;

import abstracts.Solution;

public class Leetcode_3 extends Solution {

    private String s;
    private int result;

    @Override
    public void prepareInput() {
        s = this.input.get(0);
    }

    @Override
    public void prepareOutput() {
        this.output.add(result + "");
    }

    @Override
    public void solveProblem() {
        this.result = this.lengthOfLongestSubstring(s);
    }

    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        Set<Character> charSet = new HashSet<>();
        int left = 0;
        
        for (int right = 0; right < n; right++) {
            if (!charSet.contains(s.charAt(right))) {
                maxLength = Math.max(maxLength, right - left + 1);
            } else {
                while (charSet.contains(s.charAt(right))) {
                    charSet.remove(s.charAt(left));
                    left++;
                }
            }
            charSet.add(s.charAt(right));
        }
        
        return maxLength;
    }
    
}
