package newcoder;

/**
 * Link: https://www.nowcoder.com/practice/8ee967e43c2c4ec193b040ea7fbb10b8?tpId=13&&tqId=11164&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * Status: AC
 * <p>
 * 输入一个整数，输出该数32位二进制表示中1的个数。其中负数用补码表示。
 */
public class BinaryNumberOf1 {

    public int numberOf1(int n) {
        long m = n >= 0 ? n : (long) Integer.MAX_VALUE - (long) Integer.MIN_VALUE + (long) n + 1L;
        int count = 0;
        while (m != 0) {
            if (m % 2 != 0) count++;
            m /= 2;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new BinaryNumberOf1().numberOf1(-1));
    }
}
