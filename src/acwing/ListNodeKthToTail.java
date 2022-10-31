package acwing;

/**
 * <a href="https://www.acwing.com/problem/content/32/">33. 链表中倒数第k个节点</a>
 */
public class ListNodeKthToTail {
    private int k = 0;

    public ListNode findKthToTail(ListNode pListHead, int k) {
        this.k = k;
        return findKthToTailInternal(pListHead);
    }

    private ListNode findKthToTailInternal(ListNode pListHead) {
        if (pListHead == null) {
            return null;
        }
        ListNode result = findKthToTailInternal(pListHead.next);
        if (result != null) {
            return result;
        }
        k--;
        if (k == 0) {
            return pListHead;
        } else {
            return null;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        ListNode pre = root;
        for (int i = 2; i <= 5; i++) {
            ListNode node = new ListNode(i);
            pre.next = node;
            pre = node;
        }

        System.out.println(new ListNodeKthToTail().findKthToTail(root, 2).val);
        System.out.println(new ListNodeKthToTail().findKthToTail(root, 5).val);
        System.out.println(new ListNodeKthToTail().findKthToTail(root, 6));
    }
}
