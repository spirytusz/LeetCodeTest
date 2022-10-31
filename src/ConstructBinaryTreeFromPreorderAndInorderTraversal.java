import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @see <a href="https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/">105. Construct Binary Tree from Preorder and Inorder Traversal</a>
 * @see <a href="https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/solution/">Solution</a>
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeInternal(preorder, buildIndexed(inorder), 0, inorder.length - 1);
    }

    private int preorderStart = 0;

    private TreeNode buildTreeInternal(int[] preorder, Map<Integer, Integer> indexedInorder, int left, int right) {
        if (left > right || preorderStart >= preorder.length) {
            return null;
        }

        TreeNode root = new TreeNode();
        root.val = preorder[preorderStart++];
        int splitPosition = indexedInorder.get(root.val);
        root.left = buildTreeInternal(preorder, indexedInorder, left, splitPosition - 1);
        root.right = buildTreeInternal(preorder, indexedInorder, splitPosition + 1, right);
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

    public static void main(String[] args) {
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        TreeNode root = new ConstructBinaryTreeFromPreorderAndInorderTraversal().buildTree(preorder, inorder);
    }
}
