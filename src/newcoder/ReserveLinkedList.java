package newcoder;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Link: https://www.nowcoder.com/practice/d0267f7f55b3412ba93bd35cfa8e8035?tpId=13&&tqId=11156&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * Status: AC
 *
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 * <p>
 * 示例1
 * Input: {67,0,24,58}
 * Output: [58,24,0,67]
 */
public class ReserveLinkedList {

    public static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }


    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<>();
        reserve(listNode, result);
        return result;
    }

    private static void reserve(ListNode node, ArrayList<Integer> result) {
        if (node != null) {
            reserve(node.next, result);
            result.add(node.val);
        }
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        List<Integer> result = printListFromTailToHead(n1);
        System.out.println(result);
    }
}
