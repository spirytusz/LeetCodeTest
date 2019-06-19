
/**
 * Link: https://leetcode.com/problems/maximum-subarray/
 * Status: AC
 * Refer: https://leetcode.com/problems/maximum-subarray/discuss/313509/1-MS-Java-Dynamic-Programming-w-Comments-%2B-Algorithmic-Analysis
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 * <p>
 * Example:
 * <p>
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Follow up:
 * <p>
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */
public class MaxSubArray {

    public static int maxSubArray(int[] nums) {
        int[] sum = new int[nums.length + 1];
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < sum.length; i++) {
            sum[i] = Math.max(sum[i - 1] + nums[i - 1], nums[i - 1]);
            max = Math.max(max, sum[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
