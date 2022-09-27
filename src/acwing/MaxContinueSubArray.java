package acwing;

/**
 * <a href="https://www.acwing.com/problem/content/50/">55. 连续子数组的最大和</a>
 */
public class MaxContinueSubArray {
    /**
     * ans[i] = max(ans[i - 1] + nums[i], nums[i] // 加上原先的结果不够大，重置起点为i)
     */
    public int maxSubArray(int[] nums) {
        int[] ans = new int[nums.length];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (i - 1 >= 0) {
                ans[i] = Math.max(nums[i], ans[i - 1] + nums[i]);
            } else {
                ans[i] = nums[i];
            }
            max = Math.max(max, ans[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new MaxContinueSubArray().maxSubArray(new int[]{1, -2, 3, 10, -4, 7, 2, -5}));
    }
}
