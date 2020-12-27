package newcoder;

import Utils.TreeNode;

/**
 * Link: https://www.nowcoder.com/practice/6e196c44c7004d15b1610b9afca8bd88?tpId=13&&tqId=11170&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * Status:
 * <p>
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class HasSubtree {

    public boolean hasSubtree(TreeNode root1, TreeNode root2) {
        if (root2 == null) return false;
        return hasSubtreeInternal(root1, root2);
    }

    private boolean hasSubtreeInternal(TreeNode root1, TreeNode root2) {
        if (root1 != null && root2 != null) {
            if (root1.val == root2.val && hasSubtreeInternal(root1.left, root2.left) && hasSubtreeInternal(root1.right, root2.right)) {
                return true;
            } else {
                return hasSubtreeInternal(root1.left, root2) || hasSubtreeInternal(root1.right, root2);
            }
        } else if (root1 == null && root2 == null) {
            return true;
        } else {
            return root1 != null;
        }
    }

    public static void main(String[] args) {
        TreeNode tn81 = new TreeNode(8);
        TreeNode tn82 = new TreeNode(8);
        TreeNode tn71 = new TreeNode(7);
        TreeNode tn9 = new TreeNode(9);
        TreeNode tn2 = new TreeNode(2);
        TreeNode tn4 = new TreeNode(4);
        TreeNode tn72 = new TreeNode(7);
        tn81.left = tn82;
        tn81.right = tn71;
        tn82.left = tn9;
        tn82.right = tn2;
        tn9.left = tn4;
        tn9.right = tn72;
        System.out.println(new HasSubtree().hasSubtree(tn81, tn82));
    }
}
