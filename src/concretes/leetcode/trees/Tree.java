package concretes.leetcode.trees;

import java.util.LinkedList;
import java.util.Queue;

public class Tree {
    public TreeNode root;

    public void insertLevelOrder(int data) {
        if (this.root == null) {
            this.root = new TreeNode(data);
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode temp = queue.peek();
            queue.remove();

            if (temp.left == null) {
                temp.left = new TreeNode(data);
                break;
            } else {
                queue.add(temp.left);
            }


            if (temp.right == null) {
                temp.right = new TreeNode(data);
                break;
            } else {
                queue.add(temp.right);
            }
        }
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }
}
