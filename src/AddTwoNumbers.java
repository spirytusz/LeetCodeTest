/**
 * Link: https://leetcode.com/problems/add-two-numbers/
 * Status: AC
 *
 * <p>
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example:
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbers {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = null;
        ListNode pointer = null;
        int overBit = 0;
        while (l1 != null || l2 != null) {
            int val1;
            int val2;
            if (l1 == null) {
                val1 = 0;
            } else {
                val1 = l1.val;
                l1 = l1.next;
            }
            if (l2 == null) {
                val2 = 0;
            } else {
                val2 = l2.val;
                l2 = l2.next;
            }
            int bit = val1 + val2 + overBit;
            if (bit >= 10) {
                bit %= 10;
                overBit = 1;
            } else {
                overBit = 0;
            }
            ListNode node = new ListNode(bit);
            if(root == null) {
                root = node;
                pointer = node;
            } else {
                pointer.next = node;
                pointer = pointer.next;
            }
        }
        if(overBit != 0) {
            ListNode node = new ListNode(overBit);
            pointer.next = node;
        }
        return root;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(5);
        /*l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);*/
        ListNode node = addTwoNumbers(l1, l2);
        while(node != null) {
            System.out.print(node.val);
            node = node.next;
        }
    }
}
