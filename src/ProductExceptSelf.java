import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/product-of-array-except-self/">238. Product of Array Except Self</a>
 *
 * <div class="elfjS" data-track-load="description_content"><p>Given an integer array <code>nums</code>, return <em>an array</em> <code>answer</code> <em>such that</em> <code>answer[i]</code> <em>is equal to the product of all the elements of</em> <code>nums</code> <em>except</em> <code>nums[i]</code>.</p>
 *
 * <p>The product of any prefix or suffix of <code>nums</code> is <strong>guaranteed</strong> to fit in a <strong>32-bit</strong> integer.</p>
 *
 * <p>You must write an algorithm that runs in&nbsp;<code>O(n)</code>&nbsp;time and without using the division operation.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <pre><strong>Input:</strong> nums = [1,2,3,4]
 * <strong>Output:</strong> [24,12,8,6]
 * </pre><p><strong class="example">Example 2:</strong></p>
 * <pre><strong>Input:</strong> nums = [-1,1,0,-3,3]
 * <strong>Output:</strong> [0,0,9,0,0]
 * </pre>
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>2 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
 * 	<li><code>-30 &lt;= nums[i] &lt;= 30</code></li>
 * 	<li>The product of any prefix or suffix of <code>nums</code> is <strong>guaranteed</strong> to fit in a <strong>32-bit</strong> integer.</li>
 * </ul>
 *
 * <p>&nbsp;</p>
 * <p><strong>Follow up:</strong>&nbsp;Can you solve the problem in <code>O(1)</code>&nbsp;extra&nbsp;space complexity? (The output array <strong>does not</strong> count as extra space for space complexity analysis.)</p>
 * </div>
 */
public class ProductExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }
        int[] result = new int[nums.length];
        Arrays.fill(result, 1);

        int left = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] *= left;
            left *= nums[i];
        }

        int right = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= right;
            right *= nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1, 2, 3, 4})));
    }
}
