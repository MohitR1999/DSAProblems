package concretes.solutions.leetcode.sliding_window;

import abstracts.Solution;
import java.util.*;

public class Leetcode_209 extends Solution {

    private int size = 0;
    private int[] nums;
    private int target;
    private int result;

    @Override
    public void prepareInput() {
        Iterator<String> iterator = this.input.iterator();
        this.size = Integer.parseInt(iterator.next());
        this.nums = new int[this.size];
        for (int i = 0; i < this.size; i++) {
            this.nums[i] = Integer.parseInt(iterator.next());
        }
        this.target = Integer.parseInt(iterator.next());
    }

    @Override
    public void prepareOutput() {
        this.output.add(this.result + " ");
    }

    @Override
    public void solveProblem() {
        this.result = this.minSubArrayLen(target, nums);
    }

    public int minSubArrayLen(int target, int[] nums) {
        int current_sum = 0;
        int min_length = nums.length + 1;

        int start = 0;
        int end = 0;

        while (end < nums.length) {

            while (current_sum < target && end < nums.length) {
                current_sum += nums[end];
                end++;
            }

            while(current_sum >= target && start < nums.length) {
                if (end - start < min_length) {
                    min_length = end - start;
                }

                current_sum -= nums[start];
                start++;
            }
        }

        return min_length > nums.length ? 0 : min_length;
    }
    
}
