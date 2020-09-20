package p124;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {

    // 初始化成最小的值
    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxScore(root);
        return max;
    }

    /**
     * 以节点node为起点，往下的最大的路径和
     *
     * @param node
     * @return
     */
    private int maxScore(TreeNode node) {
        // 没有节点，值认为是0
        if (node == null) {
            return 0;
        }

        // 如果子树的路径和是负的，那么该节点的路径和就不要加上子树的了，
        // 加上只会变小
        int left = Math.max(maxScore(node.left), 0);
        int right = Math.max(maxScore(node.right), 0);

        // 计算经过node并且node是路径中层级最小的节点的路径的最大路径和
        // 这种做法可以覆盖所有的节点
        int currentMaxPathSum = node.val + left + right;
        max = Math.max(currentMaxPathSum, max);


        // 返回该节点的最大路径和
        return node.val + Math.max(left, right);
    }
}
