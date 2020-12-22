package newcoder;

/**
 * Link: https://www.nowcoder.com/practice/6aa9e04fc3794f68acf8778237ba065b?tpId=13&&tqId=11186&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * Status: AC
 * <p>
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 *
 * 解析：
 * 由题可知，丑数 n 可以写成 k * 2^x * 3^y * 5^z 的形式
 * 其中 k ∈ P1 ∪ P2，P1为不包含2，3，5的质数集合，P2为全体合数
 * 因此，k可以分为两种情况：
 * 1. k是质数，此时k == 2 || k == 3 || k == 5
 * 2. k是合数，由合数的性质可知，k = p1 * p2 * .. * pn， p1 ~ p2均为质数，再由丑数的性质可知
 *    k 同样可以写成如下形式 k = 2^x1 * 3^y1 * 5^z1
 *
 * 从而，丑数可以写成 n = 2^x * 3^y * 5^z 的形式
 *
 * 求第n个丑数，只需要根据这个公式从小到大迭代即可。
 */
public class UglyNumber {

    public int getUglyNumByIndex(int index) {
        if (index == 0) return 0;
        int[] result = new int[index];
        result[0] = 1;
        int x = 0, y = 0, z = 0;
        for (int i = 1; i < index; i++) {
            result[i] = Math.min(result[x] * 2, Math.min(result[y] * 3, result[z] * 5));
            if (result[i] == result[x] * 2) x++;
            if (result[i] == result[y] * 3) y++;
            if (result[i] == result[z] * 5) z++;
        }
        return result[index - 1];
    }

    public static void main(String[] args) {
        UglyNumber uglyNumber = new UglyNumber();
        System.out.println(uglyNumber.getUglyNumByIndex(1000));
    }
}
