package concretes.solutions.leetcode.arrays_and_strings;

import java.util.Iterator;

import abstracts.Solution;

public class Leetcode_26 extends Solution {
    private int size = 0;
    private int[] nums;
    private int k = 0;

    @Override
    public void prepareInput() {
        Iterator<String> iterator = this.input.iterator();
        this.size = Integer.parseInt(iterator.next());
        this.nums = new int[this.size];
        for (int i = 0; i < this.size; i++) {
            this.nums[i] = Integer.parseInt(iterator.next());
        }
    }

    @Override
    public void prepareOutput() {
        for (int i = 0; i < this.nums.length; i++) {
            this.output.add(this.nums[i] + " ");
        }
        this.output.add("\n");
        this.output.add(k + " ");
    }

    @Override
    public void solveProblem() {
        this.k = this.removeDuplicates(nums);
    }
    
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; ) {
            while (j < nums.length && nums[i] == nums[j]) j++;
            if (j < nums.length) {
                nums[i + 1] = nums[j];
                i++;
            }
        }
        return i + 1;
    }
}
