
/**
 * <a href="https://leetcode.com/problems/rotate-list/description/">61. Rotate List</a>
 *
 * <p>Given the <code>head</code> of a linked&nbsp;list, rotate the list to the right by <code>k</code> places.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/11/13/rotate1.jpg" style="width: 450px; height: 191px;" />
 * <pre>
 * <strong>Input:</strong> head = [1,2,3,4,5], k = 2
 * <strong>Output:</strong> [4,5,1,2,3]
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/11/13/roate2.jpg" style="width: 305px; height: 350px;" />
 * <pre>
 * <strong>Input:</strong> head = [0,1,2], k = 4
 * <strong>Output:</strong> [2,0,1]
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li>The number of nodes in the list is in the range <code>[0, 500]</code>.</li>
 * 	<li><code>-100 &lt;= Node.val &lt;= 100</code></li>
 * 	<li><code>0 &lt;= k &lt;= 2 * 10<sup>9</sup></code></li>
 * </ul>
 */
public class RotateList {


    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    @SuppressWarnings("ClassEscapesDefinedScope")
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        ListNode lastKNode = findLastK(head, k);
        if (head == lastKNode) {
            return head;
        }
        ListNode cur = head;
        while (cur.next != lastKNode) {
            cur = cur.next;
        }
        cur.next = null;
        cur = lastKNode;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = head;
        return lastKNode;
    }

    private static ListNode findLastK(ListNode head, int k) {
        int length = 0;
        ListNode cur = head;
        while (cur != null) {
            length++;
            cur = cur.next;
        }

        k = k % length;
        if (k == 0) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (k > 0) {
            fast = fast.next;
            k--;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        testCase1();
        testCase2();
        testCase3();
    }

    private static void testCase1() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        printList(rotateRight(head, 2));
    }

    private static void testCase2() {
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        printList(rotateRight(head, 4));
    }

    private static void testCase3() {
        ListNode head = new ListNode(1);
        printList(rotateRight(head, 1));
    }

    private static void printList(ListNode root) {
        while (root != null) {
            System.out.print(root.val + (root.next != null ? "->" : ""));
            root = root.next;
        }
        System.out.println();
    }
}
