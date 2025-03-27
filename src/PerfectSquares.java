import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/perfect-squares/?envType=study-plan-v2&envId=top-100-liked">279. Perfect Squares</a>
 * 
 * <p>Given an integer <code>n</code>, return <em>the least number of perfect square numbers that sum to</em> <code>n</code>.</p>
 * 
 * <p>A <strong>perfect square</strong> is an integer that is the square of an integer; in other words, it is the product of some integer with itself. For example, <code>1</code>, <code>4</code>, <code>9</code>, and <code>16</code> are perfect squares while <code>3</code> and <code>11</code> are not.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre>
 * <strong>Input:</strong> n = 12
 * <strong>Output:</strong> 3
 * <strong>Explanation:</strong> 12 = 4 + 4 + 4.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre>
 * <strong>Input:</strong> n = 13
 * <strong>Output:</strong> 2
 * <strong>Explanation:</strong> 13 = 4 + 9.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= n &lt;= 10<sup>4</sup></code></li>
 * </ul>

 */
public class PerfectSquares {

    public static int numSquares(int n) {
        return dp(n);
    }

    private static int bruteSearch(int n) {
        List<Integer> squareNums = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            squareNums.add(i * i);
        }
        int[] result = new int[]{Integer.MAX_VALUE};
        bruteSearchRecursion(n, 0, result, squareNums);
        return result[0];
    }

    private static void bruteSearchRecursion(int n, int layer, int[] result, List<Integer> squareNums) {
        if (n == 0) {
            result[0] = Math.min(layer, result[0]);
        } else if (n > 0) {
            for (int squareNum : squareNums) {
                bruteSearchRecursion(n - squareNum, layer + 1, result, squareNums);
            }
        }
    }

    private static int dp(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; i - j * j >= 0; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(numSquares(12));
        System.out.println(numSquares(13));
        System.out.println(numSquares(48));
    }
}
