package newcoder;

/**
 * Link: https://www.nowcoder.com/practice/d77d11405cc7470d82554cb392585106?tpId=13&&tqId=11174&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * Status: AC
 * <p>
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 * <p>
 * 解析：
 * 1. 初始化一个栈，大小pushA.length；
 * 2. 初始化指针i, j, 分别指向pushA和popA的头部；
 * 3. 当pushA[i] == popA[j]时，表明元素pushA[i]入栈后立即出栈，i++和j++即可，并检查popA[j + 1]之后的元素，是否等于stack顶，循环弹出；
 * 4. 当pushA[i] != popA[j]时，表明元素pushA[i]只入栈，推入临时栈stack中，i++
 * 5. 循环3，4，直到i >= pushA.length || j >= popA.length为止
 * 6. 如果stack不为空，则说明不是弹出的顺序，返回false，否则返回true。
 */
public class StackPopOrder {

    public boolean isPopOrder(int[] pushA, int[] popA) {
        int[] stack = new int[pushA.length];
        int top = -1;
        int i = 0;
        int j = 0;
        while (i < pushA.length && j < popA.length) {
            if (pushA[i] == popA[j]) {
                while (top >= 0 && popA[j + 1] == stack[top]) {
                    j++;
                    top--;
                }
                i++;
                j++;
            } else {
                stack[++top] = pushA[i++];
            }
        }
        return top < 0;
    }

    public static void main(String[] args) {
        System.out.println(new StackPopOrder().isPopOrder(new int[]{1, 2, 3, 4, 5}, new int[]{4, 3, 5, 1, 2}));
    }
}
