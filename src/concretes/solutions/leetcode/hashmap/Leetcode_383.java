package concretes.solutions.leetcode.hashmap;

import abstracts.Solution;
import java.util.*;

public class Leetcode_383 extends Solution {

    private String ransomNote;
    private String magazine;
    private Boolean res;

    @Override
    public void prepareInput() {
        Iterator<String> iterator = this.input.iterator();
        ransomNote = iterator.next();
        magazine = iterator.next();
    }

    @Override
    public void prepareOutput() {
        this.output.add(res + " ");
    }

    @Override
    public void solveProblem() {
        res = this.canConstruct(ransomNote, magazine);
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : magazine.toCharArray()) {
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }

        for (char ch : ransomNote.toCharArray()) {
            if (map.containsKey(ch) && map.get(ch) >= 1) {
                map.put(ch, map.get(ch) - 1);
            } else {
                return false;
            }
        }

        return true;
    }
    
}
