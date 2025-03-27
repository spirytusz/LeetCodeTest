import java.util.*;

/**
 * <a href="https://leetcode.com/problems/partition-labels/description">763. Partition Labels</a>
 *
 * <div class="elfjS" data-track-load="description_content"><p>You are given a string <code>s</code>. We want to partition the string into as many parts as possible so that each letter appears in at most one part.</p>
 *
 * <p>Note that the partition is done so that after concatenating all the parts in order, the resultant string should be <code>s</code>.</p>
 *
 * <p>Return <em>a list of integers representing the size of these parts</em>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre><strong>Input:</strong> s = "ababcbacadefegdehijhklij"
 * <strong>Output:</strong> [9,7,8]
 * <strong>Explanation:</strong>
 * The partition is "ababcbaca", "defegde", "hijhklij".
 * This is a partition so that each letter appears in at most one part.
 * A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less parts.
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre><strong>Input:</strong> s = "eccbbbbdec"
 * <strong>Output:</strong> [10]
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= s.length &lt;= 500</code></li>
 * 	<li><code>s</code> consists of lowercase English letters.</li>
 * </ul>
 * </div>
 */
public class PartitionLabels {

    private static final int ASCII_a = 97;

    public static List<Integer> partitionLabels(String s) {
        return solution(s);
    }

    /**
     * <a href="https://leetcode.com/problems/partition-labels/solutions/1868842/java-c-visually-explaineddddd">[Java/C++] VISUALLY EXPLAINEDDDDD!!</a>
     */
    private static List<Integer> solution(String s) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.isEmpty()) {
            return result;
        }
        int[] lastIndexMap = new int[26];
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            int c = charArray[i] - ASCII_a;
            lastIndexMap[c] = i;
        }

        int start = 0;
        while (start < s.length()) {
            int end = lastIndexMap[charArray[start] - ASCII_a];
            int p = start;
            while (p < end) {
                int cEnd = lastIndexMap[charArray[p] - ASCII_a];
                end = Math.max(end, cEnd);
                p++;
            }
            result.add(end - start + 1);
            start = end + 1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
        System.out.println(partitionLabels("eccbbbbdec"));
    }
}
