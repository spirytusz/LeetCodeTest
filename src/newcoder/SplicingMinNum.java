package newcoder;

/**
 * Link: https://www.nowcoder.com/practice/8fecd3f8ba334add803bf2a06af1b993?tpId=13&&tqId=11185&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * Status:
 * <p>
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class SplicingMinNum {
    public String printMinNumber(int[] numbers) {
        return printMinNumberInternal(numbers, 0, new boolean[numbers.length]);
    }

    private String printMinNumberInternal(int[] numbers, int layer, boolean[] used) {
        if (layer == numbers.length) {
            return "";
        } else {
            String str;
            long min = Long.MAX_VALUE;
            for (int i = 0; i < numbers.length; i++) {
                if (!used[i]) {
                    used[i] = true;
                    str = numbers[i] + "" + printMinNumberInternal(numbers, layer + 1, used);
                    used[i] = false;
                    long val = Long.parseLong(str);
                    if (val < min) {
                        min = val;
                    }
                }
            }
            return min + "";
        }
    }

    public static void main(String[] args) {
        System.out.println(new SplicingMinNum().printMinNumber(new int[]{3, 32, 321}));
    }
}
