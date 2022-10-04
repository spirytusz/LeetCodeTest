package acwing;

/**
 * <a href="https://www.acwing.com/problem/content/34/">36. 合并两个排序的链表</a>
 */
public class MergeSortedLinkedList {
    public ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        ListNode head;
        if (l1.val < l2.val) {
            head = l1;
            l1 = l1.next;
        } else {
            head = l2;
            l2 = l2.next;
        }
        ListNode node = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                node.next = l1;
                l1 = l1.next;
            } else {
                node.next = l2;
                l2 = l2.next;
            }
            node = node.next;
        }

        node.next = l1 != null ? l1 : l2;
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode[] listNodes = new ListNode[6];
        for (int i = 0; i < listNodes.length; i++) {
            listNodes[i] = new ListNode(i + 1);
        }

        listNodes[0].next = listNodes[2];
        listNodes[2].next = listNodes[4];
        listNodes[1].next = listNodes[3];
        listNodes[3].next = listNodes[5];

        ListNode head = new MergeSortedLinkedList().merge(listNodes[0], listNodes[1]);
        while (head != null) {
            System.out.print(head.val + "\t");
            head = head.next;
        }
        System.out.println();
    }
}
