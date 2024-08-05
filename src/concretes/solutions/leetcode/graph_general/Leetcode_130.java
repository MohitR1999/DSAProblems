package concretes.solutions.leetcode.graph_general;

import java.util.Iterator;

import abstracts.Solution;

public class Leetcode_130 extends Solution {
    private int m;
    private int n;
    private char[][] board;

    @Override
    public void prepareInput() {
        Iterator<String> iterator = this.input.iterator();
        this.m = Integer.parseInt(iterator.next());
        this.n = Integer.parseInt(iterator.next());
        this.board = new char[this.m][this.n];

        for (int i = 0; i < this.m; i++) {
            for (int j = 0; j < this.n; j++) {
                this.board[i][j] = iterator.next().toCharArray()[0];
            }
        }
    }

    @Override
    public void prepareOutput() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                this.output.add(board[i][j] + " ");
            }
            this.output.add("\n");
        }
        
    }

    @Override
    public void solveProblem() {
        this.solve(board);
    }

    public void solve(char[][] board) {
        int maxRows = board.length;
        int maxColumns = board[0].length;
        // traverse along the boundary and do dfs on connected Os to 'Save' them
        for (int i = 0; i < maxRows; i++) {
            for (int j = 0; j < maxColumns; j++) {
                if (board[i][j] == 'O' && (i == 0 || j == 0 || i == maxRows - 1 || j == maxColumns - 1)) {
                    dfs(board, i, j);
                }
            }
        }

        // capture remaining Os
        for (int i = 0; i < maxRows; i++) {
            for (int j = 0; j < maxColumns; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }

        // mark all 'Saved' as O
        for (int i = 0; i < maxRows; i++) {
            for (int j = 0; j < maxColumns; j++) {
                if (board[i][j] == 'S') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void dfs(char[][] board, int x, int y) {
        if (areCoordinatesOutOfBound(x, y, board.length, board[0].length)) return;
        board[x][y] = 'S';
        if (!areCoordinatesOutOfBound(x + 1, y, board.length, board[0].length) && board[x + 1][y] == 'O') {
            dfs(board, x + 1, y);
        }

        if (!areCoordinatesOutOfBound(x - 1, y, board.length, board[0].length) && board[x - 1][y] == 'O') {
            dfs(board, x - 1, y);
        }

        if (!areCoordinatesOutOfBound(x, y + 1, board.length, board[0].length) && board[x][y + 1] == 'O') {
            dfs(board, x, y + 1);
        }

        if (!areCoordinatesOutOfBound(x, y - 1, board.length, board[0].length) && board[x][y - 1] == 'O') {
            dfs(board, x, y - 1);
        }
    }

    boolean areCoordinatesOutOfBound(int x, int y, int maxRows, int maxColumns) {
        return (x < 0 || y < 0 || x >= maxRows || y >= maxColumns);
    }
    
}
