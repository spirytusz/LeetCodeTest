package newcoder;

/**
 * Link: https://www.nowcoder.com/practice/fc533c45b73a41b0b44ccba763f866ef?tpId=13&tqId=11207&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * Status: AC
 * <p>
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class DeleteDuplicationNode {
    public static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null) return null;
        ListNode root = new ListNode(1);
        ListNode node = root;
        ListNode p = pHead;
        ListNode q = pHead.next;
        while (p != null && q != null) {
            if (p.val != q.val) {
                node.next = p;
                node = node.next;

                ListNode next = p.next;
                p.next = null;
                p = next;
                q = q.next;
                continue;
            }
            while (q != null && p.val == q.val) {
                q = q.next;
            }
            p = q;
            q = q != null ? q.next : null;
        }
        node.next = p;
        return root.next;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);
        ListNode listNode7 = new ListNode(7);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;

        ListNode result = new DeleteDuplicationNode().deleteDuplication(listNode1);
        while (result != null) {
            System.out.printf("%d\t", result.val);
            result = result.next;
        }
    }
}
