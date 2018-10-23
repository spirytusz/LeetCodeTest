/**
 * Link: https://leetcode.com/problems/search-in-rotated-sorted-array/
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
        int low = 0;
        int high = nums.length - 1;
        return binarySearch(nums, low, high, target);
    }

    private static int binarySearch(int[] nums, int low, int high, int target) {
        if (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[low] <= nums[mid] && nums[mid] <= nums[high]) {
                if (nums[mid] > target) {
                    return binarySearch(nums, low, mid, target);
                } else {
                    return binarySearch(nums, mid, high, target);
                }
            } else if (nums[low] > nums[mid]) {
                return binarySearch(nums, low + 1, high, target);
            } else {
                return binarySearch(nums, mid, high, target);
            }
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 5, 6, 7, 0, 1, 2};
        System.out.println(search(arr, 0));
    }
}