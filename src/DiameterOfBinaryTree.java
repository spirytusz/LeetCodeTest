/**
 * <a href="https://leetcode.com/problems/diameter-of-binary-tree/">543. Diameter of Binary Tree</a>
 *
 * <div class="elfjS" data-track-load="description_content"><p>Given the <code>root</code> of a binary tree, return <em>the length of the <strong>diameter</strong> of the tree</em>.</p>
 *
 * <p>The <strong>diameter</strong> of a binary tree is the <strong>length</strong> of the longest path between any two nodes in a tree. This path may or may not pass through the <code>root</code>.</p>
 *
 * <p>The <strong>length</strong> of a path between two nodes is represented by the number of edges between them.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/03/06/diamtree.jpg" style="width: 292px; height: 302px;">
 * <pre><strong>Input:</strong> root = [1,2,3,4,5]
 * <strong>Output:</strong> 3
 * <strong>Explanation:</strong> 3 is the length of the path [4,2,1,3] or [5,2,1,3].
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre><strong>Input:</strong> root = [1,2]
 * <strong>Output:</strong> 1
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li>The number of nodes in the tree is in the range <code>[1, 10<sup>4</sup>]</code>.</li>
 * 	<li><code>-100 &lt;= Node.val &lt;= 100</code></li>
 * </ul>
 * </div>
 */
public class DiameterOfBinaryTree {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = new int[1];
        diameterOfBinaryTreeImpl(root, diameter);
        return diameter[0];
    }

    private static int mySolution(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int curMax = maxDepth(root.left) + maxDepth(root.right);
        int leftMax = diameterOfBinaryTree(root.left);
        int rightMax = diameterOfBinaryTree(root.right);
        return Math.max(curMax, Math.max(leftMax, rightMax));
    }

    private static int diameterOfBinaryTreeImpl(TreeNode root, int[] diameter) {
        if (root == null) {
            return 0;
        }
        int left = diameterOfBinaryTreeImpl(root.left, diameter);
        int right = diameterOfBinaryTreeImpl(root.right, diameter);
        diameter[0] = Math.max(diameter[0], left + right);
        return Math.max(left, right) + 1;
    }

    private static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println(diameterOfBinaryTree(root));
    }
}
