package acwing;

/**
 * <a href="https://www.acwing.com/problem/content/55/">59. 把数字翻译成字符串</a>
 */
public class NumberTranslationCount {
    public int getTranslationCount(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }

        int[] ans = new int[s.length() + 1];
        ans[0] = 1;
        ans[1] = 1;
        for (int i = 2; i <= s.length(); i++) {
            int firstChar = s.charAt(i - 2) - '0';
            int secondChar = s.charAt(i - 1) - '0';

            int a = secondChar;
            int ba = firstChar * 10 + secondChar;

            if (a >= 0 && a < 10) {
                ans[i] += ans[i - 1];
            }
            if (ba >= 10 && ba < 26) {
                ans[i] += ans[i - 2];
            }
        }
        return ans[s.length()];
    }

    public static void main(String[] args) {
        System.out.println(new NumberTranslationCount().getTranslationCount("12258"));
    }
}
