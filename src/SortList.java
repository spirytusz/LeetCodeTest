
/**
 * <a href="https://leetcode.com/problems/sort-list/description/?envType=study-plan-v2&envId=top-100-liked">148. Sort List</a>
 * 
 * <p>Given the <code>head</code> of a linked list, return <em>the list after sorting it in <strong>ascending order</strong></em>.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/09/14/sort_list_1.jpg" style="width: 450px; height: 194px;" />
 * <pre>
 * <strong>Input:</strong> head = [4,2,1,3]
 * <strong>Output:</strong> [1,2,3,4]
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/09/14/sort_list_2.jpg" style="width: 550px; height: 184px;" />
 * <pre>
 * <strong>Input:</strong> head = [-1,5,3,4,0]
 * <strong>Output:</strong> [-1,0,3,4,5]
 * </pre>
 * 
 * <p><strong class="example">Example 3:</strong></p>
 * 
 * <pre>
 * <strong>Input:</strong> head = []
 * <strong>Output:</strong> []
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li>The number of nodes in the list is in the range <code>[0, 5 * 10<sup>4</sup>]</code>.</li>
 * 	<li><code>-10<sup>5</sup> &lt;= Node.val &lt;= 10<sup>5</sup></code></li>
 * </ul>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Follow up:</strong> Can you sort the linked list in <code>O(n logn)</code> time and <code>O(1)</code> memory (i.e. constant space)?</p>

 */
public class SortList {


    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    @SuppressWarnings("ClassEscapesDefinedScope")
    public static ListNode sortList(ListNode head) {
        return mergeSort(head);
    }

    private static ListNode mySolution(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode node = head;
        while (node != null) {
            ListNode minNode = node;
            ListNode loopNode = node;
            while (loopNode != null) {
                if (minNode.val > loopNode.val) {
                    minNode = loopNode;
                }
                loopNode = loopNode.next;
            }
            int temp = minNode.val;
            minNode.val = node.val;
            node.val = temp;
            node = node.next;
        }
        return head;
    }

    private static ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;
        slow.next = null;

        ListNode left = mergeSort(head);
        ListNode right = mergeSort(mid);
        return merge(left, right);
    }

    private static ListNode merge(ListNode left, ListNode right) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (left != null && right != null) {
            if (left.val < right.val) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        cur.next = left != null ? left : right;
        return head.next;
    }

    public static void main(String[] args) {
        testCase1();
        testCase2();
    }

    private static void testCase1() {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(1);

        ListNode result = sortList(head);
        while (result != null) {
            System.out.print(result.val + "\t");
            result = result.next;
        }
        System.out.println();
    }

    private static void testCase2() {
        ListNode head = new ListNode(-1);
        head.next = new ListNode(5);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(0);

        ListNode result = sortList(head);
        while (result != null) {
            System.out.print(result.val + "\t");
            result = result.next;
        }
        System.out.println();
    }
}
