package concretes.solutions.sorting;

import java.util.ArrayList;
import java.util.List;

import abstracts.Solution;

public class Solution_10_0_4 extends Solution {
    private int size;
    private List<Integer> list = new ArrayList<>();

    @Override
    public void prepareInput() {
        // first element of the input will be the size of the array
        this.size = Integer.parseInt(this.input.get(0));
        // subsequent entries of the input will be the elements of the array
        for (int i = 1; i < this.input.size(); i++) {
            this.list.add(Integer.parseInt(this.input.get(i)));
        }
    }

    @Override
    public void prepareOutput() {
        for (int num : this.list) {
            this.output.add(String.valueOf(num));
            this.output.add(" ");
        }
    }

    public void merge(int l, int mid, int r) {
        List<Integer> leftHalfList = new ArrayList<>();
        List<Integer> rightHalfList = new ArrayList<>();

        for (int i = l; i < mid; i++) {
            leftHalfList.add(this.list.get(i));
        }

        for (int i = mid; i < r; i++) {
            rightHalfList.add(this.list.get(i));
        }
        int i = 0;
        int j = 0;
        int k = l;
        for (; i < leftHalfList.size() && j < rightHalfList.size(); k++) {
            if (leftHalfList.get(i) < rightHalfList.get(j)) {
                this.list.set(k, leftHalfList.get(i));
                i++;
            } else {
                this.list.set(k, rightHalfList.get(j));
                j++;
            }
        }

        while (i < leftHalfList.size()) {
            this.list.set(k, leftHalfList.get(i));
            i++;
            k++;
        }

        while (j < rightHalfList.size()) {
            this.list.set(k, rightHalfList.get(j));
            j++;
            k++;
        }
    }

    public void sort(int l, int r) {
        if (l < r) {
            int mid = l + (r - l) / 2;
            sort(l, mid);
            sort(mid + 1, r);
            merge(l, mid, r);
        }
    }

    @Override
    public void solveProblem() {
        this.sort(0, size);
    }

}
