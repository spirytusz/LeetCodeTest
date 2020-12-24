package newcoder;

/**
 * Link: https://www.nowcoder.com/practice/59ac416b4b944300b617d4f7f111b215?tpId=13&tqId=11199&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * Status: AC
 * <p>
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 * <p>
 * 解析：
 * 加法 x ^ y
 * 进位 (x & y) << 1
 */
public class NoOperatorAdd {
    public int add(int num1, int num2) {
        int shift;
        int result;
        do {
            result = num1 ^ num2;
            shift = (num1 & num2) << 1;
            num1 = result;
            num2 = shift;
        } while (shift != 0);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new NoOperatorAdd().add(100, 4));
    }
}
