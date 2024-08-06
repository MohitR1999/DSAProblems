package concretes.solutions.leetcode.graph_bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import abstracts.Solution;

public class Leetcode_433 extends Solution {

    private String startGene;
    private String endGene;
    private String[] bank;
    private int result;

    class MutationLevel {
        String gene;
        int distance;
        
        public MutationLevel(String gene, int distance) {
            this.gene = gene;
            this.distance = distance;
        }

        public String getGene() {
            return gene;
        }
        public void setGene(String gene) {
            this.gene = gene;
        }
        public int getDistance() {
            return distance;
        }
        public void setDistance(int distance) {
            this.distance = distance;
        }

        @Override
        public String toString() {
            return String.format("{ gene : %s, distance : %d }", this.gene, this.distance);
        }
        
        
    }

    @Override
    public void prepareInput() {
        Iterator<String> iterator = this.input.iterator();
        startGene = iterator.next();
        endGene = iterator.next();
        int size = Integer.parseInt(iterator.next());
        bank = new String[size];
        for (int i = 0; i < size; i++) {
            bank[i] = iterator.next();
        }
    }

    @Override
    public void prepareOutput() {
        this.output.add(result + "");
    }

    @Override
    public void solveProblem() {
        this.result = minMutation(startGene, endGene, bank);
    }
    
    public int minMutation(String startGene, String endGene, String[] bank) {
        MutationLevel destination = null;
        List<String> validGeneList = new ArrayList<>();
        Set<String> visitedGenes = new HashSet<>();
        for (String gene : bank) {
            validGeneList.add(gene);
        }
        Queue<MutationLevel> queue = new LinkedList<>();
        queue.add(new MutationLevel(startGene, 0));
        while (!queue.isEmpty()) {
            MutationLevel level = queue.poll();
            visitedGenes.add(level.getGene());
            if (level.getGene().equals(endGene)) {
                destination = level;
                break;
            }

            for (int i = 0; i < level.getGene().length(); i++) {
                String mutationA = level.getGene().substring(0, i) + 'A' + level.getGene().substring(i + 1);
                String mutationC = level.getGene().substring(0, i) + 'C' + level.getGene().substring(i + 1);
                String mutationG = level.getGene().substring(0, i) + 'G' + level.getGene().substring(i + 1);
                String mutationT = level.getGene().substring(0, i) + 'T' + level.getGene().substring(i + 1);

                if (validGeneList.indexOf(mutationA) >= 0 && !mutationA.equals(level.getGene()) && !visitedGenes.contains(mutationA)) {
                    queue.add(new MutationLevel(mutationA, level.getDistance() + 1));
                }

                if (validGeneList.indexOf(mutationC) >= 0 && !mutationC.equals(level.getGene()) && !visitedGenes.contains(mutationC)) {
                    queue.add(new MutationLevel(mutationC, level.getDistance() + 1));

                }

                if (validGeneList.indexOf(mutationG) >= 0 && !mutationG.equals(level.getGene()) && !visitedGenes.contains(mutationG)) {
                    queue.add(new MutationLevel(mutationG, level.getDistance() + 1));

                }

                if (validGeneList.indexOf(mutationT) >= 0 && !mutationT.equals(level.getGene()) && !visitedGenes.contains(mutationT)) {
                    queue.add(new MutationLevel(mutationT, level.getDistance() + 1));
                }
            }
        }

        return destination != null ? destination.getDistance() : -1;
    }
}
