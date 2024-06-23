/*
 * This solution provides implementation of quick sort
 */
package concretes.solutions.sorting;

import java.util.ArrayList;
import java.util.List;

import abstracts.Solution;

public class Solution_10_0_5 extends Solution {

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

    public int partition(int low, int high) {
        int pivot = this.list.get(low);
        int i = low;
        int j = high - 1;

        while (i < j) {
            while (this.list.get(i) <= pivot) i++;
            while (this.list.get(j) > pivot) j--;
            if (i < j) {
                int temp = this.list.get(i);
                this.list.set(i, this.list.get(j));
                this.list.set(j, temp);
            }
        }

        int temp = this.list.get(low);
        this.list.set(low, this.list.get(j));
        this.list.set(j, temp);

        return j;
    }

    public void quickSort(int low, int high) {
        if (low < high) {
            int p = partition(low, high);
            quickSort(low, p);
            quickSort(p + 1, high);
        }
    }

    @Override
    public void solveProblem() {
        this.quickSort(0, size);        
    }
    
}
