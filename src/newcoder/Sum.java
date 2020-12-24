package newcoder;

/**
 * Link: https://www.nowcoder.com/practice/7a0da8fc483247ff8800059e12d7caf1?tpId=13&tqId=11199&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * Status: AC
 *
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）
 */
public class Sum {

    public int sum(int n) {
        int sum = 0;
        boolean a = n >= 1 && (sum = n + sum(n - 1)) > 0;
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Sum().sum(100));
    }
}
