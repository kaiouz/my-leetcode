package p889;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    private int preStart = 0;
    private int postStart = 0;
    private int postEnd;

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        preStart = 0;
        postStart = 0;
        postEnd = post.length;

        return helper(pre, post);
    }

    private TreeNode helper(int[] pre, int[] post) {
        if (preStart >= pre.length) {
            return null;
        }
        if (postStart >= postEnd) {
            return null;
        }

        TreeNode node = new TreeNode(pre[preStart]);

        int p = postStart;
        for (int i = postStart; i < postEnd; i++) {
            if (pre[preStart] == post[i]) {
                p = i;
                break;
            }
        }
        int postEndC = postEnd;
        postEnd = p;

        preStart++;
        node.left = helper(pre, post);
        node.right = helper(pre, post);

        postStart = p+1;
        postEnd = postEndC;
        return node;
    }

}
