package concretes.solutions.leetcode.graph_bfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import abstracts.Solution;

public class Leetcode_909 extends Solution {

    private int[][] board;
    private int n;
    private int result = -1;

    public class Pair {
        public int first;
        public int second;
        

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
        public Pair() {
        }
        public int getFirst() {
            return first;
        }
        public void setFirst(int first) {
            this.first = first;
        }
        public int getSecond() {
            return second;
        }
        public void setSecond(int second) {
            this.second = second;
        }

        
    }


    @Override
    public void prepareInput() {
        Iterator<String> iterator = this.input.iterator();
        this.n = Integer.parseInt(iterator.next());
        this.board = new int[this.n][this.n];
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.n; j++) {
                this.board[i][j] = Integer.parseInt(iterator.next());
            }
        }
    }

    @Override
    public void solveProblem() {
        this.result = this.snakesAndLadders(board);
    }

    @Override
    public void prepareOutput() {
        this.output.add(this.result + " ");
    }

    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        List<Integer> columns = new ArrayList<>();
        for (int i = 0; i < n; i++) columns.add(i);
        List<Pair> cells = new ArrayList<>();
        cells.add(new Pair());
        for (int row  = n - 1; row >= 0; row--) {
            for (int col : columns) {
                cells.add(new Pair(row, col));
            }
            Collections.reverse(columns);
        }

        List<Integer> dist = new ArrayList<>();
        for (int i = 0; i < n*n + 1; i++) dist.add(-1);
        dist.set(1, 0);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        while(!queue.isEmpty()) {
            int current = queue.peek();
            queue.remove();
            for (int next = current + 1; next <= Math.min(current + 6, n * n); next++) {
                Pair p = cells.get(next);
                int row = p.first;
                int col = p.second;
                int destination = board[row][col] != -1 ? board[row][col] : next;
                if (dist.get(destination) == -1) {
                    dist.set(destination, dist.get(current) + 1);
                    queue.add(destination);
                }
            }
        }

        return dist.get(n*n);
    }
    
}
