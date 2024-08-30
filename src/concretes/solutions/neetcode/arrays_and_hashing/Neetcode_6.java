package concretes.solutions.neetcode.arrays_and_hashing;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import abstracts.Solution;

public class Neetcode_6 extends Solution {

    private int n;
    private List<String> strings;
    private String encodedString;
    private List<String> decodedStrings;


    @Override
    public void prepareInput() {
        Iterator<String> iterator = this.input.iterator();
        this.strings = new ArrayList<>();
        this.n = Integer.parseInt(iterator.next());
        while(iterator.hasNext()) {
            strings.add(iterator.next());
        }
        
    }

    @Override
    public void prepareOutput() {
        this.output.add(String.format("Encoded string: %s\n", encodedString));
        this.output.add("Decoded string: \n");
        for (String str : decodedStrings) {
            this.output.add( str + "\n");
        }
    }

    @Override
    public void solveProblem() {
        this.encodedString = encode(strings);
        this.decodedStrings = decode(encodedString);
    }
    
    public String encode(List<String> strs) {
        StringBuilder builder = new StringBuilder();
        for (String str : strs) {
            builder.append(str.length()).append("#").append(str);
        }
        return builder.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < str.length(); ) {
            int j = i;
            while (str.charAt(j) != '#') j++;
            int length = Integer.valueOf(str.substring(i, j));
            i = j + 1 + length;
            result.add(str.substring(j + 1, i));
        }
        return result;
    }
}
