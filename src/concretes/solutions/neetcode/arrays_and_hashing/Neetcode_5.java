/*
 * Given an integer array nums and an integer k, return the k most frequent elements within the array.

The test cases are generated such that the answer is always unique.

You may return the output in any order.
 */

package concretes.solutions.neetcode.arrays_and_hashing;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import abstracts.Solution;

public class Neetcode_5 extends Solution {

    private int[] nums;
    private int k;
    private int[] res;

    class Element {
        private int num;
        private int frequency;

        public Element(int num, int frequency) {
            this.num = num;
            this.frequency = frequency;
        }
        public int getNum() {
            return num;
        }
        public void setNum(int num) {
            this.num = num;
        }
        public int getFrequency() {
            return frequency;
        }
        public void setFrequency(int frequency) {
            this.frequency = frequency;
        }
        
    }

    class SortByFrequency implements Comparator<Element> {

        @Override
        public int compare(Element arg0, Element arg1) {
            return arg1.getFrequency() - arg0.getFrequency();
        }
        
    }

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
        this.output.add("[");
        for (int i = 0; i < this.k; i++) {
            this.output.add(this.res[i] + ", ");
        }
        this.output.add("]");
    }

    @Override
    public void solveProblem() {
        this.res = this.topKFrequent(nums, k);
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Element> map = new HashMap<>();
        for (int n : nums) {
            if (map.containsKey(n)) {
                map.get(n).setFrequency(map.get(n).getFrequency() + 1);
            } else {
                map.put(n, new Element(n, 1));
            }
        }

        List<Element> elements = new ArrayList<>();
        for (Map.Entry<Integer, Element> entry : map.entrySet()) {
            elements.add(entry.getValue());
        }

        elements.sort(new SortByFrequency());

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = elements.get(i).getNum();
        }
        return res;
    }
    
}
