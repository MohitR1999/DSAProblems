package concretes.solutions.leetcode.heap;

import abstracts.Solution;
import java.util.*;

public class Leetcode_502 extends Solution {

    private int k;
    private int w;
    private int[] profits;
    private int[] capital;
    private int max;

    class Project {
        private int profit;
        private int capital;

        public Project(int profit, int capital) {
            this.profit = profit;
            this.capital = capital;
        }

        public int getProfit() {
            return profit;
        }
        public void setProfit(int profit) {
            this.profit = profit;
        }
        public int getCapital() {
            return capital;
        }
        public void setCapital(int capital) {
            this.capital = capital;
        }
        
    }

    class ProjectComparator implements Comparator<Project> {

        @Override
        public int compare(Project arg0, Project arg1) {
            int capitalCompare = arg0.getCapital() - arg1.getCapital();
            int profitCompare = arg1.getProfit() - arg0.getProfit();
            return capitalCompare == 0 ? profitCompare : capitalCompare;
        }

    }

    @Override
    public void prepareInput() {
        Iterator<String> iterator = this.input.iterator();
        int n = Integer.parseInt(iterator.next());
        this.k = Integer.parseInt(iterator.next());
        this.w = Integer.parseInt(iterator.next());
        profits = new int[n];
        capital = new int[n];
        for (int i = 0; i < n; i++) {
            profits[i] = Integer.parseInt(iterator.next());
        }

        for (int i = 0; i < n; i++) {
            capital[i] = Integer.parseInt(iterator.next());
        }
    }

    @Override
    public void prepareOutput() {
        this.output.add(this.max + "\n");
    }

    @Override
    public void solveProblem() {
        this.max = findMaximizedCapital(k, w, profits, capital);
    }

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        List<Project> projects = new ArrayList<>();
        for (int i = 0; i < profits.length; i++) {
            projects.add(new Project(profits[i], capital[i]));
        }
        projects.sort((a, b) -> a.getCapital() - b.getCapital());
        int maxCapital = w;
        int j = 0;
        for (int i = 0; i < k; i++) {
            while (j < projects.size() && projects.get(j).getCapital() <= maxCapital) {
                queue.offer(projects.get(j).getProfit());
                j++;
            }

            if (queue.isEmpty()) break;
            maxCapital += queue.poll();
        }

        return maxCapital;
    }
    
}
