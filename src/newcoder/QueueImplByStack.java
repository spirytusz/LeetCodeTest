package newcoder;

import java.util.Stack;

/**
 * Link: https://www.nowcoder.com/practice/54275ddae22f475981afa2244dd448c6?tpId=13&&tqId=11158&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * Status: AC
 *
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */
public class QueueImplByStack {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        int result = stack2.pop();
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        return result;
    }

    @Override
    public String toString() {
        return stack1.toString();
    }

    public static void main(String[] args) {
        QueueImplByStack queue = new QueueImplByStack();
        queue.push(1);
        System.out.println(queue);
        queue.push(2);
        System.out.println(queue);
        queue.push(3);
        System.out.println(queue);
        queue.push(4);
        System.out.println(queue);
        queue.pop();
        System.out.println(queue);
        queue.pop();
        System.out.println(queue);
        queue.pop();
        System.out.println(queue);
        queue.pop();
        System.out.println(queue);
    }
}
