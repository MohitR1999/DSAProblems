package concretes.solutions.leetcode.kadane;

import java.util.Iterator;

import abstracts.Solution;

public class Leetcode_53 extends Solution {

    private int[] nums;
    private int sum;
    private int n;

    @Override
    public void prepareInput() {
        Iterator<String> iterator = this.input.iterator();
        this.n = Integer.parseInt(iterator.next());
        this.nums = new int[this.n];
        for (int i = 0; i < this.n; i++) {
            this.nums[i] = Integer.parseInt(iterator.next());
        }
    }

    @Override
    public void prepareOutput() {
        this.output.add(this.sum + " ");
    }

    @Override
    public void solveProblem() {
        this.sum = this.maxSubArray(this.nums);
    }

    public int maxSubArray(int[] nums) {
        int global_max = Integer.MIN_VALUE;
        int local_max = 0;
        for (int i = 0; i < nums.length; i++) {
            local_max += nums[i];
            if (global_max < local_max) global_max = local_max;
            if (local_max < 0) local_max = 0;
        }
        return global_max;    
    }
    

}
