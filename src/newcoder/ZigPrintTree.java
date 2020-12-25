package newcoder;

/**
 * Link: https://www.nowcoder.com/practice/91b69814117f4e8097390d107d2efbe0?tpId=13&&tqId=11212&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * Status: AC
 * <p>
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 *
 * 解析：
 * 此题需要用到bfs，可以利用队列先进先出的特点，先入root，然后入root.left，再入root.right
 * 伪代码如下：
 * function bfs(root) {
 *     if (root == null) return;
 *     queue.enqueue(root);
 *     int head = 0;
 *     int end = queue.size;
 *     while (head != end) { // 队列不为空时
 *         accessNode = queue[head++];
 *         access(accessNode); // 读取node
 *         if (accessNode.left != null) {
 *             queue[end++] = accessNode.left;
 *         }
 *         if (accessNode.right != null) {
 *             queue[end++] = accessNode.right;
 *         }
 *     }
 * }
 *
 * 可以看出，在while循环中：
 * 1. 每次都会向下遍历一层，所以每个while循环的遍历层级 level + 1
 * 2. 循环开始时，当前层的节点数 = end - head
 *
 * 据1，2，可有以下思路
 * 1. 循环开始时，记录end - head 的值size
 * 2. 每次循环结束，level++
 * 3. 根据size，一直向下读队列，读到size = 0为止，此时读到的数据为当前层的所有节点
 * 4. 如果level % 2 ！= 0，翻转3的结果
 * 5. 将4的结果加入到结果集合
 */

import Utils.TreeNode;

import java.util.ArrayList;

public class ZigPrintTree {

    public ArrayList<ArrayList<Integer>> printZig(TreeNode pRoot) {
        if (pRoot == null) return new ArrayList<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<TreeNode> queue = new ArrayList<>();
        int head = 0;
        int end = 0;
        int level = 0;
        queue.add(pRoot);
        end++;
        while (head != end) {
            ArrayList<Integer> item = new ArrayList<>();
            int size = end - head;
            while (size > 0) {
                TreeNode node = queue.get(head);
                head++;
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
            if (level % 2 != 0) {
                for (int i = 0; i < item.size() / 2; i++) {
                    int temp = item.get(i);
                    item.set(i, item.get(item.size() - 1 - i));
                    item.set(item.size() - 1 - i, temp);
                }
            }
            result.add(item);
            level++;
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
        System.out.println(new ZigPrintTree().printZig(t1));
    }
}
