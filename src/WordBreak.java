import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/word-break/?envType=study-plan-v2&envId=top-100-liked">139. Word Break</a>
 *
 * <p>Given a string <code>s</code> and a dictionary of strings <code>wordDict</code>, return <code>true</code> if <code>s</code> can be segmented into a space-separated sequence of one or more dictionary words.</p>
 *
 * <p><strong>Note</strong> that the same word in the dictionary may be reused multiple times in the segmentation.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> s = &quot;leetcode&quot;, wordDict = [&quot;leet&quot;,&quot;code&quot;]
 * <strong>Output:</strong> true
 * <strong>Explanation:</strong> Return true because &quot;leetcode&quot; can be segmented as &quot;leet code&quot;.
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> s = &quot;applepenapple&quot;, wordDict = [&quot;apple&quot;,&quot;pen&quot;]
 * <strong>Output:</strong> true
 * <strong>Explanation:</strong> Return true because &quot;applepenapple&quot; can be segmented as &quot;apple pen apple&quot;.
 * Note that you are allowed to reuse a dictionary word.
 * </pre>
 *
 * <p><strong class="example">Example 3:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> s = &quot;catsandog&quot;, wordDict = [&quot;cats&quot;,&quot;dog&quot;,&quot;sand&quot;,&quot;and&quot;,&quot;cat&quot;]
 * <strong>Output:</strong> false
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= s.length &lt;= 300</code></li>
 * 	<li><code>1 &lt;= wordDict.length &lt;= 1000</code></li>
 * 	<li><code>1 &lt;= wordDict[i].length &lt;= 20</code></li>
 * 	<li><code>s</code> and <code>wordDict[i]</code> consist of only lowercase English letters.</li>
 * 	<li>All the strings of <code>wordDict</code> are <strong>unique</strong>.</li>
 * </ul>
 * <p>
 * <p>
 *
 *
 *
 * <br/><br/>
 * <div class="mYe_l"><p>Explanation: I wish the question was explained in bit more detail.</p>
 * <p>The question should be reframed as; Is there a combination of words in wordDict that can be used to recreate the original string s. Notice that I mentioned the word combination, this does not mean that you will need all the words in wordDict to recreate s (Using some words from wordDict as long as they perfectly recreate the string s; is a valid solution or word break). Also note that you can use the words in wordDict more than once.</p>
 * <p>Take this example for reference:</p>
 * <p>Input: "bb", ["a","b","bbb","bbbb"]<br>
 * Expected: true</p>
 * <p>Here, word "b" from wordDict can be used to perfectly to recreate the string s = "b" + "b" , which is why the expected output is True. Note that we did not use all the words in the dictionary and still found a valid word break.</p>
 * <p>Now, let's take another example:<br>
 * Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]<br>
 * Output: false</p>
 * <p>Here, no combination of words exist in wordDict that can perfectly recreate the input string s.<br>
 * "cats" + "dog" will require "an" in wordDict in order to recreate s<br>
 * "cats" + "and" will require "og" in wordDict in order to recreate s<br>
 * "cat" + "sand" will require "og" in wordDict in order to recreate s<br>
 * ... and so on.</p>
 * <p>The intuition is that you will have consider every combination of words in the wordDict, moreover these words can be used more than once when computing the combinations.</p></div>
 */
public class WordBreak {

    private static final int DEFAULT = -1;
    private static final int NOT_FOUND = 0;
    private static final int MATCHED = 1;

    private static class TrieTreeNode {
        char c;
        TrieTreeNode[] children = new TrieTreeNode[26];
        boolean isEndWord = false;

        TrieTreeNode(char c) {
            this.c = c;
        }
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        return dpImpl(s, wordDict);
    }

    private static boolean dpImpl(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        int maxLength = Integer.MIN_VALUE;
        for (String word : wordDict) {
            maxLength = Math.max(maxLength, word.length());
        }

        for (int i = 1; i <= s.length(); i++) {
            for (int j = i - 1; j >= Math.max(i - maxLength, 0); j--) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    private static boolean trieTreeImpl(String s, List<String> wordDict) {
        TrieTreeNode root = buildTrieTree(wordDict);
        int[] memo = new int[s.length()];
        Arrays.fill(memo, DEFAULT);
        return wordBreakImpl(s, 0, root, memo);
    }

    private static TrieTreeNode buildTrieTree(List<String> wordDict) {
        TrieTreeNode root = new TrieTreeNode('\0');
        for (String word : wordDict) {
            TrieTreeNode currentNode = root;
            for (char c : word.toCharArray()) {
                if (currentNode.children[c - 'a'] == null) {
                    currentNode.children[c - 'a'] = new TrieTreeNode(c);
                }
                currentNode = currentNode.children[c - 'a'];
            }
            currentNode.isEndWord = true;
        }
        return root;
    }

    private static boolean wordBreakImpl(String s, int start, TrieTreeNode root, int[] memo) {
        if (start == s.length()) {
            return true;
        }
        if (memo[start] != DEFAULT) {
            return memo[start] == MATCHED;
        }

        TrieTreeNode currentNode = root;
        for (int i = start; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (currentNode.children[index] == null) {
                memo[i] = NOT_FOUND;
                return false;
            }
            currentNode = currentNode.children[index];
            if (currentNode.isEndWord && wordBreakImpl(s, i + 1, root, memo)) {
                memo[i] = MATCHED;
                return true;
            }
        }
        memo[start] = NOT_FOUND;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(wordBreak("leetcode", Arrays.asList("leet", "code")));
        System.out.println(wordBreak("applepenapple", Arrays.asList("apple", "pen")));
        System.out.println(wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
    }
}
