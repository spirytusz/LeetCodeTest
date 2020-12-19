package newcoder;

import java.util.ArrayList;
import java.util.List;

/**
 * Link: https://www.nowcoder.com/practice/529d3ae5a407492994ad2a246518148a?tpId=13&&tqId=11167&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * Status: AC
 * <p>
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class FindKthToTail {

    public static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode findKthToTail(ListNode head, int k) {
        List<ListNode> result = new ArrayList<>(1);
        findKthToTailInternal(head, new int[]{k}, result);
        return result.isEmpty() ? null : result.get(0);
    }

    private void findKthToTailInternal(ListNode head, int[] counter, List<ListNode> result) {
        if (head != null) {
            findKthToTailInternal(head.next, counter, result);
            counter[0]--;
            if (counter[0] == 0) {
                result.add(head);
            }
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
        ListNode result = new FindKthToTail().findKthToTail(n1, 2);
        System.out.println(result.val);
    }
}
