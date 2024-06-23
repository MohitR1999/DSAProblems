/**
 * This is the implementation of Selection sort
 */
package concretes.solutions.sorting;

import java.util.ArrayList;
import java.util.List;

import abstracts.Solution;

public class Solution_10_0_3 extends Solution {

    private int size = 0;
    private List<Integer> list = new ArrayList<>();

    @Override
    public void prepareInput() {
        this.size = Integer.parseInt(this.input.get(0));
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

    public void selectionSort() {
        for (int i = 0; i < size - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < size; j++) {
                if (this.list.get(j) < this.list.get(minIndex)) {
                    minIndex = j;
                }
            }

            int temp = this.list.get(minIndex);
            this.list.set(minIndex, this.list.get(i));
            this.list.set(i, temp);
        }
    }

    @Override
    public void solveProblem() {
        this.selectionSort();
    }
    
}
