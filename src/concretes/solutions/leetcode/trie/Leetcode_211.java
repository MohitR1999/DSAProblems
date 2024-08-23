package concretes.solutions.leetcode.trie;

import abstracts.Solution;
import concretes.leetcode.trie.Trie;

public class Leetcode_211 extends Solution   {

    @Override
    public void prepareInput() {
        
    }

    @Override
    public void prepareOutput() {
        
    }

    @Override
    public void solveProblem() {
        Trie trie = new Trie();
        trie.insert("at");
        trie.insert("and");
        trie.insert("an");
        trie.insert("add");

        trie.search("a");
        trie.search(".at");

        trie.insert("bat");
        trie.search(".at");
    }


    
}
