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

public class Leetcode_199 extends Solution {

    private Tree tree;
    private TreeNode root;
    private List<Integer> l;

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
        for (int i : l) {
            this.output.add(i + " ");
        }
    }

    @Override
    public void solveProblem() {
        this.l = this.rightSideView(root);
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root != null) {
            Queue<TreeNode> queue = new LinkedList<>();
            Map<TreeNode, Integer> levelMap = new HashMap<>();
            Map<Integer, List<TreeNode>> levelledTree = new HashMap<>();
            queue.add(root);
            levelMap.put(root, 1);
            while (!queue.isEmpty()) {
                TreeNode temp = queue.peek();
                queue.remove();
                // process temp node
                int currentLevel = levelMap.get(temp);
                if (levelledTree.containsKey(currentLevel)) {
                    levelledTree.get(currentLevel).add(temp);
                } else {
                    levelledTree.put(currentLevel, new ArrayList<>(Arrays.asList(temp)));
                }

                // process child nodes
                if (temp.left != null) {
                    queue.add(temp.left);
                    levelMap.put(temp.left, currentLevel + 1);
                }

                if (temp.right != null) {
                    queue.add(temp.right);
                    levelMap.put(temp.right, currentLevel + 1);
                }
            }

            // level order traversal of the tree is done, now we need to just 
            // print the last element of each level for right index

            for (int i = 1;  i <= levelledTree.size(); i++) {
                List<TreeNode> level = levelledTree.get(i);
                list.add(level.get(level.size() - 1).val); 
            }
        }
        return list;    
    }
    
}
