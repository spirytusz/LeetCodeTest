package newcoder;

import Utils.TreeNode;

/**
 * Link: https://www.nowcoder.com/practice/8a19cbe657394eeaac2f6ea9b0f6fcf6?tpId=13&&tqId=11157&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * Status: AC
 * <p>
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 *
 * 解析：
 * 前序遍历pre = {1,2,4,7,3,5,6,8}
 * 中序遍历in = {4,7,2,1,5,3,8,6}
 *
 * 由前序遍历的性质可知，1必然为根节点；
 * 由中序遍历的性质可知，in[0 until 3]必为左子树，in[4 until in.length]必为右子树；
 * 其中，左子树节点数 = 3 - 0 = 3，右子树节点数in.length - 4 = 8 - 4 = 4；
 * 从而，pre[1 until 1 + 3]必为左子树节点，pre[1 + 3 until pre.length]必为右子树节点；
 * 分别为左子树，右子树，再当做root节点，向下递归重建二叉树。
 */
public class ReConstructBinaryTree {

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre.length != in.length || pre.length == 0) return null;
        return reConstructBinaryTreeInternal(pre, in, 0, pre.length - 1, 0, in.length - 1);
    }

    private TreeNode reConstructBinaryTreeInternal(int[] pre, int[] in, int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight) {
            return null;
        } else {
            int root = pre[preLeft];
            TreeNode node = new TreeNode(root);
            for (int i = inLeft; i <= inRight; i++) {
                if (root == in[i]) {
                    int leftCount = i - inLeft;
                    int rightCount = inRight - i;
                    node.left = reConstructBinaryTreeInternal(pre, in, preLeft + 1, preLeft + leftCount, inLeft, i - 1);
                    node.right = reConstructBinaryTreeInternal(pre, in, preRight - rightCount + 1, preRight, i + 1, inRight);
                    break;
                }
            }
            return node;
        }
    }

    private void preSearch(TreeNode node) {
        if (node == null) return;
        preSearch(node.left);
        System.out.print(node.val + "\t");
        preSearch(node.right);
    }

    public static void main(String[] args) {
        TreeNode node = new ReConstructBinaryTree().reConstructBinaryTree(new int[]{8, 6, 5, 7, 10, 9, 11}, new int[]{5, 6, 7, 8, 9, 10, 11});
        new ReConstructBinaryTree().preSearch(node);
    }
}
