package ms4050;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {

    public boolean isValidBST(TreeNode root) {
        return isvalied(root, null, null);
    }

    private boolean isvalied(TreeNode root, Integer low, Integer high) {
        if (root == null) {
            return true;
        }

        if (low != null && root.val <= low) {
            return false;
        }

        if (high != null && root.val >= high) {
            return false;
        }

        return isvalied(root.left, low, root.val) && isvalied(root.right, root.val, high);
    }
    
}
