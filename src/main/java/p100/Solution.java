package p100;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

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

    public boolean isSameTree(TreeNode p, TreeNode q) {
        List<TreeNode> pl = new LinkedList<>();
        List<TreeNode> ql = new LinkedList<>();

        gen(pl, p);
        gen(ql, q);

        for (Iterator<TreeNode> pi = pl.iterator(), qi = ql.iterator(); ; ) {
            if (pi.hasNext() == qi.hasNext()) {
                if (pi.hasNext()) {
                     if (!eq(pi.next(), qi.next())) {
                         return false;
                     }
                } else {
                    return true;
                }
            } else {
                return false;
            }
        }
    }

    private void gen(List<TreeNode> list, TreeNode p) {
        list.add(p);

        if (p == null) {
            return;
        }

        gen(list, p.left);
        gen(list, p.right);
    }

    private boolean eq(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p != null && q != null) {
            return p.val == q.val;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);

        TreeNode q = new TreeNode(1);
        q.right = new TreeNode(2);

        System.out.println(new Solution().isSameTree(p, q));
    }
}
