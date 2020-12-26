package newcoder;

import Utils.TreeLinkNode;

/**
 * Link: https://www.nowcoder.com/practice/9023a0c988684a53960365b889ceaf5e?tpId=13&&tqId=11210&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * Status:
 * <p>
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 *
 * 解析：
 * 中序遍历通用代码：
 * fun search(root) {
 *     if (root == null) return;
 *     search(root.left);   // 1
 *     access(root);        // 2
 *     search(root.right);  // 3
 * }
 *
 * 观察可知，遍历到root节点后，紧跟着会执行语句3，向下递归。
 * 此时分两种情况：
 * 1. root.right != null: 指针到root.right，递归到下一层，然后在语句1一直向下递归到root.left == null，此时下一个节点即为root；
 * 2. root.right == null: 结束该层递归，回到上层，此时，上层的递归入口可能是语句1或语句3，分两种情况：
 *     2.1. 语句1：此时紧接着执行语句2，即为下一个节点，此时pNode.next.left == pNode；
 *     2.2. 语句3：此时语句3执行完毕，回到上层，回到第2种情况(循环定义).
 * 总结：
 * 1. pNode.right != null -> pNode = pNode.right，然后循环pNode = pNode.left，直到pNode.left == null，pNode即为结果;
 * 2. 第2种情况是一个循环，只需要判断pNode.next.left == pNode即可，如果pNode.next.left != pNode，执行pNode = pNode.next，直到满足条件，此时pNode即为结果;
 * 3. 1， 2都没得到结果，说明pNode为最后一个节点，他没有下一个节点了，所以返回空。
 */
public class TreeLinkNodeNext {

    public TreeLinkNode getNext(TreeLinkNode pNode) {
        if (pNode == null) return null;
        if (pNode.right != null) {
            pNode = pNode.right;
            while (pNode.left != null) {
                pNode = pNode.left;
            }
            return pNode;
        }
        while (pNode.next != null) {
            TreeLinkNode node = pNode.next;
            if (node.left == pNode) {
                return node;
            }
            pNode = pNode.next;
        }
        return null;
    }

    public static void main(String[] args) {
        TreeLinkNode tl1 = new TreeLinkNode(1);
        TreeLinkNode tl2 = new TreeLinkNode(2);
        TreeLinkNode tl3 = new TreeLinkNode(3);
        TreeLinkNode tl4 = new TreeLinkNode(4);
        TreeLinkNode tl5 = new TreeLinkNode(5);
        TreeLinkNode tl6 = new TreeLinkNode(6);
        TreeLinkNode tl7 = new TreeLinkNode(7);
        tl1.left = tl2;
        tl1.right = tl3;
        tl2.left = tl4;
        tl2.right = tl5;
        tl3.left = tl6;
        tl3.right = tl7;
        tl2.next = tl1;
        tl3.next = tl1;
        tl4.next = tl2;
        tl5.next = tl2;
        tl6.next = tl3;
        tl7.next = tl3;
        System.out.println(new TreeLinkNodeNext().getNext(tl4).val);
    }
}
