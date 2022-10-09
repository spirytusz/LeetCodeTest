package acwing;

import java.util.Stack;

/**
 * <a href="https://www.acwing.com/problem/content/description/40/">42. 栈的压入、弹出序列</a>
 * <a href="https://www.acwing.com/solution/content/765/">题解</a>
 */
public class PopOrder {

    public boolean isPopOrder(int[] pushV, int[] popV) {
        if (pushV.length == 0 && popV.length == 0) {
            return true;
        }
        if (pushV.length != popV.length) {
            return false;
        }

        Stack<Integer> dummy = new Stack<>();
        int popId = 0;
        for (int i : pushV) {
            dummy.push(i);
            while (!dummy.isEmpty() && dummy.peek() == popV[popId]) {
                dummy.pop();
                popId++;
            }
        }
        return dummy.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new PopOrder().isPopOrder(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1}));
    }
}
