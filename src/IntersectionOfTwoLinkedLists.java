/**
 * <a href="https://leetcode.com/problems/intersection-of-two-linked-lists/">160. Intersection of Two Linked Lists</a>
 */
public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        ListNode end = null;
        while (true) {
            if (nodeA == nodeB) {
                return nodeA;
            }
            if (nodeA.next == null) {
                if (end != null && end != nodeA) {
                    return null;
                }
                end = nodeA;
            }
            if (nodeB.next == null) {
                if (end != null && end != nodeB) {
                    return null;
                }
                end = nodeB;
            }
            nodeA = nodeA.next;
            nodeB = nodeB.next;

            if (nodeA == null) {
                nodeA = headA;
            }
            if (nodeB == null) {
                nodeB = headB;
            }
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
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
        ListNode n8 = new ListNode(8);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        n6.next = n7;
        n7.next = n8;
        n8.next = n3;

        System.out.println(new IntersectionOfTwoLinkedLists().getIntersectionNode(n1, n6).val);
    }
}
