package concretes.leetcode.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import abstracts.Solution;

public class Leetcode_17 extends Solution {
    private String digitsString;
    private List<String> result;

    @Override
    public void prepareInput() {
        if (this.input.iterator().hasNext()) {
            this.digitsString = this.input.iterator().next();
        } else {
            this.digitsString = "";
        }
        
    }

    @Override
    public void prepareOutput() {
        this.output.addAll(this.result.stream().map(s -> s + " ").collect(Collectors.toList()));
    }

    @Override
    public void solveProblem() {
        this.result = this.letterCombinations(digitsString);
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) return result;
        Map<Character, Character[]> lookupMap = new HashMap<>();
        lookupMap.put('2', new Character[]{'a', 'b', 'c'});
        lookupMap.put('3', new Character[]{'d', 'e', 'f'});
        lookupMap.put('4', new Character[]{'g', 'h', 'i'});
        lookupMap.put('5', new Character[]{'j', 'k', 'l'});
        lookupMap.put('6', new Character[]{'m', 'n', 'o'});
        lookupMap.put('7', new Character[]{'p', 'q', 'r', 's'});
        lookupMap.put('8', new Character[]{'t', 'u', 'v'});
        lookupMap.put('9', new Character[]{'w', 'x', 'y', 'z'});
        solver(digits.length(), result, "", lookupMap, digits, 0);
        return result;
    }

    public void solver(int size, List<String> result, String holder, Map<Character, Character[]> lookupMap, String digitString, int currentPosition) {
        if (holder.length() == size) {
            result.add(holder);
            return;
        }

        for (int i = 0; i < lookupMap.get(digitString.charAt(currentPosition)).length; i++) {
            Character[] possibleCharacters = lookupMap.get(digitString.charAt(currentPosition));
            solver(size, result, holder + possibleCharacters[i], lookupMap, digitString, currentPosition + 1);
        }
    }
    
}
