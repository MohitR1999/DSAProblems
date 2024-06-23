package abstracts;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import concretes.reader.Reader;

public abstract class Solution {
    protected List<String> input = new ArrayList<>();
    protected List<String> output = new ArrayList<>();

    public final void solve() {
        handleInput();
        prepareInput();
        solveProblem();
        prepareOutput();
        handleOutput();
    }

    private void handleInput() {
        Scanner scanner = Reader.getInstance().getScanner();
        while (scanner.hasNext()) {
            String inputChunk = scanner.next();
            input.add(inputChunk);
        }
    }

    private void handleOutput() {
        for (String s : output) {
            System.out.print(s);
        }
    }

    public abstract void prepareInput();
    public abstract void solveProblem();
    public abstract void prepareOutput();
}
