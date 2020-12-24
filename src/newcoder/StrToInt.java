package newcoder;

/**
 * Link: https://www.nowcoder.com/practice/1277c681251b4372bdef344468e4f26e?tpId=13&tqId=11199&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * Status: AC
 * <p>
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 */
public class StrToInt {

    public int strToInt(String str) {
        if (str.isEmpty()) return 0;
        int i = str.length() - 1;
        int result = 0;
        int count = 0;
        while (i >= 0) {
            char c = str.charAt(i);
            if (c >= '0' && c <= '9') {
                result += (c - '0') * Math.pow(10, count);
            } else {
                if (i == 0) {
                    if (c == '+') {
                        return result;
                    } else if (c == '-') {
                        return -result;
                    } else {
                        return 0;
                    }
                } else {
                    return 0;
                }
            }
            count++;
            i--;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new StrToInt().strToInt("2147483647"));
    }
}
