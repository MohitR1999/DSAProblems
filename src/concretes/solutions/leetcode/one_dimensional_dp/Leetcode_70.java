package concretes.solutions.leetcode.one_dimensional_dp;

import abstracts.Solution;

public class Leetcode_70 extends Solution {

    private int n;
    private int res;

    @Override
    public void prepareInput() {
        this.n = Integer.parseInt(this.input.get(0));
    }

    @Override
    public void prepareOutput() {
        this.output.add(this.res + " ");
    }

    @Override
    public void solveProblem() {
        this.res = this.climbStairs(n);
    }

    public int climbStairs(int n) {
        int dp[] = new int[n + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = -1;
        }
        dp[0] = 1;
        dp[1] = 1;
        return helper(dp, n);
    }
    
    public int helper(int[] dp, int n) {
        if (n == 0 || n == 1) return 1;
        else if (dp[n] != -1) return dp[n];
        else {
            dp[n] = helper(dp, n - 1) + helper(dp, n - 2);
            return dp[n];
        }
    }
}
