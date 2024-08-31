package concretes.solutions.neetcode.arrays_and_hashing;

import java.util.Iterator;
import abstracts.Solution;

public class Neetcode_8 extends Solution {

    private char[][] board;
    private boolean status;

    @Override
    public void prepareInput() {
        this.board = new char[9][9];
        Iterator<String> iterator = this.input.iterator();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                this.board[i][j] = iterator.next().toCharArray()[0];
            }
        }
    }

    @Override
    public void prepareOutput() {
        this.output.add(this.status + " ");
    }

    @Override
    public void solveProblem() {
        this.status = this.isValidSudoku(board);
    }

    public boolean isValidSudoku(char[][] board) {
        // initialize a map that can store boolean values
        boolean[] map = new boolean[10];
        resetMap(map);
        // check if the row is valid
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    int index = Character.getNumericValue(board[i][j]);
                    if (map[index] == true) {
                        return false;
                    }
                    map[index] = true;
                }
            }
            resetMap(map);
        }
        // reset the map to false
        resetMap(map);
        // check if the column is valid
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[j][i] != '.') {
                    int index = Character.getNumericValue(board[j][i]);
                    if (map[index] == true) {
                        return false;
                    }
                    map[index] = true;
                }
            }
            resetMap(map);
        }
        
        // check grid by grid
        for (int start_x = 0; start_x < 9; start_x += 3) {
            for (int start_y = 0; start_y < 9; start_y += 3) {
                for (int i = start_x; i < start_x + 3; i++) {
                    for (int j = start_y; j < start_y + 3; j++) {
                        if (board[i][j] != '.') {
                            int index = Character.getNumericValue(board[i][j]);
                            if (map[index] == true) {
                                return false;
                            }
                            map[index] = true;
                        }
                    }
                }
                resetMap(map);
            }
        }

        return true;
    }

    public void resetMap(boolean[] map) {
        for (int i = 0; i < map.length; i++) {
            map[i] = false;
        }
    }
    
}

