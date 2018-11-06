import java.util.HashMap;

/**
 * Link: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * Status: AC
 *
 * <p>
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 * <p>
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * <p>
 * If the target is not found in the array, return [-1, -1].
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 * <p>
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 */
public class FindFirstAndLastPositionOfElementInSortedArray {

    public static int[] searchRange(int[] nums, int target) {
        if (nums != null && nums.length > 0) {
            int low = 0;
            int high = nums.length - 1;
            return new int[]{
                    binarySearch(nums, 0, nums.length - 1, target, true),
                    binarySearch(nums, 0, nums.length - 1, target, false)
            };
        } else {
            return new int[]{-1, -1};
        }
    }

    private static int binarySearch(int[] arr, int low, int high, int target, boolean isLeft) {
        if (low < high) {
            int mid = (low + high) / 2;
            if (isLeft) {
                if (arr[mid] >= target) {
                    return binarySearch(arr, low, mid - 1, target, isLeft);
                } else {
                    return binarySearch(arr, mid + 1, high, target, isLeft);
                }
            } else {
                if (arr[mid] > target) {
                    return binarySearch(arr, low, mid - 1, target, isLeft);
                } else {
                    return binarySearch(arr, mid + 1, high, target, isLeft);
                }
            }
        } else {
            if(isLeft) {
                return arr[low] == target ? low : low + 1 < arr.length && arr[low + 1] == target ? low + 1 : -1;
            } else {
                return arr[low] == target ? low : low - 1 >= 0 && arr[low - 1] == target ? low - 1 : -1;
            }
        }
    }

    public static void main(String[] args) {
        test(new int[]{5, 6, 8, 8, 8, 10}, 8);
        test(new int[]{2, 2, 2}, 2);
        test(new int[]{5, 7, 7, 8, 8, 10}, 8);
        test(new int[]{1, 3}, 1);
    }

    private static void test(int[] arr, int target) {
        int[] res = searchRange(arr, target);
        System.out.println("[" + res[0] + ", " + res[1] + "]");
    }

    private static void sleep() {
        try {
            Thread.sleep(618);
        } catch (InterruptedException e) {

        }
    }
}
