/**
 * Link: https://leetcode.com/problems/merge-two-sorted-lists/
 *
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 *
 * Example:
 *
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 */
public class MergeTwoSortedLists {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        ListNode head = node;
        while (l1 != null || l2 != null) {
            if(l1 != null && l2 != null) {
                if(l1.val <= l2.val) {
                    node.next = l1;
                    l1 = l1.next;
                } else {
                    node.next = l2;
                    l2 = l2.next;
                }
            } else if(l1 != null) {
                node.next = l1;
                l1 = l1.next;
            } else {
                node.next = l2;
                l2 = l2.next;
            }
            node = node.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        ListNode root = mergeTwoLists(l1, l2);
        printList(root);
    }

    private static void printList(ListNode l) {
        while(l != null) {
            System.out.print(l.val+"\t");
            l = l.next;
        }
        System.out.println();
    }
}