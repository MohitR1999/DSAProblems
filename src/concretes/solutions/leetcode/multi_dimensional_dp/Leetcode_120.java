package concretes.solutions.leetcode.multi_dimensional_dp;

import abstracts.Solution;
import java.util.*;

public class Leetcode_120 extends Solution {
    private List<List<Integer>> triangle;
    private int size;
    private int result;

    @Override
    public void prepareInput() {
        this.triangle = new ArrayList<>();
        Iterator<String> iterator = this.input.iterator();
        this.size = Integer.parseInt(iterator.next());
        for (int i = 1; i <= this.size; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                list.add(Integer.parseInt(iterator.next()));
            }
            this.triangle.add(list);
        }
    }

    @Override
    public void prepareOutput() {
        this.output.add(this.result + " ");
    }

    @Override
    public void solveProblem() {
        this.result = this.minimumTotal(triangle);
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.size()];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = Integer.MIN_VALUE;
            }
        }
        return solve(triangle, dp, 0, 0);
    }

    public int solve(List<List<Integer>> triangle, int[][] dp, int i, int j) {
        if (i == triangle.size() - 1 || j == triangle.get(triangle.size() - 1).size() - 1) {
            return triangle.get(i).get(j);
        } else if (dp[i][j] != Integer.MIN_VALUE) {
            return dp[i][j];
        }
        else {
            dp[i][j] = triangle.get(i).get(j) + Math.min(solve(triangle, dp, i + 1, j), solve(triangle, dp, i + 1, j + 1));
            return dp[i][j];
        }
    }
    
}
