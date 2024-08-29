package concretes.solutions.neetcode.arrays_and_hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import abstracts.Solution;

public class Neetcode_4 extends Solution{

    private int n;
    private String[] strs;
    private List<List<String>> result;

    @Override
    public void prepareInput() {
        Iterator<String> iterator = this.input.iterator();
        this.n = Integer.parseInt(iterator.next());
        strs = new String[n];
        for (int i = 0; i < n; i++) {
            this.strs[i] = iterator.next();
        }
    }

    @Override
    public void prepareOutput() {
        for (int i = 0; i < this.result.size(); i++) {
            StringBuilder builder = new StringBuilder("[");
            for (int j = 0; j < this.result.get(i).size(); j++) {
                builder.append(this.result.get(i).get(j) + ", ");
            }
            builder.append("]\n");
            this.output.add(builder.toString());
        }
    }

    @Override
    public void solveProblem() {
        this.result = this.groupAnagrams(strs);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        
        List<String> sortedStringList = new ArrayList<>(Arrays.asList(strs)).stream().map(str -> {
            char temp[] = str.toCharArray();
            Arrays.sort(temp);
            return new String(temp);
        }).collect(Collectors.toList());

        Map<String, List<String>> map = new HashMap<>();
        for (String str : sortedStringList) {
            if (!map.containsKey(str)) {
                map.put(str, new ArrayList<>());
            }
        }

        for (int i = 0; i < strs.length; i++) {
            map.get(sortedStringList.get(i)).add(strs[i]);
        }

        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            result.add(entry.getValue());
        }

        return result;
    }
    
}
