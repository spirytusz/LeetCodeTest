package newcoder;

import Utils.TreeNode;

/**
 * Link: https://www.nowcoder.com/practice/ff05d44dfdb04e1d83bdbdab320efbcb?tpId=13&&tqId=11211&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * Status: AC
 * <p>
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class SymmetricalBinaryTree {
    public boolean isSymmetrical(TreeNode pRoot) {
        return pRoot == null || symmetricalBinaryTree(pRoot.left, pRoot.right);
    }

    private boolean symmetricalBinaryTree(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null || right == null) {
            return false;
        } else {
            return left.val == right.val && symmetricalBinaryTree(left.left, right.right) && symmetricalBinaryTree(left.right, right.left);
        }
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t21 = new TreeNode(2);
        TreeNode t22 = new TreeNode(2);
        TreeNode t31 = new TreeNode(3);
        TreeNode t32 = new TreeNode(3);
        TreeNode t41 = new TreeNode(4);
        TreeNode t42 = new TreeNode(4);

        t1.left = t21;
        t1.right = t22;
        t21.left = t31;
        t21.right = t41;
        t22.left = t42;
        t22.right = t32;
        System.out.println(new SymmetricalBinaryTree().isSymmetrical(t1));;
    }
}
