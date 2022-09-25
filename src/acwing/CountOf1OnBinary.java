package acwing;

/**
 * <a href="https://www.acwing.com/problem/content/25/">26. 二进制中1的个数</a>
 */
public class CountOf1OnBinary {
    public int numberOf1(int n) {
        int count = 0;
        if (n < 0) {
            count++;
            n = n - Integer.MIN_VALUE;
        }
        while (n != 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n /= 2;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new CountOf1OnBinary().numberOf1(-2));
        System.out.println(new CountOf1OnBinary().numberOf1(9));
    }
}
