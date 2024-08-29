/**
 * Two Integer Sum
Solved

Given an array of integers nums and an integer target, return the indices i and j such that nums[i] + nums[j] == target and i != j.

You may assume that every input has exactly one pair of indices i and j that satisfy the condition.

Return the answer with the smaller index first. 
 */

package concretes.solutions.neetcode.arrays_and_hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import abstracts.Solution;

public class Neetcode_3 extends Solution {

    private int target;
    private int[] nums;
    private int[] res;

    class Pair {
        private int value;
        private int index;

        public Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

    }

    @Override
    public void prepareInput() {
        Iterator<String> iterator = this.input.iterator();
        this.target = Integer.parseInt(iterator.next());
        int n = Integer.parseInt(iterator.next());
        this.nums = new int[n];
        for (int i = 0; i < n; i++) {
            this.nums[i] = Integer.parseInt(iterator.next());
        }
    }

    @Override
    public void prepareOutput() {
        this.output.add(String.format("[%d, %d]", this.res[0], this.res[1]));
    }
    
    @Override
    public void solveProblem() {
        this.res = this.twoSum(nums, target);
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Pair> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int ret[] = new int[]{i, map.get(nums[i]).index};
                Arrays.sort(ret);
                return ret;
            } else {
                map.put(target - nums[i], new Pair(nums[i], i));
            }
        }
        return new int[]{-1, -1};
    }

}
