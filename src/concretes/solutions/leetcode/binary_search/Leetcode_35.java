package concretes.solutions.leetcode.binary_search;

import abstracts.Solution;
import java.util.*;

public class Leetcode_35 extends Solution {

    private int[] nums;
    private int target;
    private int position;

    @Override
    public void prepareInput() {
        Iterator<String> iterator = this.input.iterator();
        int n = Integer.parseInt(iterator.next());
        this.nums = new int[n];
        for (int i = 0; i < n; i++) {
            this.nums[i] = Integer.parseInt(iterator.next());
        }
        this.target = Integer.parseInt(iterator.next());
    }

    @Override
    public void prepareOutput() {
        this.output.add(this.position + " ");
    }
    
    @Override
    public void solveProblem() {
        this.position = this.searchInsert(nums, target);
    }

    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) end = mid - 1;
            else start = mid + 1;
        }
        return start;
    }
    
}   
