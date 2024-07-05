package concretes.solutions.leetcode.graph_general;

import java.util.Iterator;

import abstracts.Solution;

public class Leetcode_200 extends Solution {

    private char[][] grid;
    private int m;
    private int n;
    private int result;

    @Override
    public void prepareInput() {
        Iterator<String> iterator = this.input.iterator();
        this.m = Integer.parseInt(iterator.next());
        this.n = Integer.parseInt(iterator.next());
        this.grid = new char[this.m][this.n];
        for (int i = 0; i < this.m; i++) {
            for (int j = 0; j < this.n; j++) {
                this.grid[i][j] = iterator.next().charAt(0);
            }
        }
    }

    @Override
    public void prepareOutput() {
        this.output.add(this.result + " ");
    }

    @Override
    public void solveProblem() {
        this.result = this.numIslands(grid);
    }
    
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    traverse(grid, i, j);
                    count++;
                }
            }
        }
        
        return count;    
    }

    public void traverse(char[][] grid, int currentX, int currentY) {
        if (grid[currentX][currentY] == '1') {
            // marked as traversed
            grid[currentX][currentY] = '*';
            // explore further cells

            if (currentX + 1 < grid.length) {
                traverse(grid, currentX + 1, currentY);
            }

            if (currentX - 1 >= 0) {
                traverse(grid, currentX - 1, currentY);
            }

            if (currentY + 1 < grid[0].length) {
                traverse(grid, currentX, currentY + 1);
            }

            if (currentY - 1 >= 0) {
                traverse(grid, currentX, currentY - 1);
            }
        }
        
    }

}
