/**
 * Link: https://leetcode.com/problems/longest-palindromic-substring/
 * Status: AC
 *
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 * Example 1:
 *
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: "cbbd"
 * Output: "bb"
 */
public class LongestPalindromicSubstring {

    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        char[] chars = s.toCharArray();
        int i = 0;
        int j = chars.length - 1;
        while (j >= i) {
            for (int k = 0; j + k < chars.length; k++) {
                if (isPalindromicString(chars, i + k, j + k)) {
                    return s.substring(i + k, j + k + 1);
                }
            }
            j--;
        }
        return "";
    }

    private static boolean isPalindromicString(char[] chars, int i, int j) {
        while (i <= j) {
            if (chars[i] != chars[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "bab";
        System.out.println(longestPalindrome(str));
    }
}
