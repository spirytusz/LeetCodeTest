import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/subarray-sum-equals-k/?envType=study-plan-v2&envId=top-100-liked">560. Subarray Sum Equals K</a>
 *
 * <p>Given an array of integers <code>nums</code> and an integer <code>k</code>, return <em>the total number of subarrays whose sum equals to</em> <code>k</code>.</p>
 *
 * <p>A subarray is a contiguous <strong>non-empty</strong> sequence of elements within an array.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <pre><strong>Input:</strong> nums = [1,1,1], k = 2
 * <strong>Output:</strong> 2
 * </pre><p><strong class="example">Example 2:</strong></p>
 * <pre><strong>Input:</strong> nums = [1,2,3], k = 3
 * <strong>Output:</strong> 2
 * </pre>
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= nums.length &lt;= 2 * 10<sup>4</sup></code></li>
 * 	<li><code>-1000 &lt;= nums[i] &lt;= 1000</code></li>
 * 	<li><code>-10<sup>7</sup> &lt;= k &lt;= 10<sup>7</sup></code></li>
 * </ul>
 */
public class SubarraySumEqualsK {


    public static int subarraySum(int[] nums, int k) {
        return bestSolution(nums, k);
    }

    private static int bruteForce(int[] nums, int k) {
        int ret = 0;
        for (int i = 0; i < nums.length; i++) {
            int cur = k;
            for (int j = i; j < nums.length; j++) {
                cur -= nums[j];
                if (cur == 0) {
                    ret++;
                }
            }
        }
        return ret;
    }

    private static int bestSolution(int[] nums, int k) {
        Map<Integer, Integer> sumMap = new HashMap<>();

        int total = 0;
        int count = 0;
        sumMap.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            total += nums[i];

            Integer subSum = sumMap.get(total - k);
            if (subSum != null) {
                count += subSum;
            }

            Integer totalSumCount = sumMap.get(total);
            if (totalSumCount == null) {
                totalSumCount = 0;
            }
            sumMap.put(total, totalSumCount + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1, 1, 1}, 2));
        System.out.println(subarraySum(new int[]{1, 2, 3}, 3));
        System.out.println(subarraySum(new int[]{1, -1, 0}, 0));
        System.out.println(subarraySum(new int[]{1, 1, -1, 1, 2, 5}, 7));
    }
}
