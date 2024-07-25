package concretes.solutions.leetcode.bit_manipulation;

import java.util.Iterator;

import abstracts.Solution;

public class Leetcode_67 extends Solution {

    private String a;
    private String b;
    private String result;

    @Override
    public void prepareInput() {
        Iterator<String> iterator = this.input.iterator();
        a = iterator.next();
        b = iterator.next();
    }

    @Override
    public void prepareOutput() {
        this.output.add(this.result);
    }

    @Override
    public void solveProblem() {
        this.result = this.addBinary(a, b);
    }

    public String addBinary(String a, String b) {
        if (a.length() < b.length()) {
            while (a.length() != b.length()) {
                a = "0" + a;
            }
        } else {
            while (b.length() != a.length()) {
                b = "0" + b;
            }
        }
        
        StringBuilder builder = new StringBuilder();
        int carry = 0;
        for (int i = a.length() - 1; i >= 0; i--) {
            int actualSum = Integer.parseInt(a.charAt(i) + "") + Integer.parseInt(b.charAt(i) + "") + carry;
            int sum = actualSum % 2;
            carry = actualSum / 2;
            builder.append(String.valueOf(sum));
        }

        if (carry == 1) builder.append(String.valueOf(carry));

        return builder.reverse().toString();
    }
    
}
