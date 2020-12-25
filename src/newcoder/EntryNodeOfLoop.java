package newcoder;

/**
 * Link: https://www.nowcoder.com/practice/253d2c59ec3e4bc68da16833f79a38e4?tpId=13&tqId=11207&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * Status: AC
 * <p>
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 *
 * 解析：
 * 用快慢指针法
 * 设入口处为p，因为倘若有环，最终快慢指针必然相遇，设相遇点为q，且q在环内
 * 设起点到p的距离为A，p到q的距离为B，q到p的距离为C
 *
 * 当快慢指针在q点相遇时，设快指针在圈内转了n圈，则有
 * 2(A + B) = A + n(B + C) + B
 * A = (n - 1)B + C
 * A = (n - 1)(B + C) + C
 * 即 A的距离为 n - 1倍环长度 + q处走完一圈剩下的距离
 * 因此，不妨让另一个指针从头结点一次走一步，慢指针在q点也一次走一步
 * 最终必然相遇，且相遇点必然是p
 */
public class EntryNodeOfLoop {

    public static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode entryNodeOfLoop(ListNode pHead) {
        if (pHead == null) return null;
        ListNode root = pHead;
        ListNode fast = pHead;
        ListNode slow = pHead;
        do {
            fast = fast.next;
            if (fast == null) return null;
            fast = fast.next;
            if (fast == null) return null;
            slow = slow.next;
            if (slow == null) return null;
        } while (fast.val != slow.val);
        if (slow == root) return root;
        do {
            root = root.next;
            slow = slow.next;
        } while (root != slow);
        return root;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        node7.next = node6;
        System.out.println(new EntryNodeOfLoop().entryNodeOfLoop(node1).val);
    }
}
