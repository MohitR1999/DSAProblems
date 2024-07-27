package concretes.solutions.leetcode.arrays_and_strings;

import java.util.Iterator;

import abstracts.Solution;

public class Leetcode_80 extends Solution {

    private int size;
    private int[] nums;
    private int result;

    @Override
    public void prepareInput() {
        Iterator<String> iterator = this.input.iterator();
        this.size = Integer.parseInt(iterator.next());
        this.nums = new int[this.size];
        for (int i = 0; i < nums.length; i++) {
            this.nums[i] = Integer.parseInt(iterator.next());
        }
    }

    @Override
    public void prepareOutput() {
        this.output.add(this.result + "");
    }

    @Override
    public void solveProblem() {
        this.result = this.removeDuplicates(nums);
    }

    // public int removeDuplicates(int[] nums) {
    //     int i = 0;
    //     int j = 0;
    //     for (j = i + 1; j < nums.length; j++) {
    //         if (nums[i] != nums[j]) i = j;
    //         else if (nums[i] == nums[j] && j - i > 1) {
    //             int k = 0;
    //             int start = 0;
    //             for (k = j+1; k < nums.length && nums[k] == nums[j]; k++);
    //             if (k == nums.length) k = j;
    //             for (start = j; start < nums.length && k < nums.length; ) {
    //                 nums[start] = nums[k];
    //                 nums[k] = Integer.MAX_VALUE;
    //                 start++;
    //                 k++;
    //             }

    //             while (start < nums.length) nums[start++] = Integer.MAX_VALUE;
    //             i = j;
    //         }
    //     }
    //     i = 0;
    //     while (i < nums.length && nums[i] != Integer.MAX_VALUE) i++;
    //     return i;
    // }
    
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return n;
        }

        int j = 2;
        for (int i = 2; i < n; i++) {
            if (nums[i] != nums[j - 2]) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
}
