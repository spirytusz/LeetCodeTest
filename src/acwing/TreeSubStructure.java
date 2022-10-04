package acwing;

/**
 * <a href="https://www.acwing.com/problem/content/35/">37. 树的子结构</a>
 */
@SuppressWarnings("DuplicatedCode")
public class TreeSubStructure {
    public boolean hasSubtree(TreeNode pRoot1, TreeNode pRoot2) {
        if (pRoot1 == pRoot2) {
            return true;
        }
        if (pRoot1 == null || pRoot2 == null) {
            return false;
        }

        if (pRoot1.val == pRoot2.val && match(pRoot1, pRoot2)) {
            return true;
        } else {
            return hasSubtree(pRoot1.left, pRoot2) || hasSubtree(pRoot1.right, pRoot2);
        }
    }

    private boolean match(TreeNode node1, TreeNode node2) {
        if (node1 == node2 || node2 == null) {
            return true;
        }
        if (node1 == null) {
            return false;
        }
        return node1.val == node2.val && match(node1.left, node2.left) && match(node1.right, node2.right);
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode n81 = new TreeNode(8);
        TreeNode n82 = new TreeNode(8);
        TreeNode n71 = new TreeNode(7);
        TreeNode n9 = new TreeNode(9);
        TreeNode n2 = new TreeNode(2);
        TreeNode n4 = new TreeNode(4);
        TreeNode n72 = new TreeNode(7);

        n81.left = n82;
        n81.right = n71;
        n82.left = n9;
        n82.right = n2;
        n2.left = n4;
        n2.right = n72;

        TreeNode n83 = new TreeNode(8);
        TreeNode n92 = new TreeNode(9);
        TreeNode n22 = new TreeNode(2);
        n83.left = n92;
        n83.right = n22;

        System.out.println(new TreeSubStructure().hasSubtree(n81, n83));
    }
}
