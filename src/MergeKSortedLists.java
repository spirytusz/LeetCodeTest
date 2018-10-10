/**
 * Link: https://leetcode.com/problems/merge-k-sorted-lists/
 * Status: AC
 * <p>
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * <p>
 * Example:
 * <p>
 * Input:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 */
public class MergeKSortedLists {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode root = new ListNode(0);
        ListNode node = root;
        while (!isAllNull(lists)) {
            int minHeaderIndex = 0;
            int minValue = Integer.MAX_VALUE;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null && lists[i].val < minValue) {
                    minValue = lists[i].val;
                    minHeaderIndex = i;
                }
            }
            node.next = lists[minHeaderIndex];
            node = node.next;
            lists[minHeaderIndex] = lists[minHeaderIndex].next;
        }
        return root.next;
    }

    private static boolean isAllNull(ListNode[] headers) {
        for (int i = 0; i < headers.length; i++) {
            if (headers[i] != null)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);
        ListNode listNode = mergeKLists(new ListNode[]{l1, l2, l3});
        printLists(listNode);
    }

    private static void printLists(ListNode node) {
        while(node != null) {
            System.out.print(node.val+"\t");
            node = node.next;
        }
    }
}
