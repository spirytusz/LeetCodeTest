package newcoder;

/**
 * Link: https://www.nowcoder.com/practice/4c776177d2c04c2494f2555c9fcc1e49?tpId=13&&tqId=11173&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * Status: AC
 *
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 *
 */

import java.util.Stack;

public class MinValueStack {

    private final Stack<Integer> stack = new Stack<>();
    private int minIndex = 0;

    public void push(int node) {
        stack.push(node);
        int min = min();
        if (node <= min) {
            minIndex = stack.size() - 1;
        }
    }

    public void pop() {
        if (minIndex == stack.size() - 1) {
            stack.pop();
            int minIndex = 0;
            int minValue = Integer.MAX_VALUE;
            for (int i = 0;i<stack.size();i++) {
                if (stack.elementAt(i) < minValue) {
                    minValue = stack.elementAt(i);
                    minIndex = i;
                }
            }
            this.minIndex = minIndex;
        } else {
            stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        if (stack.isEmpty()) {
            return 0;
        } else {
            return stack.elementAt(minIndex);
        }
    }

    public static void main(String[] args) {
        MinValueStack stack = new MinValueStack();
        stack.push(1);
        System.out.println(stack.min());
        stack.push(2);
        System.out.println(stack.min());
        stack.push(3);
        System.out.println(stack.min());
        stack.push(-1);
        System.out.println(stack.min());
        stack.push(-2);
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());
    }
}
