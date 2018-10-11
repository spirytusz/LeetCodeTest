/**
 * Link: https://leetcode.com/problems/swap-nodes-in-pairs/
 * Status: Have no idea
 * <p>
 * Given a linked list, swap every two adjacent nodes and return its head.
 * <p>
 * Example:
 * <p>
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * Note:
 * <p>
 * * Your algorithm should use only constant extra space.
 * * You may not modify the values in the list's nodes, only nodes itself may be changed.
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

    public static ListNode swapPairs(ListNode head) {
        return swapN(head, 4);
    }

    private static ListNode swapN(ListNode head, int n) {
        if (n == 0 || n == 1) {
            return head;
        } else {
            int i = 0;
            ListNode root = head;
            ListNode[] frontNode = new ListNode[1];
            ListNode[] rearNode = new ListNode[1];
            ListNode[] tempNodes = new ListNode[n];
            while (head != null) {
                tempNodes[i % n] = head;
                if (i % n == n - 1) {
                    rearNode[0] = tempNodes[n - 1].next;
                    tempNodes[0].next = rearNode[0];
                    for(int j = 0;j<n-1;j++)
                        tempNodes[j+1].next = tempNodes[j];
                    if(frontNode[0] != null)
                        frontNode[0].next = tempNodes[n - 1];
                }
                i++;
                head = head.next;
            }
            return root;
        }
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
        swapPairs(root);
        printList(root);
    }

    private static void printList(ListNode root) {
        while (root != null) {
            System.out.print(root.val + "\t");
            root = root.next;
        }
    }

    private static void printList(ListNode[] listNodes) {
        for (ListNode listNode : listNodes) {
            System.out.print(listNode + "\t");
        }
        System.out.println();
    }
}