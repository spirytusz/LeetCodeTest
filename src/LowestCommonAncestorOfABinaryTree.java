import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/?envType=study-plan-v2&envId=top-100-liked">236. Lowest Common Ancestor of a Binary Tree</a>
 *
 * <p>Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.</p>
 *
 * <p>According to the <a href="https://en.wikipedia.org/wiki/Lowest_common_ancestor" target="_blank">definition of LCA on Wikipedia</a>: &ldquo;The lowest common ancestor is defined between two nodes <code>p</code> and <code>q</code> as the lowest node in <code>T</code> that has both <code>p</code> and <code>q</code> as descendants (where we allow <b>a node to be a descendant of itself</b>).&rdquo;</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2018/12/14/binarytree.png" style="width: 200px; height: 190px;" />
 * <pre>
 * <strong>Input:</strong> root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * <strong>Output:</strong> 3
 * <strong>Explanation:</strong> The LCA of nodes 5 and 1 is 3.
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2018/12/14/binarytree.png" style="width: 200px; height: 190px;" />
 * <pre>
 * <strong>Input:</strong> root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * <strong>Output:</strong> 5
 * <strong>Explanation:</strong> The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
 * </pre>
 *
 * <p><strong class="example">Example 3:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> root = [1,2], p = 1, q = 2
 * <strong>Output:</strong> 1
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li>The number of nodes in the tree is in the range <code>[2, 10<sup>5</sup>]</code>.</li>
 * 	<li><code>-10<sup>9</sup> &lt;= Node.val &lt;= 10<sup>9</sup></code></li>
 * 	<li>All <code>Node.val</code> are <strong>unique</strong>.</li>
 * 	<li><code>p != q</code></li>
 * 	<li><code>p</code> and <code>q</code> will exist in the tree.</li>
 * </ul>
 */
public class LowestCommonAncestorOfABinaryTree {


    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }


    @SuppressWarnings("ClassEscapesDefinedScope")
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return bestSolution(root, p, q);
    }

    private static TreeNode mySolution(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> path = new HashMap<>();
        buildPath(root, path);

        List<TreeNode> pPath = new ArrayList<>();
        List<TreeNode> qPath = new ArrayList<>();

        while (p != null) {
            pPath.add(p);
            p = path.get(p);
        }
        while (q != null) {
            qPath.add(q);
            q = path.get(q);
        }

        TreeNode ret = null;

        for (int i = 0; i < Math.min(pPath.size(), qPath.size()); i++) {
            TreeNode tPNode = pPath.get(pPath.size() - 1 - i);
            TreeNode tQNode = qPath.get(qPath.size() - 1 - i);

            if (tPNode != tQNode) {
                break;
            }

            ret = tPNode;
        }
        return ret;
    }

    private static void buildPath(TreeNode root, Map<TreeNode, TreeNode> path) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            path.put(root.left, root);
        }
        if (root.right != null) {
            path.put(root.right, root);
        }
        buildPath(root.left, path);
        buildPath(root.right, path);
    }

    private static TreeNode bestSolution(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = bestSolution(root.left, p, q);
        TreeNode right = bestSolution(root.right, p, q);

        if (left != null && right != null) {
            return root;
        } else {
            return left != null ? left : right;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        System.out.println(lowestCommonAncestor(root, root.left, root.right).val);
        System.out.println(lowestCommonAncestor(root, root.left, root.left.right.right).val);
    }
}
