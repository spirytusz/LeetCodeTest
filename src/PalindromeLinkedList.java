
/**
 * <a href="https://leetcode.com/problems/palindrome-linked-list/description/?envType=study-plan-v2&envId=top-100-liked">234. Palindrome Linked List</a>
 *
 * <p>Given the <code>head</code> of a singly linked list, return <code>true</code><em> if it is a </em><span data-keyword="palindrome-sequence"><em>palindrome</em></span><em> or </em><code>false</code><em> otherwise</em>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/03/03/pal1linked-list.jpg" style="width: 422px; height: 62px;" />
 * <pre>
 * <strong>Input:</strong> head = [1,2,2,1]
 * <strong>Output:</strong> true
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/03/03/pal2linked-list.jpg" style="width: 182px; height: 62px;" />
 * <pre>
 * <strong>Input:</strong> head = [1,2]
 * <strong>Output:</strong> false
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li>The number of nodes in the list is in the range <code>[1, 10<sup>5</sup>]</code>.</li>
 * 	<li><code>0 &lt;= Node.val &lt;= 9</code></li>
 * </ul>
 *
 * <p>&nbsp;</p>
 * <strong>Follow up:</strong> Could you do it in <code>O(n)</code> time and <code>O(1)</code> space?
 */
public class PalindromeLinkedList {


    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    @SuppressWarnings("ClassEscapesDefinedScope")
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode reverseRight = reverseLinkedList(slow.next);
        slow.next = null;

        while (reverseRight != null) {
            if (head.val != reverseRight.val) {
                return false;
            }
            head = head.next;
            reverseRight = reverseRight.next;
        }
        return true;
    }

    private static ListNode reverseLinkedList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = reverseLinkedList(head.next);
        head.next.next = head;
        head.next = null;
        return next;
    }

    public static void main(String[] args) {
        testCase1();
        testCase2();
    }

    private static void testCase1() {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(2);
        node.next.next.next = new ListNode(1);

        System.out.println(isPalindrome(node));
    }

    private static void testCase2() {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);

        System.out.println(isPalindrome(node));
    }
}
