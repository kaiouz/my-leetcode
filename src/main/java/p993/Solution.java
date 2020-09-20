package p993;


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

    public boolean isCousins(TreeNode root, int x, int y) {
        LinkedList<TreeNode> queue = new LinkedList<>();

        if (root != null) {
            queue.addLast(root);
        }

        int size = 0;
        int level = 0;
        int f = -1;
        int parent = -1;

        while ((size = queue.size()) > 0) {
            level++;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.pollFirst();

                if (node.left != null) {
                    if (node.left.val == x || node.left.val == y) {
                        if (f == -1) {
                            f = level;
                            parent = node.val;
                        } else {
                            return f == level;
                        }
                    }
                    queue.addLast(node.left);
                }

                if (node.right != null) {
                    if (node.right.val == x || node.right.val == y) {
                        if (f == -1) {
                            f = level;
                            parent = node.val;
                        } else {
                            return f == level && node.val != parent;
                        }
                    }
                    queue.addLast(node.right);
                }
            }
        }

        return false;
    }


}
