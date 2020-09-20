package offer37;

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
            return "n";
        }
        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] ns = data.split(",");
        index = 0;
        return deserialize(ns);
    }

    private int index;

    private TreeNode deserialize(String[] ns) {
        if ("n".equals(ns[index])) {
            index++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(ns[index++]));
        node.left = deserialize(ns);
        node.right = deserialize(ns);
        return node;
    }

}
