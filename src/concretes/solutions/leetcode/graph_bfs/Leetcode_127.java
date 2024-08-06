package concretes.solutions.leetcode.graph_bfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import abstracts.Solution;

public class Leetcode_127 extends Solution {

    private String beginWord;
    private String endWord;
    private List<String> wordList;
    private int result;

    @Override
    public void prepareInput() {
        Iterator<String> iterator = this.input.iterator();
        beginWord = iterator.next();
        endWord = iterator.next();
        int size = Integer.parseInt(iterator.next());
        wordList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            wordList.add(iterator.next());
        }
    }

    @Override
    public void prepareOutput() {
        this.output.add(result + "");
    }

    @Override
    public void solveProblem() {
       this.result = ladderLength(beginWord, endWord, wordList);
    }

    class WordLevel {
        private String word;
        private int distance;

        public WordLevel(String word, int distance) {
            this.word = word;
            this.distance = distance;
        }

        public String getWord() {
            return word;
        }

        public void setWord(String word) {
            this.word = word;
        }

        public int getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }

        @Override
        public String toString() {
            return String.format("{ word : %s, distance : %d }", word, distance);
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((word == null) ? 0 : word.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            WordLevel other = (WordLevel) obj;
            if (word == null) {
                if (other.word != null)
                    return false;
            } else if (!word.equals(other.word))
                return false;
            return true;
        }        

    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> visitedWords = new HashSet<>();
        Set<String> validWords = new HashSet<>();
        wordList.stream().forEach(word -> validWords.add(word));
        Queue<WordLevel> queue = new LinkedList<>();
        WordLevel destinationLevel = null;
        queue.add(new WordLevel(beginWord, 0));

        while (!queue.isEmpty()) {
            WordLevel level = queue.poll();
            visitedWords.add(level.getWord());
            if (level.getWord().equals(endWord)) {
                destinationLevel = level;
                break;
            }

            for (int i = 0; i < level.getWord().length(); i++) {
                for (char letter = 'a'; letter <= 'z'; letter++) {
                    String newLevel = level.getWord().substring(0, i) + letter + level.getWord().substring(i + 1);
                    WordLevel newWordLevel = new WordLevel(newLevel, level.getDistance() + 1);
                    if (validWords.contains(newLevel) 
                            && !newLevel.equals(level.getWord())
                            && !visitedWords.contains(newLevel)
                            && !queue.contains(newWordLevel)
                            ) {
                        queue.add(newWordLevel);
                    }
                }
            }
        }

        return destinationLevel != null ? destinationLevel.getDistance() + 1 : 0;
    }
}
