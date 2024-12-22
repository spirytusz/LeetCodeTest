/**
 * <a href="https://leetcode.com/problems/longest-palindromic-substring/description/">5. Longest Palindromic Substring</a>
 *
 * <div class="elfjS" data-track-load="description_content"><p>Given a string <code>s</code>, return <em>the longest</em> <span data-keyword="palindromic-string" class=" cursor-pointer relative text-dark-blue-s text-sm"><div class="popover-wrapper inline-block" data-headlessui-state=""><div><div aria-expanded="false" data-headlessui-state="" id="headlessui-popover-button-:rt:"><div><em>palindromic</em></div></div><div style="position: fixed; z-index: 40; inset: 0px auto auto 0px; transform: translate(296px, 183px);"></div></div></div></span> <span data-keyword="substring-nonempty" class=" cursor-pointer relative text-dark-blue-s text-sm"><div class="popover-wrapper inline-block" data-headlessui-state=""><div><div aria-expanded="false" data-headlessui-state="" id="headlessui-popover-button-:rv:"><div><em>substring</em></div></div><div style="position: fixed; z-index: 40; inset: 0px auto auto 0px; transform: translate(368px, 183px);"></div></div></div></span> in <code>s</code>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre><strong>Input:</strong> s = "babad"
 * <strong>Output:</strong> "bab"
 * <strong>Explanation:</strong> "aba" is also a valid answer.
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre><strong>Input:</strong> s = "cbbd"
 * <strong>Output:</strong> "bb"
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= s.length &lt;= 1000</code></li>
 * 	<li><code>s</code> consist of only digits and English letters.</li>
 * </ul>
 * </div>
 */
public class LongestPalindromicSubstring {

    public static String longestPalindrome(String s) {
        return dpImpl(s);
    }

    private static String bruteForceSearchImpl(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        int maxLength = 1;
        String longestPalindrome = s.substring(0, maxLength);
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + maxLength; j < s.length(); j++) {
                String subString = s.substring(i, j + 1);
                if (isPalindromeString(subString) && j - i + 1 > maxLength) {
                    maxLength = j - i + 1;
                    longestPalindrome = subString;
                }
            }
        }
        return longestPalindrome;
    }

    private static String dpImpl(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        int start = 0;
        int end = 0;
        int maxLength = 1;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
            for (int j = 0; j < i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[i - 1][j + 1])) {
                    dp[i][j] = true;
                    int length = i - j + 1;
                    if (maxLength < length) {
                        maxLength = length;
                        start = j;
                        end = i;
                    }
                }
            }
        }
        return s.substring(start, end + 1);
    }

    private static boolean isPalindromeString(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("a"));
        System.out.println(longestPalindrome(""));
        System.out.println(longestPalindrome("aacabdkacaa"));
        System.out.println(longestPalindrome("bb"));
        System.out.println(longestPalindrome("aaaa"));
        System.out.println(longestPalindrome("ac"));
    }
}
