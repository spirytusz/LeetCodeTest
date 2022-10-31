package acwing;

/**
 * <a href="https://www.acwing.com/problem/content/66/">70. 二叉搜索树的第k个结点</a>
 */
public class KthNodeInSortedBinaryTree {
    public TreeNode kthNode(TreeNode root, int k) {
        TreeNode[] result = new TreeNode[1];
        inOrder(root, result, new int[]{k});
        return result[0];
    }

    private void inOrder(TreeNode node, TreeNode[] result, int[] k) {
        if (node == null) {
            return;
        }

        inOrder(node.left, result, k);
        k[0]--;
        if (k[0] == 0) {
            result[0] = node;
        }
        inOrder(node.right, result, k);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        n2.left = n1;
        n2.right = n3;

        System.out.println(new KthNodeInSortedBinaryTree().kthNode(n2, 3).val);
    }

}
