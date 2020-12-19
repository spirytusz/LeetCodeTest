package newcoder;

/**
 * Link: https://www.nowcoder.com/practice/75e878df47f24fdc9dc3e400ec6058ca?tpId=13&&tqId=11168&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * Status: AC
 *
 * 输入一个链表，反转链表后，输出新链表的表头。
 */
public class ReverseList {
    public static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head != null && head.next != null) {
            ListNode[] node = new ListNode[1];
            reverseListInternal(head, head.next, node);
            return node[0];
        } else {
            return head;
        }
    }

    private void reverseListInternal(ListNode p, ListNode r, ListNode[] root) {
        if (r != null) {
            reverseListInternal(p.next, r.next, root);
            r.next = p;
            p.next = null;
        } else {
            root[0] = p;
        }
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        ListNode head = new ReverseList().reverseList(n1);
        while (head != null) {
            System.out.print(head.val + "\t");
            head = head.next;
        }
    }
}
