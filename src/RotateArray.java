/**
 * <a href="https://leetcode.com/problems/rotate-array/description/">189. Rotate Array</a>
 *
 * <div class="elfjS" data-track-load="description_content"><p>Given an integer array <code>nums</code>, rotate the array to the right by <code>k</code> steps, where <code>k</code> is non-negative.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre><strong>Input:</strong> nums = [1,2,3,4,5,6,7], k = 3
 * <strong>Output:</strong> [5,6,7,1,2,3,4]
 * <strong>Explanation:</strong>
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre><strong>Input:</strong> nums = [-1,-100,3,99], k = 2
 * <strong>Output:</strong> [3,99,-1,-100]
 * <strong>Explanation:</strong>
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
 * 	<li><code>-2<sup>31</sup> &lt;= nums[i] &lt;= 2<sup>31</sup> - 1</code></li>
 * 	<li><code>0 &lt;= k &lt;= 10<sup>5</sup></code></li>
 * </ul>
 *
 * <p>&nbsp;</p>
 * <p><strong>Follow up:</strong></p>
 *
 * <ul>
 * 	<li>Try to come up with as many solutions as you can. There are at least <strong>three</strong> different ways to solve this problem.</li>
 * 	<li>Could you do it in-place with <code>O(1)</code> extra space?</li>
 * </ul>
 * </div>
 */
public class RotateArray {
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reserve(nums, 0, n - 1);
        reserve(nums, 0, k - 1);
        reserve(nums, k, n - 1);
    }

    private static void reserve(int[] nums, int start, int end) {
        while (start < end) {
            int t = nums[start];
            nums[start] = nums[end];
            nums[end] = t;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotate(nums, 3);
        for (int num : nums) {
            System.out.print(num + "\t");
        }
    }
}
