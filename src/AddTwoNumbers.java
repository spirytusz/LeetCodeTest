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
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode head = new ListNode(0);
        addTwoNumbersImpl(head, l1, l2, 0);
        return head.next;
    }

    private static void addTwoNumbersImpl(ListNode current, ListNode l1, ListNode l2, int shift) {
        if (l1 == null && l2 == null) {
            if (shift > 0) {
                current.next = new ListNode(shift);
            }
            return;
        }
        int resultDigit = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + shift;
        current.next = new ListNode(resultDigit % 10);
        addTwoNumbersImpl(current.next, l1 != null ? l1.next : null, l2 != null ? l2.next : null, resultDigit / 10);
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(5);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode node = addTwoNumbers(l1, l2);
        while (node != null) {
            System.out.print(node.val);
            node = node.next;
        }
    }
}
