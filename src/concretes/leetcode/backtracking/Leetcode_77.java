package concretes.leetcode.backtracking;

import abstracts.Solution;
import java.util.*;

public class Leetcode_77 extends Solution {

    private List<List<Integer>> resultList;
    private int n;
    private int k;

    @Override
    public void prepareInput() {
        this.n = Integer.parseInt(this.input.get(0));
        this.k = Integer.parseInt(this.input.get(1));
    }

    @Override
    public void prepareOutput() {
        for (List<Integer> list : this.resultList) {
            for (Integer num : list) {
                this.output.add(num + ", ");
            }
            this.output.add("\n");
        }
    }

    @Override
    public void solveProblem() {
        this.resultList = this.combine(n, k);
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        helper(1, combination, result, n, k);
        return result;
    }

    public void helper(int start, List<Integer> combination, List<List<Integer>> result, int n, int k) {
        if (combination.size() == k) {
            result.add(new ArrayList<>(combination));
        } else {
            for (int num = start; num <= n; num++) {
                combination.add(num);
                helper(num + 1, combination, result, n, k);
                combination.remove(combination.size() - 1);
            }
        }
    }
    
}
