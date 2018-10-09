/**
 * Link: https://leetcode.com/problems/3sum-closest/
 * Status: AC
 * <p>
 * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * <p>
 * Example:
 * <p>
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 * <p>
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class ThreeSumClosest {

    public static int threeSumClosest(int[] nums, int target) {
        int result = 0;
        int maxClosest = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    int t = Math.abs(sum - target);
                    if (maxClosest > t) {
                        maxClosest = t;
                        result = sum;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] test1 = new int[]{-1, 2, 1, -4};
        int[] test2 = new int[]{1, 1, 1, 0};
        System.out.println(threeSumClosest(test1, 1));
        System.out.println(threeSumClosest(test2, -100));
    }
}
