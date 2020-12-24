package newcoder;

/**
 * Link: https://www.nowcoder.com/practice/12d959b108cb42b1ab72cef4d36af5ec?tpId=13&tqId=11194&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * Status: AC
 * <p>
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
 */
public class LeftRotateString {
    public String leftRotateString(String str,int n) {
        if (str.length() == 0) return str;
        int shift = n % str.length();
        return str.substring(shift) + str.substring(0, shift);
    }

    public static void main(String[] args) {
        System.out.println(new LeftRotateString().leftRotateString("abcXYZdef", 3));
    }
}
