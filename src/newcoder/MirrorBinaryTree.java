package newcoder;

/**
 * Link: https://www.nowcoder.com/practice/564f4c26aa584921bc75623e48ca3011?tpId=13&&tqId=11171&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * Status: AC
 *
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * <p>
 * 输入描述:
 *
 * 二叉树的镜像定义：源二叉树
 *     	    8
 *     	   /  \
 *     	  6   10
 *     	 / \  / \
 *     	5  7 9 11
 *
 *     	镜像二叉树
 *     	    8
 *     	   /  \
 *     	  10   6
 *     	 / \  / \
 *     	11 9 7  5
 */

import Utils.TreeNode;

public class MirrorBinaryTree {
    public void mirror(TreeNode root) {
        if (root != null) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            mirror(root.left);
            mirror(root.right);
        }
    }

    private void search(TreeNode root) {
        if (root != null) {
            System.out.println(root.val);
            search(root.left);
            search(root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode t8 = new TreeNode(8);
        TreeNode t6 = new TreeNode(6);
        TreeNode t5 = new TreeNode(5);
        TreeNode t7 = new TreeNode(7);
        TreeNode t10 = new TreeNode(10);
        TreeNode t9 = new TreeNode(9);
        TreeNode t11 = new TreeNode(11);
        t8.left = t6;
        t8.right = t10;
        t6.left = t5;
        t6.right = t7;
        t10.left = t9;
        t10.right = t11;
        new MirrorBinaryTree().mirror(t8);
        new MirrorBinaryTree().search(t8);
    }
}
