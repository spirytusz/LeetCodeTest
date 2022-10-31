/**
 * <a href="https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/">230. Kth Smallest Element in a BST</a>
 */
public class KthSmallestElementInBST {
    public int kthSmallest(TreeNode root, int k) {
        TreeNode result = kthSmallestNode(root, new int[]{k});
        return result != null ? result.val : -1;
    }

    private TreeNode kthSmallestNode(TreeNode node, int[] k) {
        if (node == null) {
            return null;
        }
        TreeNode left = kthSmallestNode(node.left, k);
        if (left != null) {
            return left;
        }
        k[0]--;
        if (k[0] == 0) {
            return node;
        }
        return kthSmallestNode(node.right, k);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);

        t3.left = t1;
        t3.right = t4;
        t1.right = t2;

        System.out.println(new KthSmallestElementInBST().kthSmallest(t3, 1));
        System.out.println(new KthSmallestElementInBST().kthSmallest(t3, 2));
        System.out.println(new KthSmallestElementInBST().kthSmallest(t3, 3));
        System.out.println(new KthSmallestElementInBST().kthSmallest(t3, 4));
    }
}
