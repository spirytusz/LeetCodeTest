package newcoder;

/**
 * Link: https://www.nowcoder.com/practice/445c44d982d04483b04a54f298796288?tpId=13&tqId=11212&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * Status: AC
 * <p>
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */

import Utils.TreeNode;

import java.util.ArrayList;

public class BinaryTreeBFS {
    ArrayList<ArrayList<Integer>> print(TreeNode pRoot) {
        if (pRoot == null) return new ArrayList<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<TreeNode> queue = new ArrayList<>();
        int head = 0;
        int end = 0;
        queue.add(pRoot);
        end++;
        while (head != end) {
            ArrayList<Integer> item = new ArrayList<>();
            int size = end - head;
            while (size > 0) {
                TreeNode node = queue.get(head++);
                item.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                    end++;
                }
                if (node.right != null) {
                    queue.add(node.right);
                    end++;
                }
                size--;
            }
            result.add(item);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(8);
        TreeNode t9 = new TreeNode(9);
        TreeNode t10 = new TreeNode(10);
        TreeNode t11 = new TreeNode(11);
        TreeNode t12 = new TreeNode(12);
        TreeNode t13 = new TreeNode(13);
        TreeNode t14 = new TreeNode(14);
        TreeNode t15 = new TreeNode(15);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        t4.left = t8;
        t4.right = t9;
        t5.left = t10;
        t5.right = t11;
        t6.left = t12;
        t6.right = t13;
        t7.left = t14;
        t7.right = t15;
        System.out.println(new BinaryTreeBFS().print(t1));
    }
}
