
/**
 * <a href="https://leetcode.com/problems/linked-list-cycle/?envType=study-plan-v2&envId=top-100-liked">141. Linked List Cycle</a>
 * 
 * <p>Given <code>head</code>, the head of a linked list, determine if the linked list has a cycle in it.</p>
 * 
 * <p>There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the&nbsp;<code>next</code>&nbsp;pointer. Internally, <code>pos</code>&nbsp;is used to denote the index of the node that&nbsp;tail&#39;s&nbsp;<code>next</code>&nbsp;pointer is connected to.&nbsp;<strong>Note that&nbsp;<code>pos</code>&nbsp;is not passed as a parameter</strong>.</p>
 * 
 * <p>Return&nbsp;<code>true</code><em> if there is a cycle in the linked list</em>. Otherwise, return <code>false</code>.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2018/12/07/circularlinkedlist.png" style="width: 300px; height: 97px; margin-top: 8px; margin-bottom: 8px;" />
 * <pre>
 * <strong>Input:</strong> head = [3,2,0,-4], pos = 1
 * <strong>Output:</strong> true
 * <strong>Explanation:</strong> There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2018/12/07/circularlinkedlist_test2.png" style="width: 141px; height: 74px;" />
 * <pre>
 * <strong>Input:</strong> head = [1,2], pos = 0
 * <strong>Output:</strong> true
 * <strong>Explanation:</strong> There is a cycle in the linked list, where the tail connects to the 0th node.
 * </pre>
 * 
 * <p><strong class="example">Example 3:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2018/12/07/circularlinkedlist_test3.png" style="width: 45px; height: 45px;" />
 * <pre>
 * <strong>Input:</strong> head = [1], pos = -1
 * <strong>Output:</strong> false
 * <strong>Explanation:</strong> There is no cycle in the linked list.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li>The number of the nodes in the list is in the range <code>[0, 10<sup>4</sup>]</code>.</li>
 * 	<li><code>-10<sup>5</sup> &lt;= Node.val &lt;= 10<sup>5</sup></code></li>
 * 	<li><code>pos</code> is <code>-1</code> or a <strong>valid index</strong> in the linked-list.</li>
 * </ul>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Follow up:</strong> Can you solve it using <code>O(1)</code> (i.e. constant) memory?</p>

 */
public class LinkedListCycle {


    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    @SuppressWarnings("ClassEscapesDefinedScope")
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        do {
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
        } while (fast != null && slow != fast);
        return fast != null;
    }

    public static void main(String[] args) {
        testCase1();
        testCase2();
        testCase3();
        testCase4();
    }

    private static void testCase1() {
        ListNode node = new ListNode(3);
        node.next = new ListNode(2);
        node.next.next = new ListNode(0);
        node.next.next.next = new ListNode(-4);
        node.next.next.next.next = node.next;

        System.out.println(hasCycle(node));
    }

    private static void testCase2() {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = node;

        System.out.println(hasCycle(node));
    }

    private static void testCase3() {
        System.out.println(hasCycle(new ListNode(1)));
    }

    private static void testCase4() {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);

        System.out.println(hasCycle(node));
    }
}
