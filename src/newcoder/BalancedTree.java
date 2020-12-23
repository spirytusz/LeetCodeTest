package newcoder;

/**
 * Link: https://www.nowcoder.com/practice/8b3b95850edb4115918ecebdf1b4d222?tpId=13&tqId=11190&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * Status: AC
 * <p>
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * 在这里，我们只需要考虑其平衡性，不需要考虑其是不是排序二叉树
 * 平衡二叉树（Balanced Binary Tree），具有以下性质：它是一棵空树或它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树。
 */

import Utils.TreeNode;

public class BalancedTree {

    public boolean isBalanced(TreeNode root) {
        return root == null || treeDepth(root) > 0;
    }

    private int treeDepth(TreeNode root) {
        if (root != null) {
            int ld = treeDepth(root.left);
            if (ld == -1) return -1;
            int rd = treeDepth(root.right);
            if (rd == -1) return -1;
            if (Math.abs(ld - rd) > 1) return -1;
            return Math.max(ld, rd) + 1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(9);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        n7.left = n8;
        n8.right = n9;
        System.out.println(new BalancedTree().isBalanced(null));
    }
}
