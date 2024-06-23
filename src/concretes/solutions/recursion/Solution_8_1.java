package concretes.solutions.recursion;

import abstracts.Solution;

public class Solution_8_1 extends Solution {

    private int steps = 0;
    private int ways = 0;

    @Override
    public void prepareInput() {
        if (this.input.size() > 0) {
            steps = Integer.parseInt(this.input.get(0));
        }
    }

    @Override
    public void prepareOutput() {
        this.output.add(String.valueOf(ways));
    }

    @Override
    public void solveProblem() {
        this.ways = countWays(steps);
    }

    public int countWays(int steps) {
        int[] memo = new int[steps + 1];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = -1;
        }
        return countWays(steps, memo);
    }

    public int countWays(int steps, int[] memo) {
        if (steps < 0) return 0;
        if (steps == 0) return 1;
        if (memo[steps] != -1) return memo[steps];
        else {
            memo[steps] = countWays(steps-1, memo) + countWays(steps - 2, memo) + countWays(steps - 3, memo);
            return memo[steps];
        }
    }
    
}
