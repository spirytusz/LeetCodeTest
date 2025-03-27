import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/binary-tree-maximum-path-sum/description">124. Binary Tree Maximum Path Sum</a>
 *
 * <div class="elfjS" data-track-load="description_content"><p>A <strong>path</strong> in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence <strong>at most once</strong>. Note that the path does not need to pass through the root.</p>
 *
 * <p>The <strong>path sum</strong> of a path is the sum of the node's values in the path.</p>
 *
 * <p>Given the <code>root</code> of a binary tree, return <em>the maximum <strong>path sum</strong> of any <strong>non-empty</strong> path</em>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/10/13/exx1.jpg" style="width: 322px; height: 182px;">
 * <pre><strong>Input:</strong> root = [1,2,3]
 * <strong>Output:</strong> 6
 * <strong>Explanation:</strong> The optimal path is 2 -&gt; 1 -&gt; 3 with a path sum of 2 + 1 + 3 = 6.
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/10/13/exx2.jpg">
 * <pre><strong>Input:</strong> root = [-10,9,20,null,null,15,7]
 * <strong>Output:</strong> 42
 * <strong>Explanation:</strong> The optimal path is 15 -&gt; 20 -&gt; 7 with a path sum of 15 + 20 + 7 = 42.
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li>The number of nodes in the tree is in the range <code>[1, 3 * 10<sup>4</sup>]</code>.</li>
 * 	<li><code>-1000 &lt;= Node.val &lt;= 1000</code></li>
 * </ul>
 * </div>
 */
public class BinaryTreeMaximumPathSum {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static int maxPathSum(TreeNode root) {
        int[] result = new int[]{Integer.MIN_VALUE};
        mySolution(root, result);
        return result[0];
    }

    private static int mySolution(TreeNode node, int[] result) {
        if (node == null) {
            return 0;
        }
        int value = node.val;
        int left = Math.max(mySolution(node.left, result), 0);
        int right = Math.max(mySolution(node.right, result), 0);
        result[0] = Math.max(result[0], value + left + right);
        return value + Math.max(left, right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(maxPathSum(root));
    }
}
