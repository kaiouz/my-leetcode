package ms872;

import java.util.Iterator;
import java.util.LinkedList;

  class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }

class Solution {

    LinkedList<Integer> list = new LinkedList<>();

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        add(root1);
        Iterator<Integer> iterator = list.iterator();
        return check(root2, iterator) && !iterator.hasNext();
    }

    private void add(TreeNode root) {
        if (root.left == null && root.right == null) {
            list.add(root.val);
            return;
        }
        if (root.left != null) {
            add(root.left);
        }
        if (root.right != null) {
            add(root.right);
        }
    }

    private boolean check(TreeNode root, Iterator<Integer> iterator) {
        if (root.left == null && root.right == null) {
            return iterator.hasNext() && iterator.next() == root.val;
        }

        return (root.left == null || check(root.left, iterator))
                && (root.right == null || check(root.right, iterator));
    }

}
