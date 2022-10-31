package acwing;

/**
 * <a href="https://www.acwing.com/problem/content/52/">57. 数字序列中某一位的数字</a>
 */
public class DigitAtIndex {

    public int digitAtIndex(int n) {
        if (n < 0) {
            return -1;
        }
        if (n < 10) {
            return n;
        }

        // 1位占10个，2位占 2 * 90 个，n位占 n * 9 * 10 ^ (n - 1)个
        // 跳到10 ^ (n - 1)
        long sumOfDigit = 10;
        int i = 2;
        while (sumOfDigit < n) {
            sumOfDigit += (long)( 9 * Math.pow(10, i - 1) * i);
            i++;
        }
        i--;
        sumOfDigit -= (long)( 9 * Math.pow(10, i - 1) * i);

        // 还剩下多少
        int remain = n - (int) sumOfDigit;
        // 根据位数跳到目标数字上
        int offset = remain / i;
        int targetDigit = (int) Math.pow(10, i - 1) + offset;

        // 找到对应数字
        int index = remain - offset * i;
        return (targetDigit + "").toCharArray()[index] - '0';
    }

    public static void main(String[] args) {
        System.out.println(new DigitAtIndex().digitAtIndex(15));
    }
}
