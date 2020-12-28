package newcoder;

/**
 * Link: https://www.nowcoder.com/practice/b736e784e3e34731af99065031301bca?tpId=13&&tqId=11177&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * Status: AC
 * <p>
 * 输入一颗二叉树的根节点和一个整数，按字典序打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */

import Utils.TreeNode;

import java.util.ArrayList;

public class FindPathSum {

    public ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        findPathInternal(root, new ArrayList<>(), result, target);
        return result;
    }

    private void findPathInternal(TreeNode root, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> result, int target) {
        path.add(root.val);
        if (root.val == target && root.left == null && root.right == null) {
            result.add(new ArrayList<>(path));
        }
        if (root.left != null) {
            findPathInternal(root.left, path, result, target - root.val);
        }
        if (root.right != null) {
            findPathInternal(root.right, path, result, target - root.val);
        }
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(10);
        TreeNode t2 = new TreeNode(5);
        TreeNode t3 = new TreeNode(12);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(7);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        System.out.println(new FindPathSum().findPath(t1, 15));
    }
}
