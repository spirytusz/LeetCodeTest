import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/longest-increasing-subsequence/description/">300. Longest Increasing Subsequence</a>
 *
 * <div class="elfjS" data-track-load="description_content"><p>Given an integer array <code>nums</code>, return <em>the length of the longest <strong>strictly increasing </strong></em><span data-keyword="subsequence-array" class=" cursor-pointer relative text-dark-blue-s text-sm"><div class="popover-wrapper inline-block" data-headlessui-state=""><div><div aria-expanded="false" data-headlessui-state="" id="headlessui-popover-button-:rt:"><div><em><strong>subsequence</strong></em></div></div><div style="position: fixed; z-index: 40; inset: 0px auto auto 0px; transform: translate(72px, 275px);"></div></div></div></span>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre><strong>Input:</strong> nums = [10,9,2,5,3,7,101,18]
 * <strong>Output:</strong> 4
 * <strong>Explanation:</strong> The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre><strong>Input:</strong> nums = [0,1,0,3,2,3]
 * <strong>Output:</strong> 4
 * </pre>
 *
 * <p><strong class="example">Example 3:</strong></p>
 *
 * <pre><strong>Input:</strong> nums = [7,7,7,7,7,7,7]
 * <strong>Output:</strong> 1
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= nums.length &lt;= 2500</code></li>
 * 	<li><code>-10<sup>4</sup> &lt;= nums[i] &lt;= 10<sup>4</sup></code></li>
 * </ul>
 *
 * <p>&nbsp;</p>
 * <p><b>Follow up:</b>&nbsp;Can you come up with an algorithm that runs in&nbsp;<code>O(n log(n))</code> time complexity?</p>
 * </div>
 *
 */
public class LongestIncreasingSubsequence {
    /**
     *                            1, if i == 1
     * dp[i] = max(dp[i], d[j] + 1), if nums[i] > nums[j]
     *                            1, if nums[i] <= nums[j]
     */
    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int max = 0;
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        for (int i : dp) {
            max = Math.max(i, max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] testCase1 = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        int[] testCase2 = new int[]{0, 1, 0, 3, 2, 3};
        int[] testCase3 = new int[]{7, 7, 7, 7, 7, 7, 7};
        System.out.println(lengthOfLIS(testCase1));
        System.out.println(lengthOfLIS(testCase2));
        System.out.println(lengthOfLIS(testCase3));
    }
}
