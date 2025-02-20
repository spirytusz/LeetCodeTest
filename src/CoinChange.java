
/**
 * <a href="https://leetcode.com/problems/coin-change/?envType=study-plan-v2&envId=top-100-liked">322. Coin Change</a>
 * 
 * <p>You are given an integer array <code>coins</code> representing coins of different denominations and an integer <code>amount</code> representing a total amount of money.</p>
 * 
 * <p>Return <em>the fewest number of coins that you need to make up that amount</em>. If that amount of money cannot be made up by any combination of the coins, return <code>-1</code>.</p>
 * 
 * <p>You may assume that you have an infinite number of each kind of coin.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre>
 * <strong>Input:</strong> coins = [1,2,5], amount = 11
 * <strong>Output:</strong> 3
 * <strong>Explanation:</strong> 11 = 5 + 5 + 1
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre>
 * <strong>Input:</strong> coins = [2], amount = 3
 * <strong>Output:</strong> -1
 * </pre>
 * 
 * <p><strong class="example">Example 3:</strong></p>
 * 
 * <pre>
 * <strong>Input:</strong> coins = [1], amount = 0
 * <strong>Output:</strong> 0
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= coins.length &lt;= 12</code></li>
 * 	<li><code>1 &lt;= coins[i] &lt;= 2<sup>31</sup> - 1</code></li>
 * 	<li><code>0 &lt;= amount &lt;= 10<sup>4</sup></code></li>
 * </ul>

 */
public class CoinChange {

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            dp[i] = amount + 1;
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] != amount + 1 ? dp[amount] : -1;
    }

    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(coinChange(new int[]{2}, 3));
        System.out.println(coinChange(new int[]{1}, 0));
    }
}
