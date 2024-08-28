/*
 * Duplicate Integer
Given an integer array nums, return true if any value appears more than once in the array, otherwise return false.
 * 
 */

package concretes.solutions.neetcode.arrays_and_hashing;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import abstracts.Solution;

public class Neetcode_1 extends Solution {

    private int[] nums;
    private boolean result;

    @Override
    public void prepareInput() {
        Iterator<String> iterator = this.input.iterator();
        int n = Integer.parseInt(iterator.next());
        this.nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            this.nums[i] = Integer.parseInt(iterator.next());
        }
    }

    @Override
    public void prepareOutput() {
        this.output.add(result + "");
    }

    @Override
    public void solveProblem() {
        this.result = this.hasDuplicate(nums);
    }

    public boolean hasDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (set.contains(n)) {
                return true;
            } else {
                set.add(n);
            }
        }
        return false;
    }
    
}
