package concretes.solutions.leetcode.heap;

import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;

import abstracts.Solution;

public class Leetcode_215 extends Solution {

    private int[] nums;
    private int k;
    private int res;

    @Override
    public void prepareInput() {
        Iterator<String> iterator = this.input.iterator();
        int n = Integer.parseInt(iterator.next());
        this.nums = new int[n];
        for (int i = 0; i < n; i++) {
            this.nums[i] = Integer.parseInt(iterator.next());
        }
        this.k = Integer.parseInt(iterator.next());
    }

    @Override
    public void prepareOutput() {
        this.output.add(this.res + " ");
    }

    @Override
    public void solveProblem() {
        this.res = this.findKthLargest(nums, k);
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < nums.length; i++) {
            maxHeap.add(nums[i]);
        }

        for (int i = 0; i < k - 1; i++) {
            maxHeap.poll();
        }

        return maxHeap.poll();

    }
    
}
