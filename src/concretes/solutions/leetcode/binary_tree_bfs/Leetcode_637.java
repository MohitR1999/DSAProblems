package concretes.solutions.leetcode.binary_tree_bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import abstracts.Solution;
import concretes.leetcode.trees.Tree;
import concretes.leetcode.trees.TreeNode;

public class Leetcode_637 extends Solution {

    private Tree tree;
    private TreeNode root;
    private List<Double> l;

    @Override
    public void prepareInput() {
        Iterator<String> iterator = this.input.iterator();
        this.tree = new Tree();
        while (iterator.hasNext()) {
            int data = Integer.parseInt(iterator.next());
            tree.insertLevelOrder(data);
        }
        this.root = tree.getRoot();
    }

    @Override
    public void prepareOutput() {
        for (double i : l) {
            this.output.add(i + " ");
        }
    }

    @Override
    public void solveProblem() {
        this.l = this.averageOfLevels(root);
    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<>();
        Map<TreeNode, Integer> levelMap = new HashMap<>();
        Map<Integer, List<TreeNode>> levelledTree = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        levelMap.put(root, 1);
        while (!queue.isEmpty()) {
            TreeNode node = queue.peek();
            queue.remove();
            int level = levelMap.get(node);
            if (levelledTree.containsKey(level)) {
                levelledTree.get(level).add(node);
            } else {
                levelledTree.put(level, new ArrayList<>(Arrays.asList(node)));
            }

            if (node.left != null) {
                queue.add(node.left);
                levelMap.put(node.left, level + 1);
            }

            if (node.right != null) {
                queue.add(node.right);
                levelMap.put(node.right, level + 1);
            }
        }

        for (int i = 1; i <= levelledTree.size(); i++) {
            List<TreeNode> levelList = levelledTree.get(i);
            list.add(getAverage(levelList));
        }

        return list;
    }

    public Double getAverage(List<TreeNode> list) {
        double sum = 0;
        for (TreeNode node : list) {
            sum += node.val;
        }
        return sum / list.size();
    }
    
}
