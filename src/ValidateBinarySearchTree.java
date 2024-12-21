import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/validate-binary-search-tree/description/">98. Validate Binary Search Tree</a>
 *
 * <div class="elfjS" data-track-load="description_content"><p>Given the <code>root</code> of a binary tree, <em>determine if it is a valid binary search tree (BST)</em>.</p>
 *
 * <p>A <strong>valid BST</strong> is defined as follows:</p>
 *
 * <ul>
 * 	<li>The left <span data-keyword="subtree" class=" cursor-pointer relative text-dark-blue-s text-sm"><div class="popover-wrapper inline-block" data-headlessui-state=""><div><div aria-expanded="false" data-headlessui-state="" id="headlessui-popover-button-:rt:"><div>subtree</div></div><div style="position: fixed; z-index: 40; inset: 0px auto auto 0px; transform: translate(120px, 257px);"></div></div></div></span> of a node contains only nodes with keys <strong>less than</strong> the node's key.</li>
 * 	<li>The right subtree of a node contains only nodes with keys <strong>greater than</strong> the node's key.</li>
 * 	<li>Both the left and right subtrees must also be binary search trees.</li>
 * </ul>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/12/01/tree1.jpg" style="width: 302px; height: 182px;">
 * <pre><strong>Input:</strong> root = [2,1,3]
 * <strong>Output:</strong> true
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/12/01/tree2.jpg" style="width: 422px; height: 292px;">
 * <pre><strong>Input:</strong> root = [5,1,4,null,null,3,6]
 * <strong>Output:</strong> false
 * <strong>Explanation:</strong> The root node's value is 5 but its right child's value is 4.
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li>The number of nodes in the tree is in the range <code>[1, 10<sup>4</sup>]</code>.</li>
 * 	<li><code>-2<sup>31</sup> &lt;= Node.val &lt;= 2<sup>31</sup> - 1</code></li>
 * </ul>
 * </div>
 */
public class ValidateBinarySearchTree {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static boolean isValidBST(TreeNode root) {
        return isValidBSTIterativeImpl(root);
    }

    private static boolean isValidBSTRecursionImpl(TreeNode node, Integer minValue, Integer maxValue) {
        if (node == null) {
            return true;
        }
        if (minValue != null && node.val <= minValue) {
            return false;
        }
        if (maxValue != null && node.val >= maxValue) {
            return false;
        }
        return isValidBSTRecursionImpl(node.left, minValue, node.val) && isValidBSTRecursionImpl(node.right, node.val, maxValue);
    }

    private static boolean isValidBSTIterativeImpl(TreeNode root) {
        if (root == null) {
            return false;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pre != null && pre.val >= root.val) {
                return false;
            }
            pre = root;
            root = root.right;
        }
        return true;
    }

    private static void testCase1() {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(isValidBST(root));
    }

    private static void testCase2() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);
        System.out.println(isValidBST(root));
    }

    private static void testCase3() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(6);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(7);
        System.out.println(isValidBST(root));
    }

    public static void main(String[] args) {
        testCase1();
        testCase2();
        testCase3();
    }
}
