package acwing;

/**
 * <a href="https://www.acwing.com/problem/content/26/">27. 数值的整数次方</a>
 */
public class PowerXN {
    public double power(double base, int exponent) {
        if (exponent == Integer.MIN_VALUE) {
            return 0;
        }
        return exponent > 0 ? powerInternal(base, exponent) : 1.0 / powerInternal(base, -exponent);
    }

    private double powerInternal(double base, int exponent) {
        if (exponent == 0) {
            return 1.0;
        }
        if (exponent == 1) {
            return base;
        }
        if ((exponent & 1) == 0) {
            double split = powerInternal(base, exponent / 2);
            return split * split;
        } else {
            double split = powerInternal(base, (exponent - 1) / 2);
            return base * split * split;
        }
    }

    public static void main(String[] args) {
        System.out.println(new PowerXN().power(10, Integer.MIN_VALUE));
    }
}
