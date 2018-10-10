/**
 * Link: https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * <p>
 * Given a linked list, remove the n-th node from the end of list and return its head.
 * <p>
 * Example:
 * <p>
 * Given linked list: 1->2->3->4->5, and n = 2.
 * <p>
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 * <p>
 * Given n will always be valid.
 * <p>
 * Follow up:
 * <p>
 * Could you do this in one pass?
 */
public class RemoveNthNodeFromEndOfList {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode removeNthFromEnd(ListNode node, int n) {
        ListNode p = node;
        ListNode q = node;
        ListNode bp = null;
        while(q != null) {
            q = q.next;
            if((n <= 0)){
                bp = p;
                p = p.next;
            }
            n--;
        }
        if(bp == null) {
            node = node.next;
        } else {
            bp.next = p.next;
        }
        return node;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root = removeNthFromEnd(root, 3);
        while (root != null) {
            System.out.print(root.val + "\t");
            root = root.next;
        }
    }
}
