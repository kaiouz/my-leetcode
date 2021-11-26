package offer37;

import p141.Solution;

import java.util.LinkedList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }
        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        int i = 0;

        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode cur = new TreeNode(0);

        while (i < nodes.length) {
            if (nodes[i].equals("#")) {
                i++;
                while (i < nodes.length && nodes[i].equals("#")) {
                    cur = queue.pop();
                    i++;
                }
                if (i < nodes.length) {
                    cur.right = new TreeNode(Integer.parseInt(nodes[i]));
                    cur = cur.right;
                }
            } else {
                cur.left = new TreeNode(Integer.parseInt(nodes[i]));
                queue.push(cur);
                cur = cur.left;
            }
            i++;
        }

        return cur.left;
    }

    public static void main(String[] args) {
        TreeNode root = new Codec().deserialize("1,2,#,#,3,4,#,#,5,#,#");
        System.out.println(root);
    }

}
