package acwing;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://www.acwing.com/problem/content/89/">48. 复杂链表的复刻</a>
 * <a href="https://www.acwing.com/solution/content/1527/">题解</a>
 */
public class ComplexRandomLinkedListCopy {
    public ListNode copyRandomList(ListNode head) {
        Map<ListNode, ListNode> map = new HashMap<>();

        ListNode node = head;
        while (node != null) {
            ListNode cloneNode = new ListNode(node.val);
            map.put(node, cloneNode);
            node = node.next;
        }

        ListNode cloneHead = map.get(head);
        node = head;
        while (node != null) {
            ListNode cloneNode = map.get(node);
            cloneNode.next = map.get(node.next);
            cloneNode.random = map.get(node.random);
            node = node.next;
        }
        return cloneHead;
    }

    public static class ListNode {
        int val;
        ListNode next, random;

        ListNode(int x) {
            this.val = x;
        }
    }

    public static void main(String[] args) {
        ListNode n11 = new ListNode(1);
        ListNode n0 = new ListNode(0);
        ListNode n12 = new ListNode(1);
        ListNode n31 = new ListNode(3);
        ListNode n32 = new ListNode(3);

        n11.next = n0;
        n0.next = n12;
        n12.next = n31;
        n31.next = n32;

        n11.random = n32;
        n0.random = n31;
        n12.random = n12;
        n31.random = n0;
        n32.random = n11;

        printList(n11);
        ListNode copy = new ComplexRandomLinkedListCopy().copyRandomList(n11);
        printList(copy);
    }

    private static void printList(ListNode head) {
        ListNode node = head;
        while (node != null) {
            if (head != node) {
                System.out.print('\t');
            }
            System.out.print("[" + node.val + ", " + node.random.val + "]");
            node = node.next;
        }
        System.out.println();
    }
}
