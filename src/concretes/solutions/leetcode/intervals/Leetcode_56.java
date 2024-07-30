package concretes.solutions.leetcode.intervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import abstracts.Solution;

public class Leetcode_56 extends Solution {

    private int[][] intervals;
    private int[][] result;
    private int size;

    @Override
    public void prepareInput() {
        Iterator<String> iterator = this.input.iterator();
        this.size = Integer.parseInt(iterator.next());
        this.intervals = new int[this.size][2];
        for (int i = 0; i < this.size; i++) {
            this.intervals[i][0] = Integer.parseInt(iterator.next());
            this.intervals[i][1] = Integer.parseInt(iterator.next());
        }
    }

    @Override
    public void prepareOutput() {
        for (int i = 0; i < result.length; i++) {
            this.output.add(String.format("[%d, %d]\n", result[i][0], result[i][1]));
        }
    }

    @Override
    public void solveProblem() {
        this.result = this.merge(intervals);
    }

    class Pair implements Comparable<Pair> {
        private int start;
        private int end;
        
        public Pair() {}

        @Override
        public int compareTo(Pair arg0) {
            return this.start - arg0.start;
        }

        public Pair(int start, int end) {
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
            return String.format("{start: %d, end: %d}", this.start, this.end);
        }

        
    }

    public int[][] merge(int[][] intervals) {
        List<Pair> intervalPairs = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            intervalPairs.add(new Pair(intervals[i][0], intervals[i][1]));
        }
        Collections.sort(intervalPairs);
        List<Pair> mergedIntervals = new ArrayList<>();
        mergedIntervals.add(intervalPairs.get(0));

        for (int i = 1; i < intervalPairs.size(); i++) {
            Pair lastPair = mergedIntervals.get(mergedIntervals.size() - 1);
            Pair currentPair = intervalPairs.get(i);
            if (currentPair.getStart() <= lastPair.getEnd()) {
                lastPair.setEnd(Math.max(currentPair.getEnd(), lastPair.getEnd()));
            } else {
                mergedIntervals.add(currentPair);
            }
        }        
        
        int[][] result = new int[mergedIntervals.size()][2];
        for (int i = 0; i < mergedIntervals.size(); i++) {
            result[i][0] = mergedIntervals.get(i).getStart();
            result[i][1] = mergedIntervals.get(i).getEnd();
        }

        return result;
    }
    
}
