package acwing;

/**
 * <a href="https://www.acwing.com/problem/content/33/">35. 反转链表</a>
 */
@SuppressWarnings("DuplicatedCode")
public class ReverseList {

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode[] result = new ListNode[1];
        reverseInternal(head, head.next, result);
        return result[0];
    }

    private void reverseInternal(ListNode pre, ListNode rear, ListNode[] result) {
        if (pre == null || rear == null) {
            return;
        } else {
            if (rear.next == null) {
                result[0] = rear;
            }
            reverseInternal(pre.next, rear.next, result);
            rear.next = pre;
            pre.next = null;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        ListNode root = new ReverseList().reverseList(n1);
        while (root != null) {
            System.out.print(root.val + "\t");
            root = root.next;
        }
    }
}
