package concretes.solutions.leetcode.arrays_and_strings;

import java.util.Iterator;

import abstracts.Solution;

public class Leetcode_27 extends Solution {

    private int val = 0;
    private int size = 0;
    private int[] nums;

    @Override
    public void prepareInput() {
        Iterator<String> iterator = this.input.iterator();
        this.size = Integer.parseInt(iterator.next());
        this.nums = new int[this.size];
        for (int i = 0; i < this.size; i++) {
            nums[i] = Integer.parseInt(iterator.next());
        }
        this.val = Integer.parseInt(iterator.next());
    }

    @Override
    public void prepareOutput() {
        for (int i = 0; i < nums.length; i++) {
            this.output.add(this.nums[i] + " ");
        }
        this.output.add("\n");
        this.output.add(this.val + " ");
    }

    public int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) k++;
        }
        k = nums.length - k;
        // Modify the array in place here
        int i = 0;
        for (; i < nums.length; ) {
            while (i < nums.length && nums[i] != val) i++;
            // out of bounds check on i
            if (i < nums.length) {
                int j = i + 1;
                while (j < nums.length && nums[j] == val) j++;
                // out of bounds check on j
                if (j < nums.length) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
                i++;
            }
        }

        return k;
    }

    @Override
    public void solveProblem() {
        this.removeElement(nums, val);
    }
    
}
