/**
 * <a href="https://leetcode.com/problems/reverse-nodes-in-k-group/">25. Reverse Nodes in k-Group</a>
 * <a href="https://zhuanlan.zhihu.com/p/90170262">题解</a>
 */
public class ReverseKGroupLinkedList {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode end = head;
        for (int i = 0; i < k; i++) {
            if (end != null) {
                end = end.next;
            } else {
                return head;
            }
        }

        ListNode reversedHead = reverseKGroupSub(head, end);
        head.next = reverseKGroup(end, k);
        return reversedHead;
    }

    private ListNode reverseKGroupSub(ListNode head, ListNode end) {
        if (head == null) {
            return null;
        }

        ListNode pre = null;
        ListNode current = head;
        ListNode rear = head;
        while (current != end) {
            rear = current.next;
            current.next = pre;

            pre = current;
            current = rear;
        }
        return pre;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        ListNode[] nodes = new ListNode[5];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new ListNode(i + 1);
            if (i >= 1) {
                nodes[i - 1].next = nodes[i];
            }
        }

        ListNode head = new ReverseKGroupLinkedList().reverseKGroup(nodes[0], 2);
        while (head != null) {
            System.out.print(head.val + "\t");
            head = head.next;
        }
    }
}
