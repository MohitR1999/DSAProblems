package concretes.solutions.leetcode.trie;

import abstracts.Solution;
import concretes.leetcode.trie.Trie;

public class Leetcode_208 extends Solution {

    private Trie trie;

    @Override
    public void prepareInput() {
    }

    @Override
    public void prepareOutput() {
        
    }

    @Override
    public void solveProblem() {
        this.trie = new Trie();
        trie.insert("apple");
        System.out.println("trie.search(\"apple\"): " + trie.search("apple"));
        System.out.println("trie.search(\"app\"): " + trie.search("app"));
        System.out.println("trie.startsWith(\"app\"): " + trie.startsWith("app"));
        trie.insert("app");
        System.out.println("trie.search(\"app\"): " + trie.search("app"));
    }
    
}
