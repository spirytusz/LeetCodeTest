package newcoder;

/**
 * Link: https://www.nowcoder.com/practice/1a834e5e3e1a4b7ba251417554e07c00?tpId=13&&tqId=11165&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * Status: AC
 * <p>
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * <p>
 * 保证base和exponent不同时为0
 */
public class Power {
    public double pow(double base, int exponent) {
        if (base == 0.0) return 0;
        double result = 1;
        for (int i = 0; i < Math.abs(exponent); i++) {
            result *= base;
        }
        return exponent > 0 ? result : 1.0 / result;
    }

    public static void main(String[] args) {
        System.out.println(new Power().pow(2, -3));
    }
}
