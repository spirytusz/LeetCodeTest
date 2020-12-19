package newcoder;

/**
 * Link: https://www.nowcoder.com/practice/d8b6b4358f774294a89de2a6ac4d9337?tpId=13&&tqId=11169&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * Status: AC
 * <p>
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class MergeLinkedList {

    public static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode merge(ListNode list1, ListNode list2) {
        ListNode p = list1;
        ListNode q = list2;
        ListNode root = new ListNode(0);
        ListNode head = root;
        while (p != null && q != null) {
            ListNode target = null;
            if (p.val < q.val) {
                target = p;
                p = p.next;
            } else {
                target = q;
                q = q.next;
            }
            head.next = new ListNode(target.val);
            head = head.next;
        }
        ListNode remain = p != null ? p : q;
        while (remain != null) {
            head.next = new ListNode(remain.val);
            remain = remain.next;
            head = head.next;
        }
        return root.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        l1.next = l3;
        l3.next = l5;
        l2.next = l4;
        l4.next = l6;
        ListNode root = new MergeLinkedList().merge(l1, l2);
        while (root != null) {
            System.out.print(root.val + "\t");
            root = root.next;
        }
    }
}
