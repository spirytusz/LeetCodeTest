package newcoder;

/**
 * Link: https://www.nowcoder.com/practice/c6c7742f5ba7442aada113136ddea0c3?tpId=13&&tqId=11160&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * Status: AC
 *
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0，第1项是1）。
 * n <= 39
 */
public class Fibonacci {
    public int fibonacci(int n) {
        if (n == 0) return 0;
        if (n <= 2) return 1;
        int[] result = new int[n];
        result[0] = 1;
        result[1] = 1;
        for (int i = 2; i < result.length; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }
        return result[result.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Fibonacci().fibonacci(0));
    }
}
