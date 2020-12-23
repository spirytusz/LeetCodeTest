package newcoder;

import java.util.Stack;

/**
 * Link: https://www.nowcoder.com/practice/6ab1d9a29e88450685099d45c9e31e46?tpId=13&&tqId=11189&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * Status: AC
 * <p>
 * 输入两个链表，找出它们的第一个公共结点。（注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
 */
public class FirstCommonNode {
    public static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode common = null;
        Stack<ListNode> l1 = new Stack<>();
        Stack<ListNode> l2 = new Stack<>();
        while (pHead1 != null) {
            l1.push(pHead1);
            pHead1 = pHead1.next;
        }
        while (pHead2 != null) {
            l2.push(pHead2);
            pHead2 = pHead2.next;
        }
        while (!l1.isEmpty() && !l2.isEmpty() && l1.peek().equals(l2.peek())) {
            common = l1.peek();
            l1.pop();
            l2.pop();
        }
        return common;
    }

    public static void main(String[] args) {
        ListNode ln1 = new ListNode(1);
        ListNode ln2 = new ListNode(2);
        ListNode ln3 = new ListNode(3);
        ListNode ln4 = new ListNode(4);
        ListNode ln5 = new ListNode(5);
        ListNode ln6 = new ListNode(6);
        ListNode ln7 = new ListNode(7);
        ln1.next = ln2;
        ln2.next = ln3;
        ln3.next = ln4;
        ln4.next = ln5;
        ln5.next = ln6;
        ln6.next = ln7;
        System.out.println(new FirstCommonNode().findFirstCommonNode(ln1, ln4).val);
    }
}
