/*
 * Given an integer array nums, return an array output where output[i] is the product of all the elements of nums except nums[i].

Each product is guaranteed to fit in a 32-bit integer.

Follow-up: Could you solve it in O(n)O(n) time without using the division operation?
 * 
 */

package concretes.solutions.neetcode.arrays_and_hashing;

import java.util.Iterator;

import abstracts.Solution;

public class Neetcode_7 extends Solution {

    private int n;
    private int[] nums;
    private int[] res;

    @Override
    public void prepareInput() {
        Iterator<String> iterator = this.input.iterator();
        this.n = Integer.parseInt(iterator.next());
        this.nums = new int[n];
        for (int i = 0; i < n; i++) {
            this.nums[i] = Integer.parseInt(iterator.next());
        }
    }

    @Override
    public void prepareOutput() {
        for (int i = 0; i < res.length; i++) {
            this.output.add(res[i] + ", ");
        }
    }

    @Override
    public void solveProblem() {
        this.res = this.productExceptSelf(nums);
    }

    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int right = 1;
        int left = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = left;
            left *= nums[i];
        }
        
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= right;
            right *= nums[i];
        }

        return result;
    }
    
}
