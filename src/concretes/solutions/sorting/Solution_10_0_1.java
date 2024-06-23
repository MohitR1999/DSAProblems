/**
 * This is the implementation of Bubble Sort
 */
package concretes.solutions.sorting;

import java.util.ArrayList;
import java.util.List;

import abstracts.Solution;

public class Solution_10_0_1 extends Solution {
    private int size;
    private List<Integer> list = new ArrayList<>();

    @Override
    public void prepareInput() {
        // first element of the input will be the size of the array
        this.size = Integer.parseInt(this.input.get(0));
        // subsequent entries of the input will be the elements of the array
        for (int i = 1;  i < this.input.size(); i++) {
            this.list.add(Integer.parseInt(this.input.get(i)));
        }
    }

    public void bubbleSort() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if (this.list.get(j) > this.list.get(j + 1)) {
                    int temp = this.list.get(j);
                    this.list.set(j, this.list.get(j+1));
                    this.list.set(j + 1, temp);
                }           
            }
        }
    }

    @Override
    public void solveProblem() {
        this.bubbleSort();
    }

    @Override
    public void prepareOutput() {
        for (int num : this.list) {
            this.output.add(String.valueOf(num));
            this.output.add(" ");
        }
    }
    
}
