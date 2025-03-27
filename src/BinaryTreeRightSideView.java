import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/binary-tree-right-side-view/description/">199. Binary Tree Right Side View</a>
 *
 * <div class="elfjS" data-track-load="description_content"><p>Given the <code>root</code> of a binary tree, imagine yourself standing on the <strong>right side</strong> of it, return <em>the values of the nodes you can see ordered from top to bottom</em>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <div class="example-block">
 * <p><strong>Input:</strong> <span class="example-io">root = [1,2,3,null,5,null,4]</span></p>
 *
 * <p><strong>Output:</strong> <span class="example-io">[1,3,4]</span></p>
 *
 * <p><strong>Explanation:</strong></p>
 *
 * <p><img alt="" src="https://assets.leetcode.com/uploads/2024/11/24/tmpd5jn43fs-1.png" style="width: 400px; height: 207px;"></p>
 * </div>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <div class="example-block">
 * <p><strong>Input:</strong> <span class="example-io">root = [1,2,3,4,null,null,null,5]</span></p>
 *
 * <p><strong>Output:</strong> <span class="example-io">[1,3,4,5]</span></p>
 *
 * <p><strong>Explanation:</strong></p>
 *
 * <p><img alt="" src="https://assets.leetcode.com/uploads/2024/11/24/tmpkpe40xeh-1.png" style="width: 400px; height: 214px;"></p>
 * </div>
 *
 * <p><strong class="example">Example 3:</strong></p>
 *
 * <div class="example-block">
 * <p><strong>Input:</strong> <span class="example-io">root = [1,null,3]</span></p>
 *
 * <p><strong>Output:</strong> <span class="example-io">[1,3]</span></p>
 * </div>
 *
 * <p><strong class="example">Example 4:</strong></p>
 *
 * <div class="example-block">
 * <p><strong>Input:</strong> <span class="example-io">root = []</span></p>
 *
 * <p><strong>Output:</strong> <span class="example-io">[]</span></p>
 * </div>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li>The number of nodes in the tree is in the range <code>[0, 100]</code>.</li>
 * 	<li><code>-100 &lt;= Node.val &lt;= 100</code></li>
 * </ul>
 * </div>
 */
public class BinaryTreeRightSideView {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    @SuppressWarnings({"ClassEscapesDefinedScope", "DataFlowIssue"})
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                if (size == 0) {
                    result.add(node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        testCase1();
        testCase2();
        testCase3();
    }

    private static void testCase1() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);
        System.out.println(rightSideView(root));
    }

    private static void testCase2() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(5);
        System.out.println(rightSideView(root));
    }

    private static void testCase3() {
        System.out.println(rightSideView(null));
    }
}
