
/**
 * <a href="https://leetcode.com/problems/minimum-depth-of-binary-tree/description/">111. Minimum Depth of Binary Tree</a>
 * 
 * <p>Given a binary tree, find its minimum depth.</p>
 * 
 * <p>The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.</p>
 * 
 * <p><strong>Note:</strong>&nbsp;A leaf is a node with no children.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/10/12/ex_depth.jpg" style="width: 432px; height: 302px;" />
 * <pre>
 * <strong>Input:</strong> root = [3,9,20,null,null,15,7]
 * <strong>Output:</strong> 2
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre>
 * <strong>Input:</strong> root = [2,null,3,null,4,null,5,null,6]
 * <strong>Output:</strong> 5
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li>The number of nodes in the tree is in the range <code>[0, 10<sup>5</sup>]</code>.</li>
 * 	<li><code>-1000 &lt;= Node.val &lt;= 1000</code></li>
 * </ul>

 */
public class MinimumDepthOfBinaryTree {


    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }


    @SuppressWarnings("ClassEscapesDefinedScope")
    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = minDepth(root.left), right = minDepth(root.right);
        return 1 + (Math.min(left, right) > 0 ? Math.min(left, right) : Math.max(left, right));
    }

    public static void main(String[] args) {
        testCase1();
        testCase2();
    }
    
    private static void testCase1() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(minDepth(root));
    }

    private static void testCase2() {
        TreeNode root = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(5);
        root.right.right.right.right = new TreeNode(6);

        System.out.println(minDepth(root));
    }
}
