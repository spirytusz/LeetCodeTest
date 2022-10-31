import java.util.HashMap;
import java.util.Map;

/**
 * @see <a href="https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/">106. Construct Binary Tree from Inorder and Postorder Traversal</a>
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postorderStart = postorder.length - 1;
        return buildTreeInternal(buildIndexed(inorder), postorder, 0, inorder.length - 1);
    }

    private int postorderStart = 0;

    private TreeNode buildTreeInternal(Map<Integer, Integer> inorderIndexed, int[] postorder, int left, int right) {
        if (left > right || postorderStart < 0) {
            return null;
        }
        TreeNode root = new TreeNode();
        root.val = postorder[postorderStart--];
        int splitPos = inorderIndexed.get(root.val);
        root.right = buildTreeInternal(inorderIndexed, postorder, splitPos + 1, right);
        root.left = buildTreeInternal(inorderIndexed, postorder, left, splitPos - 1);
        return root;
    }

    private Map<Integer, Integer> buildIndexed(int[] array) {
        Map<Integer, Integer> indexed = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            indexed.put(array[i], i);
        }
        return indexed;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
