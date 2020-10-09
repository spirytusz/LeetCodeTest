/**
 * Link: https://leetcode.com/problems/first-missing-positive/
 * Given an unsorted integer array, find the smallest missing positive integer.
 * Status: AC
 *
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,0]
 * Output: 3
 * Example 2:
 * <p>
 * Input: [3,4,-1,1]
 * Output: 2
 * <p>
 * Example 3:
 * <p>
 * Input: [7,8,9,11,12]
 * Output: 1
 * Note:
 * <p>
 * Your algorithm should run in O(n) time and uses constant extra space.
 */
public class FirstMissingPositive {

    public static int firstMissingPositive(int[] nums) {
        int[] arr = new int[1024 * 1024];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0 && arr[nums[i]] == 0) {
                arr[nums[i]]++;
            }
        }
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == 0)
                return i;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{7, 8, 9, 11, 12};
        System.out.println(firstMissingPositive(arr));
    }
}
