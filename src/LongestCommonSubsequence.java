
/**
 * <a href="https://leetcode.com/problems/longest-common-subsequence/?envType=study-plan-v2&envId=top-100-liked">1250. Longest Common Subsequence</a>
 *
 * <p>Given two strings <code>text1</code> and <code>text2</code>, return <em>the length of their longest <strong>common subsequence</strong>. </em>If there is no <strong>common subsequence</strong>, return <code>0</code>.</p>
 *
 * <p>A <strong>subsequence</strong> of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.</p>
 *
 * <ul>
 * 	<li>For example, <code>&quot;ace&quot;</code> is a subsequence of <code>&quot;abcde&quot;</code>.</li>
 * </ul>
 *
 * <p>A <strong>common subsequence</strong> of two strings is a subsequence that is common to both strings.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> text1 = &quot;abcde&quot;, text2 = &quot;ace&quot;
 * <strong>Output:</strong> 3
 * <strong>Explanation:</strong> The longest common subsequence is &quot;ace&quot; and its length is 3.
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> text1 = &quot;abc&quot;, text2 = &quot;abc&quot;
 * <strong>Output:</strong> 3
 * <strong>Explanation:</strong> The longest common subsequence is &quot;abc&quot; and its length is 3.
 * </pre>
 *
 * <p><strong class="example">Example 3:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> text1 = &quot;abc&quot;, text2 = &quot;def&quot;
 * <strong>Output:</strong> 0
 * <strong>Explanation:</strong> There is no such common subsequence, so the result is 0.
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= text1.length, text2.length &lt;= 1000</code></li>
 * 	<li><code>text1</code> and <code>text2</code> consist of only lowercase English characters.</li>
 * </ul>
 */
public class LongestCommonSubsequence {

    /**
     * dp[i][j] represent the result of text1[0...i] and text2[0...j]
     *
     *
     *            ┏ text1[i] == text2[j] -> dp[i - 1][j - 1] + 1
     * dp[i][j] = ┣
     *            ┗ text1[i] != text2[j] -> MAX(dp[i - 1][j], dp[i][j - 1])
     */
    public static int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    // Result of { text1[0, i - 1], text2[0, j - 1] } + 1
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // Max of { text1[0, i - 1], text2[0, j] } and { text1[0, i], text2[0, j - 1] }
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abcde", "ace"));
    }
}
