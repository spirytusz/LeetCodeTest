
/**
 * <a href="https://leetcode.com/problems/path-sum/description/">112. Path Sum</a>
 * 
 * <p>Given the <code>root</code> of a binary tree and an integer <code>targetSum</code>, return <code>true</code> if the tree has a <strong>root-to-leaf</strong> path such that adding up all the values along the path equals <code>targetSum</code>.</p>
 * 
 * <p>A <strong>leaf</strong> is a node with no children.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/01/18/pathsum1.jpg" style="width: 500px; height: 356px;" />
 * <pre>
 * <strong>Input:</strong> root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
 * <strong>Output:</strong> true
 * <strong>Explanation:</strong> The root-to-leaf path with the target sum is shown.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/01/18/pathsum2.jpg" />
 * <pre>
 * <strong>Input:</strong> root = [1,2,3], targetSum = 5
 * <strong>Output:</strong> false
 * <strong>Explanation:</strong> There are two root-to-leaf paths in the tree:
 * (1 --&gt; 2): The sum is 3.
 * (1 --&gt; 3): The sum is 4.
 * There is no root-to-leaf path with sum = 5.
 * </pre>
 * 
 * <p><strong class="example">Example 3:</strong></p>
 * 
 * <pre>
 * <strong>Input:</strong> root = [], targetSum = 0
 * <strong>Output:</strong> false
 * <strong>Explanation:</strong> Since the tree is empty, there are no root-to-leaf paths.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li>The number of nodes in the tree is in the range <code>[0, 5000]</code>.</li>
 * 	<li><code>-1000 &lt;= Node.val &lt;= 1000</code></li>
 * 	<li><code>-1000 &lt;= targetSum &lt;= 1000</code></li>
 * </ul>

 */
public class PathSum {


    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }


    @SuppressWarnings("ClassEscapesDefinedScope")
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && targetSum - root.val == 0) {
            return true;
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

    public static void main(String[] args) {
        testCase1();
        testCase2();
    }

    private static void testCase1() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        System.out.println(hasPathSum(root, 22));
    }

    private static void testCase2() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        System.out.println(hasPathSum(root, 5));
    }
}
