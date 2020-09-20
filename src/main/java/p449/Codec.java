package p449;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }
        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }

    private int idx;

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        idx = 0;
        String[] str = data.split(",");
        return helper(str);
    }

    private TreeNode helper(String[] str) {
        if (idx >= str.length) {
            return null;
        }
        if ("#".equals(str[idx])) {
            idx++;
            return null;
        } else {
            TreeNode node = new TreeNode(Integer.parseInt(str[idx++]));
            node.left = helper(str);
            node.right = helper(str);
            return node;
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
