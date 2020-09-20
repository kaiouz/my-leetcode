package p297;

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
        String[] vals = data.split(",");
        int[] index = {0};
        return deserialize(vals, index);
    }

    private TreeNode deserialize(String[] vals, int[] index) {
        int i = index[0]++;
        if (vals[i].equals("n")) {
            return null;
        }
        TreeNode treeNode = new TreeNode(Integer.parseInt(vals[i]));
        treeNode.left = deserialize(vals, index);
        treeNode.right = deserialize(vals, index);
        return treeNode;
    }

    public static void main(String[] args) {
        TreeNode n5 = new TreeNode(5);
        TreeNode n4 = new TreeNode(4);
        TreeNode n3 = new TreeNode(3);
        n3.left = n4;
        n3.right = n5;
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        n1.left = n2;
        n1.right = n3;

        Codec codec = new Codec();
        String str = codec.serialize(n1);
        System.out.println(str);
    }
}
