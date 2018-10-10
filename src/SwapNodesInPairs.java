/**
 * Link: https://leetcode.com/problems/swap-nodes-in-pairs/
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

    /*public static ListNode swapPairs(ListNode head) {
        int i = 0;
        ListNode root = new ListNode(0);
        ListNode storedRoot = root;
        ListNode[] tmp = new ListNode[4];
        while (head != null) {
            addWithShift(tmp, head, 3 - i);
            if (i == 3) {
               root.next = tmp[1];
               root = root.next;
               root.next = tmp[0];
            } else if (i % 2 == 1) {
                root.next = tmp[2];
                root = root.next;
                root.next = tmp[1];
            }
            i++;
            head = head.next;
        }
        if(i == 0 || i == 1)
            return head;
        else if(i == 2) {
            root.next = head.next;
            root = root.next;
            root.next = head;
            return storedRoot.next;
        }
        return storedRoot.next;
    }*/

    public static ListNode swapPairs(ListNode head) {
        int i = 0;
        ListNode root = new ListNode(0);
        ListNode front = null;
        while (head != null) {
            if (i % 2 == 0) {
                front = head;
            } else {
                root.next = head;
                root = root.next;
                System.out.print(root+"\t");
                root.next = front;
                root = root.next;
                System.out.print(root+"\t");
            }
            i++;
            head = head.next;
        }
        return root.next;
    }

    private static void addWithShift(ListNode[] listNodes, ListNode node, int size) {
        int start = size > 0 ? size : 0;
        for (int i = start; i < listNodes.length - 1; i++) {
            listNodes[i] = listNodes[i + 1];
        }
        listNodes[listNodes.length - 1] = node;
    }

    private static void swap(ListNode pFront, ListNode p, ListNode q, ListNode qRear) {
        if (pFront != null) {
            pFront.next = q;
        }
        if (q != null) {
            q.next = p;
        }
        p.next = qRear;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);
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