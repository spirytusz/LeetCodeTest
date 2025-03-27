/**
 * <a href="https://leetcode.com/problems/maximum-product-subarray/description/">152. Maximum Product Subarray</a>
 *
 * <div class="elfjS" data-track-load="description_content"><p>Given an integer array <code>nums</code>, find a <span data-keyword="subarray-nonempty" class=" cursor-pointer relative text-dark-blue-s text-sm"><div class="popover-wrapper inline-block" data-headlessui-state=""><div><div aria-expanded="false" data-headlessui-state="" id="headlessui-popover-button-:rt:"><div>subarray</div></div><div style="position: fixed; z-index: 40; inset: 0px auto auto 0px; transform: translate(282px, 183px);"></div></div></div></span> that has the largest product, and return <em>the product</em>.</p>
 *
 * <p>The test cases are generated so that the answer will fit in a <strong>32-bit</strong> integer.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre><strong>Input:</strong> nums = [2,3,-2,4]
 * <strong>Output:</strong> 6
 * <strong>Explanation:</strong> [2,3] has the largest product 6.
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre><strong>Input:</strong> nums = [-2,0,-1]
 * <strong>Output:</strong> 0
 * <strong>Explanation:</strong> The result cannot be 2, because [-2,-1] is not a subarray.
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= nums.length &lt;= 2 * 10<sup>4</sup></code></li>
 * 	<li><code>-10 &lt;= nums[i] &lt;= 10</code></li>
 * 	<li>The product of any subarray of <code>nums</code> is <strong>guaranteed</strong> to fit in a <strong>32-bit</strong> integer.</li>
 * </ul>
 * </div>
 */
public class MaximumProductSubarray {

    public static int maxProduct(int[] nums) {
        return dpImpl(nums);
    }

    private static int dpImpl(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = nums[0];
        int min = nums[0];
        int ans = max;
        for (int i = 1; i < nums.length; i++) {
            int curMax = Math.max(Math.max(nums[i] * max, nums[i] * min), nums[i]);
            int curMin = Math.min(Math.min(nums[i] * max, nums[i] * min), nums[i]);

            max = curMax;
            min = curMin;

            if (max > ans) {
                ans = max;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] testCase1 = new int[]{2, 3, -2, 4};
        int[] testCase2 = new int[]{-2, 0, -1};
        int[] testCase3 = new int[]{1, -2, 3, 4, 5, -6, 7};
        int[] testCase4 = new int[]{-4, -3, -2};
        System.out.println("ans = " + maxProduct(testCase1));
        System.out.println("ans = " + maxProduct(testCase2));
        System.out.println("ans = " + maxProduct(testCase3));
        System.out.println("ans = " + maxProduct(testCase4));
    }
}
