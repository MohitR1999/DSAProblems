package concretes.solutions.leetcode.arrays_and_strings;
import abstracts.Solution;

public class Leetcode_88 extends Solution {

    private int m = 0;
    private int n = 0;
    private int[] nums1;
    private int[] nums2;

    @Override
    public void prepareInput() {
        this.m = Integer.parseInt(this.input.get(0));
        this.n = Integer.parseInt(this.input.get(1));
        this.nums1 = new int[this.m + this.n];
        this.nums2 = new int[this.n];
        for (int i = 2; i < this.m + 2; i++) {
            this.nums1[i - 2] = Integer.parseInt(this.input.get(i));
        }

        for (int i = this.m + 2; i < this.m + 2 + this.n; i++) {
            this.nums2[i - this.m - 2] = Integer.parseInt(this.input.get(i));
        }
    }

    @Override
    public void prepareOutput() {
        for (int i = 0; i < nums1.length; i++) {
            this.output.add(this.nums1[i] + " ");
        }
    }

    @Override
    public void solveProblem() {
        this.merge(nums1, m, nums2, n);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j = 0;

        for (; i < m && j < n; ) {
            while (i < m && nums1[i] <= nums2[j]) {
                i++;
            }
            // now if nums1[i] > nums2[j], we will shift the array
            // for making space for the correct element and insert it
            if (i < m && nums1[i] > nums2[j]) {
                int k = nums1.length - 1;
                while (k > i) {
                    nums1[k] = nums1[k - 1];
                    k--;
                }

                nums1[i] = nums2[j];
                i++;
                j++;
                m += 1;
            }
        }

        // now there might be some elements in the nums2, so copy them as it is
        for (; i < nums1.length && j < nums2.length; ) {
            nums1[i] = nums2[j];
            i++;
            j++;
        }
    }
    
}
