package p662;

import java.util.LinkedList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {

    static class Node {

        public Node(TreeNode treeNode, int num) {
            this.treeNode = treeNode;
            this.num = num;
        }

        TreeNode treeNode;
        int num;
    }

    public int widthOfBinaryTree(TreeNode root) {
        int max = 0;

        LinkedList<Node> queue = new LinkedList<>();

        queue.addLast(new Node(root, 1));

        int size = 0;

        while ((size = queue.size()) > 0) {
            int start = 0;
            int end = 0;

            for (int i = 0; i < size; i++) {
                Node node = queue.removeFirst();

                if (i == size - 1) {
                    end = node.num;
                } else if (i == 0) {
                    start = node.num;
                }

                if (node.treeNode.left != null) {
                    queue.addLast(new Node(node.treeNode.left, node.num * 2));
                }
                if (node.treeNode.right != null) {
                    queue.addLast(new Node(node.treeNode.right, node.num * 2 + 1));
                }
            }

            max = Math.max(max, end - start + 1);
        }

        return max;
    }


}
