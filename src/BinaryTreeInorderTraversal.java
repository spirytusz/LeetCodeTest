import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/binary-tree-inorder-traversal/description/">94. Binary Tree Inorder Traversal</a>
 * <p>Status: <b>AC</b></p>
 *
 * <div class="elfjS" data-track-load="description_content"><p>Given the <code>root</code> of a binary tree, return <em>the inorder traversal of its nodes' values</em>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <div class="example-block">
 * <p><strong>Input:</strong> <span class="example-io">root = [1,null,2,3]</span></p>
 *
 * <p><strong>Output:</strong> <span class="example-io">[1,3,2]</span></p>
 *
 * <p><strong>Explanation:</strong></p>
 *
 * <p><img alt="" src="https://assets.leetcode.com/uploads/2024/08/29/screenshot-2024-08-29-202743.png" style="width: 200px; height: 264px;"></p>
 * </div>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <div class="example-block">
 * <p><strong>Input:</strong> <span class="example-io">root = [1,2,3,4,5,null,8,null,null,6,7,9]</span></p>
 *
 * <p><strong>Output:</strong> <span class="example-io">[4,2,6,5,7,1,3,9,8]</span></p>
 *
 * <p><strong>Explanation:</strong></p>
 *
 * <p><img alt="" src="https://assets.leetcode.com/uploads/2024/08/29/tree_2.png" style="width: 350px; height: 286px;"></p>
 * </div>
 *
 * <p><strong class="example">Example 3:</strong></p>
 *
 * <div class="example-block">
 * <p><strong>Input:</strong> <span class="example-io">root = []</span></p>
 *
 * <p><strong>Output:</strong> <span class="example-io">[]</span></p>
 * </div>
 *
 * <p><strong class="example">Example 4:</strong></p>
 *
 * <div class="example-block">
 * <p><strong>Input:</strong> <span class="example-io">root = [1]</span></p>
 *
 * <p><strong>Output:</strong> <span class="example-io">[1]</span></p>
 * </div>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li>The number of nodes in the tree is in the range <code>[0, 100]</code>.</li>
 * 	<li><code>-100 &lt;= Node.val &lt;= 100</code></li>
 * </ul>
 *
 * <p>&nbsp;</p>
 * <strong>Follow up:</strong> Recursive solution is trivial, could you do it iteratively?</div>
 */
public class BinaryTreeInorderTraversal {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root != null) {
            inorderTraversalStackImpl(root, result);
        }
        return result;
    }

    private static void inorderTraversalRecursionImpl(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        inorderTraversalRecursionImpl(node.left, result);
        result.add(node.val);
        inorderTraversalRecursionImpl(node.right, result);
    }

    private static void inorderTraversalStackImpl(TreeNode node, List<Integer> result) {
        final Stack<TreeNode> stack = new Stack<>();
        TreeNode current = node;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            TreeNode visit = stack.pop();
            result.add(visit.val);
            current = visit.right;
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node5.left = node6;
        node5.right = node7;
        node3.right = node8;
        node8.right = node9;

        System.out.println(inorderTraversal(node1));
    }
}
