import java.util.HashSet;

/**
 * Link: https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * Status: AC
 * <p>
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Example 1:
 * <p>
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 * <p>
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 * <p>
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubStringWithoutRepeatingCharacters {

    public static int lengthOfLongestSubstring(String s) {
        char[] charArray = s.toCharArray();
        int i = 0;
        int j = 0;
        int maxLength = 0;
        while (i < charArray.length && j < charArray.length) {
            if (isSuitableCase(charArray, i, j)) {
                if (maxLength < Math.abs(i - j) + 1) {
                    maxLength = Math.abs(i - j) + 1;
                }
                j++;
            } else {
                i++;
            }
        }
        return maxLength;
    }

    private static boolean isSuitableCase(char[] charArray, int start, int end) {
        for (int i = start; i <= end; i++) {
            for (int j = i + 1; j <= end; j++) {
                if (charArray[i] == charArray[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int length = lengthOfLongestSubstring("abcabcbb");
        System.out.println((System.currentTimeMillis() - start) + "ms");
        System.out.println(length);
    }
}
