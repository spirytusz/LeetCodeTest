package acwing;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://www.acwing.com/problem/content/84/">88. 树中两个结点的最低公共祖先</a>
 * <a href="https://www.acwing.com/solution/content/758/">题解</a>
 */
@SuppressWarnings("DuplicatedCode")
public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pathP = new ArrayList<>();
        List<TreeNode> pathQ = new ArrayList<>();
        buildPath(root, p, pathP);
        buildPath(root, q, pathQ);

        if (pathP.isEmpty() || pathQ.isEmpty()) {
            return null;
        }
        TreeNode ret = null;
        int x = 0;
        while (pathP.size() - 1 - x >= 0 && pathQ.size() - 1 - x >= 0 && pathP.get(pathP.size() - 1 - x) == pathQ.get(pathQ.size() - 1 - x)) {
            ret = pathP.get(pathP.size() - 1 - x);
            x++;
        }
        return ret;
    }

    private boolean buildPath(TreeNode root, TreeNode target, List<TreeNode> path) {
        if (root == null) {
            return false;
        }
        if (target == root) {
            path.add(root);
            return true;
        }
        if (buildPath(root.left, target, path)) {
            path.add(root);
            return true;
        }
        if (buildPath(root.right, target, path)) {
            path.add(root);
            return true;
        }
        return false;
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
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;

        System.out.println(new LowestCommonAncestor().lowestCommonAncestor(n1, n7, n3).val);
    }
}
