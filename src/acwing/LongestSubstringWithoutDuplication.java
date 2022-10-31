package acwing;

/**
 * <a href="https://www.acwing.com/problem/content/57/">61. 最长不含重复字符的子字符串</a>
 * <a href="https://www.acwing.com/solution/content/1844/">题解</a>
 */
@SuppressWarnings("ALL")
public class LongestSubstringWithoutDuplication {
    // 双指针，j先走，每走一次计数一次当前的字符到memory中
    // 走完一次，检查i指针的字符出现的次数，>= 2则i++，直到 == 1
    // 最大值取 max(j - i)
    public int longestSubstringWithoutDuplication(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int[] memory = new int[26];
        int i = 0;
        int j = 0;
        int max = 0;
        while (j < s.length()) {
            memory[s.charAt(j) - 'a']++;

            while (memory[s.charAt(j) - 'a'] > 1) {
                memory[s.charAt(i) - 'a']--;
                i++;
            }
            j++;

            max = Math.max(max, j - i);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new LongestSubstringWithoutDuplication().longestSubstringWithoutDuplication("ababc"));
    }
}
