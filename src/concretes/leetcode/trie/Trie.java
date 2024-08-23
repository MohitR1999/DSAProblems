package concretes.leetcode.trie;

class TrieNode {
    private TrieNode[] chilNodes;
    private boolean wordEnd;
    private char letter;
    
    public TrieNode() {
        this.wordEnd = false;
        this.chilNodes = new TrieNode[26];
        for (int i = 0; i < 26; i++) {
            chilNodes[i] = null;
        }
    }

    public TrieNode[] getChilNodes() {
        return chilNodes;
    }
    public void setChilNodes(TrieNode[] chilNodes) {
        this.chilNodes = chilNodes;
    }
    public boolean isWordEnd() {
        return wordEnd;
    }
    public void setWordEnd(boolean wordEnd) {
        this.wordEnd = wordEnd;
    }

    public char getLetter() {
        return letter;
    }

    public void setLetter(char letter) {
        this.letter = letter;
    }

}

public class Trie {

    public TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode currentNode = this.root;
        for (char ch : word.toCharArray()) {
            if (currentNode.getChilNodes()[ch - 'a'] == null) {
                TrieNode t = new TrieNode();
                t.setLetter(ch);
                currentNode.getChilNodes()[ch - 'a'] = t;
            }
            currentNode = currentNode.getChilNodes()[ch - 'a'];
        }
        currentNode.setWordEnd(true);
    }
    
    public boolean search(String word) {
        return searchHelper(word, 0, root);
    }

    private boolean searchHelper(String word, int index, TrieNode node) {
        if (node == null) {
            return false;
        }
        if (index == word.length()) {
            return node.isWordEnd();
        }
        char c = word.charAt(index);
        if (c == '.') {
            for (TrieNode child : node.getChilNodes()) {
                if (searchHelper(word, index + 1, child)) {
                    return true;
                }
            }
            return false;
        } else {
            int i = c - 'a';
            return searchHelper(word, index + 1, node.getChilNodes()[i]);
        }
    }

    public TrieNode getNode(String word) {
        TrieNode currentNode = this.root;
        for (char ch : word.toCharArray()) {
            if (currentNode.getChilNodes()[ch - 'a'] == null) return null;
            currentNode = currentNode.getChilNodes()[ch - 'a'];
        }

        return currentNode;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode node = this.getNode(prefix);
        if (node == null) return false;
        return true;
    }

}
