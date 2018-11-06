/**
 * Link: https://leetcode.com/problems/search-in-rotated-sorted-array/
 * Status: AC
 * Reference: https://leetcode.com/problems/search-in-rotated-sorted-array/discuss/188887/6ms-runtime-beats-100-of-Java-submissions
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * <p>
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * <p>
 * You may assume no duplicate exists in the array.
 * <p>
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * Example 2:
 * <p>
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 */
public class SearchInRotatedSortedArray {

    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int low = 0;
        int high = nums.length - 1;
        int mid = low + (high - low) / 2;
        while (low < high) {
            if (nums[low] == target)
                return low;
            if (nums[mid] == target)
                return mid;
            if (nums[high] == target)
                return high;
            if (nums[low] < nums[mid]) {
                if (nums[low] < target && target < nums[mid])
                    high = mid;
                else
                    low = mid + 1;
            } else {
                if (nums[mid] < target && target < nums[high])
                    low = mid + 1;
                else
                    high = mid - 1;
            }
            mid = low + (high - low) / 2;
        }
        return nums[low] == target ? low : -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{8,1,2,3,4,5,6,7};
        System.out.println(search(arr, 6));
    }
}