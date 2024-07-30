package concretes.solutions.leetcode.hashmap;

import java.util.HashMap;
import java.util.Map;

import abstracts.Solution;

public class Leetcode_205 extends Solution {

    private String s;
    private String t;
    private Boolean result;

    @Override
    public void prepareInput() {
        this.s = this.input.get(0);
        this.t = this.input.get(1);
    }

    @Override
    public void prepareOutput() {
        this.output.add(this.result + "");
    }

    @Override
    public void solveProblem() {
        this.result = this.isIsomorphic(s, t);
    }

    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) != t.charAt(i)) {
                return false;
            }
            map.put(s.charAt(i), t.charAt(i));
        }
        map.clear();
        for (int i = 0; i < t.length(); i++) {
            if (map.containsKey(t.charAt(i)) && map.get(t.charAt(i)) != s.charAt(i)) {
                return false;
            }
            map.put(t.charAt(i), s.charAt(i));
        }

        return true;
    }

}
