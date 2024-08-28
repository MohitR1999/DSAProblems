/*
 * Is Anagram

Given two strings s and t, return true if the two strings are anagrams of each other, otherwise return false.
An anagram is a string that contains the exact same characters as another string, but the order of the characters can be different.
 */
package concretes.solutions.neetcode.arrays_and_hashing;

import java.util.Arrays;
import java.util.Iterator;

import abstracts.Solution;

public class Neetcode_2 extends Solution {

    private String s;
    private String t;
    private boolean result;

    @Override
    public void prepareInput() {
        Iterator<String> iterator = this.input.iterator();
        s = iterator.next();
        t = iterator.next();
    }

    @Override
    public void prepareOutput() {
        this.output.add(result + "");
    }

    @Override
    public void solveProblem() {
        this.result = this.isAnagram(s, t);
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        char sArr[] = s.toCharArray();
        char tArr[] = t.toCharArray();
        Arrays.sort(sArr);
        Arrays.sort(tArr);
        for (int i = 0; i < s.length(); i++) {
            if (sArr[i] != tArr[i]) return false;
        }
        return true;
    }
    
}
