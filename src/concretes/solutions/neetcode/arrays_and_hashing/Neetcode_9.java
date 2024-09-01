/**
 * Find longest increasing sequence in an array
 */
package concretes.solutions.neetcode.arrays_and_hashing;

import java.util.HashSet;
import java.util.Set;

import abstracts.Solution;

public class Neetcode_9 extends Solution {

    @Override
    public void prepareInput() {
        
    }

    @Override
    public void prepareOutput() {
        
    }

    @Override
    public void solveProblem() {
        
    }
    
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }
        int longest = 0;
        for (int n : set) {
            if (!set.contains(n - 1)) {
                int length = 1;
                while (set.contains(n + length)) length++;
                longest = Math.max(length, longest);
            }
        }
        return longest; 
    }
}
