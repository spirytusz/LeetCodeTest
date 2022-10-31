/**
 * <a href="https://leetcode.com/problems/decode-ways/">91. Decode Ways</a>
 * <a href="https://leetcode.com/problems/decode-ways/discuss/30358/Java-clean-DP-solution-with-explanation">Java clean DP solution with explanation</a>
 */
public class DecodeWays {
    public int numDecodings(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int[] result = new int[s.length() + 1];
        result[0] = 1;
        result[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i < result.length; i++) {
            int x = s.charAt(i - 2) - '0';
            int y = s.charAt(i - 1) - '0';
            int firstNum = y;
            int secondNum = x * 10 + y;
            //       i
            //       ↓
            // ....xyz...
            //
            // firstNum = y
            // secondNum = x * 10 + y
            if (firstNum >= 1 && firstNum <= 9) {
                // firstNum非0，加上这个方案的结果
                result[i] += result[i - 1];
            }
            if (secondNum >= 10 && secondNum <= 26) {
                // secondNum == 0, result[i] = 0
                // 1 <= secondNum <= 9, 与上面重合 result[i] = result[i - 1]
                // 10 <= secondNum <= 26, 与上面重合一部分，result[i] = result[i - 1] /* 重合的部分 */ + result[i - 2] /* xy能组成一种方案，加上这个方案，即result[i - 2] */
                // secondNum > 27, 与上面重合一部分, result[i] = result[i - 1]
                result[i] += result[i - 2];
            }
        }
        return result[s.length()];
    }

    public static void main(String[] args) {
        System.out.println(new DecodeWays().numDecodings("12"));
        System.out.println(new DecodeWays().numDecodings("226"));
        System.out.println(new DecodeWays().numDecodings("06"));
        System.out.println(new DecodeWays().numDecodings("27"));
        System.out.println(new DecodeWays().numDecodings("1201234"));
        System.out.println(new DecodeWays().numDecodings("2101"));
        System.out.println(new DecodeWays().numDecodings("2611055971756562"));
    }
}
