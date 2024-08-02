package concretes.solutions.leetcode.multi_dimensional_dp;

import abstracts.Solution;
import java.util.*;

public class Leetcode_64 extends Solution {

    private int[][] grid;
    private int result;

    @Override
    public void prepareInput() {
        Iterator<String> iterator = this.input.iterator();
        int m = Integer.parseInt(iterator.next());
        int n = Integer.parseInt(iterator.next());
        this.grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                this.grid[i][j] = Integer.parseInt(iterator.next());
            }
        }
    }

    @Override
    public void prepareOutput() {
        this.output.add(this.result + "");
    }

    @Override
    public void solveProblem() {
        this.result = this.minPathSum(grid);
    }
    
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }

        return helper(dp, grid, 0, 0);
    }

    public int helper(int[][] dp, int[][] grid, int x, int y) {
        if (x == grid.length - 1 && y == grid[0].length - 1) {
            return grid[x][y];
        } else if (x == grid.length - 1) {
            dp[x][y] = grid[x][y] + helper(dp, grid, x, y + 1);
            return dp[x][y];
        } else if (y == grid[0].length - 1) {
            dp[x][y] = grid[x][y] + helper(dp, grid, x + 1, y);
            return dp[x][y];
        } 
        else if (dp[x][y] != -1) {
            return dp[x][y];
        } else {
            dp[x][y] = grid[x][y] + Math.min(helper(dp, grid, x + 1, y), helper(dp, grid, x, y + 1));
            return dp[x][y];
        }
    }
}
