import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/swap-nodes-in-pairs/description/">24. Swap Nodes in Pairs</a>
 *
 * <div class="elfjS" data-track-load="description_content"><p>Given a&nbsp;linked list, swap every two adjacent nodes and return its head. You must solve the problem without&nbsp;modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <div class="example-block">
 * <p><strong>Input:</strong> <span class="example-io">head = [1,2,3,4]</span></p>
 *
 * <p><strong>Output:</strong> <span class="example-io">[2,1,4,3]</span></p>
 *
 * <p><strong>Explanation:</strong></p>
 *
 * <p><img alt="" src="https://assets.leetcode.com/uploads/2020/10/03/swap_ex1.jpg" style="width: 422px; height: 222px;"></p>
 * </div>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <div class="example-block">
 * <p><strong>Input:</strong> <span class="example-io">head = []</span></p>
 *
 * <p><strong>Output:</strong> <span class="example-io">[]</span></p>
 * </div>
 *
 * <p><strong class="example">Example 3:</strong></p>
 *
 * <div class="example-block">
 * <p><strong>Input:</strong> <span class="example-io">head = [1]</span></p>
 *
 * <p><strong>Output:</strong> <span class="example-io">[1]</span></p>
 * </div>
 *
 * <p><strong class="example">Example 4:</strong></p>
 *
 * <div class="example-block">
 * <p><strong>Input:</strong> <span class="example-io">head = [1,2,3]</span></p>
 *
 * <p><strong>Output:</strong> <span class="example-io">[2,1,3]</span></p>
 * </div>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li>The number of nodes in the&nbsp;list&nbsp;is in the range <code>[0, 100]</code>.</li>
 * 	<li><code>0 &lt;= Node.val &lt;= 100</code></li>
 * </ul>
 * </div>
 */
public class SwapNodesInPairs {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return val + "";
        }
    }

    @SuppressWarnings({"ClassEscapesDefinedScope", "UnusedReturnValue"})
    public static ListNode swapPairs(ListNode head) {
        return swapN(head, 2);
    }

    private static ListNode swapN(ListNode head, int n) {
        int currentLoopCount = 0;
        ListNode newHead = new ListNode(0);
        ListNode root = null;
        ListNode loopEnd = newHead;
        ListNode[] tempList = new ListNode[n];
        while (head != null) {
            tempList[currentLoopCount++] = head;
            head = head.next;

            if (currentLoopCount == n) {
                currentLoopCount = 0;

                tempList[0].next = null;
                for (int i = 1; i < tempList.length; i++) {
                    tempList[i].next = tempList[i - 1];
                }
                if (loopEnd != null) {
                    loopEnd.next = tempList[n - 1];
                }
                loopEnd = tempList[0];

                if (root == null) {
                    root = tempList[n - 1];
                }
                Arrays.fill(tempList, null);
            }
        }
        if (currentLoopCount < n) {
            loopEnd.next = tempList[0];
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);
        root.next.next.next.next.next = new ListNode(6);
        root.next.next.next.next.next.next = new ListNode(7);
        root.next.next.next.next.next.next.next = new ListNode(8);
        ListNode newRoot = swapPairs(root);
        printList(newRoot);
    }

    private static void printList(ListNode root) {
        while (root != null) {
            System.out.print(root.val + "\t");
            root = root.next;
        }
    }
}