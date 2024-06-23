/**
 * This is the implementation of Insertion Sort
 */
package concretes.solutions.sorting;

import java.util.ArrayList;
import java.util.List;

import abstracts.Solution;

public class Solution_10_0_2 extends Solution {

    private int size = 0;
    private List<Integer> list = new ArrayList<>();

    @Override
    public void prepareInput() {
        this.size = Integer.parseInt(this.input.get(0));
        for (int i = 1; i < this.input.size(); i++) {
            this.list.add(Integer.parseInt(this.input.get(i)));
        }
    }

    public void insertionSort() {
        for (int i = 1; i < size; i++) {
            int key = this.list.get(i);
            int j = i - 1;

            while (j >= 0 && this.list.get(j) > key) {
                this.list.set(j + 1, this.list.get(j));
                j = j - 1;
            }

            this.list.set(j + 1, key);
        }
    }

    @Override
    public void solveProblem() {
        this.insertionSort();
    }

    @Override
    public void prepareOutput() {
        for (int num : this.list) {
            this.output.add(String.valueOf(num));
            this.output.add(" ");
        }
    }

}
