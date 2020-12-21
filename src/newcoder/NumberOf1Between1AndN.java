package newcoder;

/**
 * Link: https://www.nowcoder.com/practice/bd7f978302044eee894445e244c7eee6?tpId=13&tqId=11182&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * Status: AC
 * <p>
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 */
public class NumberOf1Between1AndN {

    public int numberOf1Between1AndN(int n) {
        int result = 0;
        for (int i = 1; i <= n; i++) {
            result += numberOf1(i);
        }
        return result;
    }

    private int numberOf1(int n) {
        int result = 0;
        while (n > 0) {
            if (n % 10 == 1) {
                result++;
            }
            n /= 10;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new NumberOf1Between1AndN().numberOf1Between1AndN(13));
    }
}
