import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/">105. Construct Binary Tree from Preorder and Inorder Traversal</a>
 *
 * <p>Given two integer arrays <code>preorder</code> and <code>inorder</code> where <code>preorder</code> is the preorder traversal of a binary tree and <code>inorder</code> is the inorder traversal of the same tree, construct and return <em>the binary tree</em>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/02/19/tree.jpg" style="width: 277px; height: 302px;" />
 * <pre>
 * <strong>Input:</strong> preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * <strong>Output:</strong> [3,9,20,null,null,15,7]
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> preorder = [-1], inorder = [-1]
 * <strong>Output:</strong> [-1]
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= preorder.length &lt;= 3000</code></li>
 * 	<li><code>inorder.length == preorder.length</code></li>
 * 	<li><code>-3000 &lt;= preorder[i], inorder[i] &lt;= 3000</code></li>
 * 	<li><code>preorder</code> and <code>inorder</code> consist of <strong>unique</strong> values.</li>
 * 	<li>Each value of <code>inorder</code> also appears in <code>preorder</code>.</li>
 * 	<li><code>preorder</code> is <strong>guaranteed</strong> to be the preorder traversal of the tree.</li>
 * 	<li><code>inorder</code> is <strong>guaranteed</strong> to be the inorder traversal of the tree.</li>
 * </ul>
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    private static int preorderIndex = 0;

    @SuppressWarnings("ClassEscapesDefinedScope")
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        preorderIndex = 0;
        return buildTreeImpl(preorder, buildInOrderIndexed(inorder), 0, preorder.length - 1);
    }

    private static TreeNode buildTreeImpl(int[] preorder, Map<Integer, Integer> inorderIndexed, int left, int right) {
        if (left > right || preorderIndex >= preorder.length) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[preorderIndex++]);
        int split = inorderIndexed.get(node.val);
        node.left = buildTreeImpl(preorder, inorderIndexed, left, split - 1);
        node.right = buildTreeImpl(preorder, inorderIndexed, split + 1, right);
        return node;
    }

    private static Map<Integer, Integer> buildInOrderIndexed(int[] inorder) {
        Map<Integer, Integer> indexed = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            indexed.put(inorder[i], i);
        }
        return indexed;
    }

    public static void main(String[] args) {
        testCase1();
        testCase2();
    }

    private static void testCase1() {
        TreeNode root = buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        printTree(root);
    }

    private static void testCase2() {
        TreeNode root = buildTree(new int[]{-1}, new int[]{-1});
        printTree(root);
    }

    private static void printTree(TreeNode node) {
        if (node == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode cur = queue.poll();
                size--;
                if (cur == null) {
                    continue;
                }
                System.out.print(cur.val + "\t");
                TreeNode left = cur.left;
                if (left != null) {
                    queue.offer(left);
                }
                TreeNode right = cur.right;
                if (right != null) {
                    queue.offer(right);
                }
            }
            System.out.println();
        }
    }

}
