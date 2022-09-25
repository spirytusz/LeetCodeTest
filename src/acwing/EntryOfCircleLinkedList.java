package acwing;

/**
 * <a href="https://www.acwing.com/problem/content/86/">34. 链表中环的入口结点</a>
 */
@SuppressWarnings("ALL")
public class EntryOfCircleLinkedList {
    public ListNode entryNodeOfLoop(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;

        do {
            fast = fast.next;
            if (fast == null) {
                return null;
            }
            fast = fast.next;

            slow = slow.next;
        } while (fast != null && slow != null && fast != slow);
        if (fast == null || slow == null) {
            return null;
        }
        slow = head;
        do {
            fast = fast.next;
            slow = slow.next;
        } while (fast != slow);
        return fast;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(7);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;

        n7.next = n3;

        System.out.println(new EntryOfCircleLinkedList().entryNodeOfLoop(n1).val);
    }
}
