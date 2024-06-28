package concretes.solutions.leetcode.intervals;

import abstracts.Solution;
import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Iterator;

public class Leetcode_228 extends Solution {

    private int size;
    private int[] nums;
    private List<String> op;

    class Range {
        private int start;
        private int end;
        
        public Range(int start, int end) {
            this.start = start;
            this.end = end;
        }
        public int getStart() {
            return start;
        }
        public void setStart(int start) {
            this.start = start;
        }
        public int getEnd() {
            return end;
        }
        public void setEnd(int end) {
            this.end = end;
        }
        @Override
        public String toString() {
            if (this.start == this.end) {
                return String.valueOf(this.start);
            } else {
                return String.format("%d->%d", this.start, this.end);
            }
        }

        
    }

    public List<String> summaryRanges(int[] nums) {
        List<Range> rangeList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (rangeList.isEmpty() || rangeList.get(rangeList.size() - 1).getEnd() + 1 != nums[i]) {
                rangeList.add(new Range(nums[i], nums[i]));
            } else if (rangeList.get(rangeList.size() - 1).getEnd() + 1 == nums[i]) {
                Range range = rangeList.get(rangeList.size() - 1);
                range.setEnd(range.getEnd() + 1);
            }
        }

        return rangeList.stream().map(r -> r.toString()).collect(Collectors.toList());
    }


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
        for (String s : op) {
            this.output.add(s + "\n");
        }
    }

    @Override
    public void solveProblem() {
        this.op = this.summaryRanges(nums);
    }
    
}
