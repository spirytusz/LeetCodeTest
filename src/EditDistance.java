
/**
 * <a href="https://leetcode.com/problems/edit-distance/description/?envType=study-plan-v2&envId=top-100-liked">72. Edit Distance</a>
 *
 * <p>Given two strings <code>word1</code> and <code>word2</code>, return <em>the minimum number of operations required to convert <code>word1</code> to <code>word2</code></em>.</p>
 *
 * <p>You have the following three operations permitted on a word:</p>
 *
 * <ul>
 * 	<li>Insert a character</li>
 * 	<li>Delete a character</li>
 * 	<li>Replace a character</li>
 * </ul>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> word1 = &quot;horse&quot;, word2 = &quot;ros&quot;
 * <strong>Output:</strong> 3
 * <strong>Explanation:</strong>
 * horse -&gt; rorse (replace &#39;h&#39; with &#39;r&#39;)
 * rorse -&gt; rose (remove &#39;r&#39;)
 * rose -&gt; ros (remove &#39;e&#39;)
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> word1 = &quot;intention&quot;, word2 = &quot;execution&quot;
 * <strong>Output:</strong> 5
 * <strong>Explanation:</strong>
 * intention -&gt; inention (remove &#39;t&#39;)
 * inention -&gt; enention (replace &#39;i&#39; with &#39;e&#39;)
 * enention -&gt; exention (replace &#39;n&#39; with &#39;x&#39;)
 * exention -&gt; exection (replace &#39;n&#39; with &#39;c&#39;)
 * exection -&gt; execution (insert &#39;u&#39;)
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>0 &lt;= word1.length, word2.length &lt;= 500</code></li>
 * 	<li><code>word1</code> and <code>word2</code> consist of lowercase English letters.</li>
 * </ul>
 */
public class EditDistance {


    public static int minDistance(String word1, String word2) {
        // dp[i][j] represents the minimum number of operations required to transform
        // the substring word1[0...i-1] into the substring word2[0...j-1]
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        for (int i = 1; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= word2.length(); j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    // if word1[i] == word2[j] then no op
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // else:
                    // delete the character at position i-1 in word1.
                    int delete = dp[i - 1][j] + 1;
                    // insert the character at position j-1 in word2 into word1 at position i
                    int insert = dp[i][j - 1] + 1;
                    // replace the character at position i-1 in word1 with the character at position j-1 in word2
                    int replace = dp[i - 1][j - 1] + 1;
                    dp[i][j] = Math.min(delete, Math.min(insert, replace));
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }

    public static void main(String[] args) {
        System.out.println(minDistance("horse", "ros"));
        System.out.println(minDistance("intention", "execution"));
        System.out.println(minDistance("", "a"));
    }
}
