package acwing;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://www.acwing.com/problem/content/45/">47. 二叉树中和为某一值的路径</a>
 */
public class BinaryTreeFindPath {
    public List<List<Integer>> findPath(TreeNode root, int sum) {
        List<List<Integer>> ret = new ArrayList<>();
        findPathInternal(root, sum, new ArrayList<>(), ret);
        return ret;
    }

    private void findPathInternal(TreeNode root, int sum, List<Integer> temp, List<List<Integer>> ret) {
        if (root == null || sum < 0) {
            return;
        }

        int remain = sum - root.val;
        temp.add(root.val);
        if (root.left == null && root.right == null && remain == 0) {
            List<Integer> item = new ArrayList<>(temp);
            ret.add(item);
        } else {
            findPathInternal(root.left, remain, temp, ret);
            findPathInternal(root.right, remain, temp, ret);
        }
        temp.remove(temp.size() - 1);
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
        TreeNode n51 = new TreeNode(5);
        TreeNode n4 = new TreeNode(4);
        TreeNode n61 = new TreeNode(6);
        TreeNode n12 = new TreeNode(12);
        TreeNode n13 = new TreeNode(13);
        TreeNode n62 = new TreeNode(6);
        TreeNode n9 = new TreeNode(9);
        TreeNode n111 = new TreeNode(1);
        TreeNode n52 = new TreeNode(5);
        TreeNode n112 = new TreeNode(1);

        //       5
        //      / \
        //     4   6
        //    /   / \
        //   12  13  6
        //  /  \    / \
        // 9    1  5   1
        n51.left = n4;
        n51.right = n61;
        n4.left = n12;
        n61.left = n13;
        n61.right = n62;
        n12.left = n9;
        n12.right = n111;
        n62.left = n52;
        n62.right = n112;

        System.out.println(new BinaryTreeFindPath().findPath(n51, 22));
    }
}
