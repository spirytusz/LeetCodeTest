package newcoder;

/**
 * Link: https://www.nowcoder.com/practice/ef068f602dde4d28aab2b210e859150a?tpId=13&tqId=11214&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * Status: AC
 *
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。
 *
 * 解析：
 * 按照root.left, root, root.right的顺序遍历
 * 因为root.left < root < root.right
 */

import Utils.TreeNode;

public class KthSortedNode {

    TreeNode kthNode(TreeNode pRoot, int k) {
        if (pRoot == null) return null;
        TreeNode[] result = new TreeNode[1];
        kthNodeInternal(pRoot, result, new int[]{k});
        return result[0];
    }

    private void kthNodeInternal(TreeNode root, TreeNode[] result, int[] k) {
        if (result[0] != null) return;
        if (k[0] > 0 && root.left != null) {
            kthNodeInternal(root.left, result, k);
        }
        if (--k[0] == 0) {
            result[0] = root;
        }
        if (k[0] > 0 && root.right != null) {
            kthNodeInternal(root.right, result, k);
        }
    }

    public static void main(String[] args) {
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(8);
        t4.left = t3;
        t3.left = t2;
        t4.right = t7;
        t7.left = t6;
        t7.right = t8;
        System.out.println(new KthSortedNode().kthNode(t4, 6).val);
    }
}
